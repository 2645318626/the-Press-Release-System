package dbutil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author : author
 * @date : 19:50 2021/6/19
 */
public class DBUtil {
//    private static String driverClass;
//    private static String url;
//    private static String admin;
//    private static String pwd;
//    private static Connection connection;

    public DBUtil() {
    }


    public static Connection getConnection() throws Exception {
        InputStream inputStream=DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
//            FileInputStream inputStream = new FileInputStream("src/main/resources/db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        String driverClass = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String admin = properties.getProperty("admin");
        String pwd = properties.getProperty("pwd");
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, admin, pwd);
        return connection;
    }

    public static void close(Connection connection,Statement statement){
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection,Statement statement,ResultSet resultSet){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
