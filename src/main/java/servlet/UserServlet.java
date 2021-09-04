package servlet;

import bean.Admin;
import bean.User;
import com.sun.mail.util.MailSSLSocketFactory;
import dao.AdminDao;
import dao.UserDao;
import dao.impl.AdminDaoImpl;
import dao.impl.UserDaoImpl;
import dbutil.DBUtil;
import dbutil.WebUtils;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author : author
 * @date : 23:18 2021/6/23
 */
@WebServlet(name = "UserServlet", value = "/userServlet")
public class UserServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        System.out.println(action);
        try {
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void adminLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminLogUsername = req.getParameter("adminLogUsername");
        String adminLogPassword = req.getParameter("adminLogPassword");
        AdminDao adminDao = new AdminDaoImpl();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            if (adminDao.queryAdminByUsername(conn, adminLogUsername) == null) {
                req.getRequestDispatcher("/index.jsp?error=no").forward(req, resp);
            }
            if (adminDao.queryAdminByUsernameAndPassword(conn,adminLogUsername, adminLogPassword) != null){
                req.getSession().setAttribute("adminName",adminLogUsername);
                req.getRequestDispatcher("/index.jsp?error=yes").forward(req, resp);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void pudate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("repPassword");
        String repUsername = req.getParameter("repUsername");
        UserDao userDao = new UserDaoImpl();
        System.out.println(password+repUsername);
        Connection conn=null;
        try {
            conn = DBUtil.getConnection();
            String username=null;
            username = (String) req.getServletContext().getAttribute("repUsername");
            if (username.equals(repUsername)){
                System.out.println("修改");
                userDao.updateUser(conn,repUsername,password);
                req.getRequestDispatcher("/pages/user/repass.jsp?error=yes").forward(req, resp);
            }else{
                req.getRequestDispatcher("/pages/user/repass.jsp?error=no").forward(req, resp);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void repass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, GeneralSecurityException, MessagingException {
        String from = "2645318626@qq.com";//邮件发送方
        String authorizationCode = "ncdfjgbqxqtrebhf";//发送方邮箱的授权码
        String host = "smtp.qq.com";//发送邮件的服务器地址

        //接收用户请求，封装成对象
        String repUsername = req.getParameter("repUsername");
        String repEmail = req.getParameter("repEmail");
        UserDao userDao = new UserDaoImpl();
        Connection conn=null;
        User user = new User();
        user.setUsername(repUsername);
        user.setEmail(repEmail);
        try {
            conn = DBUtil.getConnection();
            if (userDao.queryUserByUsernameAndEmail(conn,repUsername,repEmail) == null ){
                req.getRequestDispatcher("/index.jsp?error=failure").forward(req, resp);
            }else{
                req.getServletContext().setAttribute("repUsername",repUsername);
                Properties prop = new Properties();
                prop.setProperty("mail.host", host);
                prop.setProperty("mail.transport.protocol", "smtp");
                prop.setProperty("mail.smtp.auth", "true");

                // 关于QQ邮箱，还要设置SSL加密，加上以下代码即可
                MailSSLSocketFactory sf = new MailSSLSocketFactory();
                sf.setTrustAllHosts(true);
                prop.put("mail.smtp.ssl.enable", "true");
                prop.put("mail.smtp.ssl.socketFactory", sf);

                //1、创建定义整个应用程序所需的环境信息的 Session 对象
                Session session = Session.getDefaultInstance(prop, new Authenticator() {
                    public PasswordAuthentication getPasswordAuthentication() {
                        //发件人邮件用户名、授权码
    //                    return new PasswordAuthentication(from, "njbsbirrpaclbhaa");
                        return new PasswordAuthentication(from, authorizationCode);
                    }
                });

                //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
                session.setDebug(true);

                //2、通过session得到transport对象
                Transport ts = session.getTransport();

                //3、使用邮箱的用户名和授权码连上邮件服务器
                ts.connect(host, from, authorizationCode);

                //4、创建邮件
                MimeMessage mimeMessage = new MimeMessage(session);
                mimeMessage.setFrom(new InternetAddress(from)); //发件人
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail())); //收件人
                mimeMessage.setSubject("用户修改密码邮件"); //邮件的标题
                mimeMessage.setContent(user.getUsername() + " 您好，请点击网址修改密码：<a href='"+req.getRequestURL()+"'/userServlet'>修改密码界面</a>", "text/html;charset=UTF-8");
                mimeMessage.saveChanges();

                //发送邮件
                ts.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
                ts.close();
                req.getRequestDispatcher("/index.jsp?error=repass").forward(req, resp);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void middle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/user/repass.jsp").forward(req,resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/user/repass.jsp").forward(req,resp);
    }

    public void userLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String logUsername = req.getParameter("logUsername");
        String logPassword = req.getParameter("logPassword");
        UserDao userDao = new UserDaoImpl();
        Connection conn=null;
        try {
            conn = DBUtil.getConnection();
            if (userDao.queryUserByUsername(conn,logUsername) == null) {
                req.getRequestDispatcher("/index.jsp?error=no").forward(req, resp);
            }
            if (userDao.queryUserByUsernameAndPassword(conn,logUsername, logPassword) != null) {
                req.getSession().setAttribute("username",logUsername);
                req.getRequestDispatcher("/index.jsp?error=yes").forward(req, resp);
            } else {
                req.getRequestDispatcher("/index.jsp?error=failure").forward(req, resp);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }


    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql = null;
        String regUsername = req.getParameter("regUsername");
        String regPassword = req.getParameter("regPassword");
        String telphone = req.getParameter("telphone");
        String email = req.getParameter("email");
        UserDao userDao = new UserDaoImpl();
        System.out.println("注册");
        Connection conn = null;
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        System.out.println(user);
        try {
            conn = DBUtil.getConnection();
            if (userDao.queryUserByUsername(conn,regUsername) != null) {
                req.getRequestDispatcher("/pages/user/register.jsp?error=no").forward(req, resp);
            } else {
                userDao.saveUser(conn,user);
                req.getRequestDispatcher("/pages/user/index.jsp?error=success").forward(req, resp);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }


}
