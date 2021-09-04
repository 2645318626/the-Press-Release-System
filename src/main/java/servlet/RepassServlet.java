package servlet;

import bean.User;
import email.Sendmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="RepassServlet",value="/repassServlet")
public class RepassServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //接收用户请求，封装成对象
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            /*检测用户名及用户邮箱是否正确*/
            User user = new User(username,email);

            //检测成功之后，给用户发送一封邮件
            //我们使用线程来专门发送邮件，防止出现耗时，和网站注册人数过多的情况；
            Sendmail send = new Sendmail(user);
            //启动线程，线程启动之后就会执行run方法来发送邮件
            send.start();

            //注册用户
            request.setAttribute("message", "我们已经了更改密码的网址到您的邮箱");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "发送失败");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

