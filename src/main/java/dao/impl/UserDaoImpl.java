package dao.impl;


import bean.User;
import dao.UserDao;

import java.sql.Connection;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(Connection conn, String username) {
        String sql = "select `id`,`username`,`password`,`email`,`telphone` from user where username = ?";
        return queryForOne(conn,User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(Connection conn,String username, String password) {
        String sql = "select `id`,`username`,`password`,`email`,`telphone` from user where username = ? and password = ?";
        return queryForOne(conn,User.class, sql, username,password);
    }

    @Override
    public int saveUser(Connection conn,User user) {
        String sql = "insert into user(`username`,`password`,`email`,`telphone`) values(?,?,?,?)";
        return update(conn,sql, user.getUsername(),user.getPassword(),user.getEmail(),user.getTelphone(),user.getId());
    }

    @Override
    public User queryUserByUsernameAndEmail(Connection conn,String username, String email) {
        String sql="select `id`,`username`,`password`,`email`,`telphone` from user where username = ? and email = ?";
        return queryForOne(conn,User.class,sql,username,email);
    }

    @Override
    public int updateUser(Connection conn, String username, String password) {
        String sql="update user set password=? where username=?";
        return update(conn,sql,password,username);
    }

}
