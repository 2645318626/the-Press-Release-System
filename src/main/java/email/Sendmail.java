package email;


import bean.User;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class Sendmail extends Thread {

    //用于给用户发送邮件的邮箱
//    private String from = "137136083@qq.com";
    private String from = "2645318626@qq.com";
    //邮箱的用户名
    private String username = "用户名";/*用户名*/
    //邮箱的密码
//    private String authorizationCode  = "njbsbirrpaclbhaa";
    private String authorizationCode  = "ncdfjgbqxqtrebhf";
    //发送邮件的服务器地址
    private String host = "smtp.qq.com";

    private User user;
    public Sendmail(User user){
        this.user = user;
    }


    //重写run方法的实现，在run方法中发送邮件给指定的用户
    @Override
    public void run() {
        try{
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
                    return new PasswordAuthentication(from, authorizationCode );
                }
            });

            //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
            session.setDebug(true);

            //2、通过session得到transport对象
            Transport ts = session.getTransport();

            //3、使用邮箱的用户名和授权码连上邮件服务器
            ts.connect(host, from, authorizationCode );

            //4、创建邮件
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(from)); //发件人
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail())); //收件人
            mimeMessage.setSubject("用户注册邮件"); //邮件的标题

            String address = "/找回密码.html";
            String info = user.getUsername() + "您好，请点击网址修改密码：" + address;
            mimeMessage.setContent(info, "text/html;charset=UTF-8");
//            mimeMessage.saveChanges();

            //发送邮件
            ts.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            ts.close();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

