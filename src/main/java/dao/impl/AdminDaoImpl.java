package dao.impl;

import bean.Admin;
import dao.AdminDao;

import java.sql.Connection;

/**
 * @author : author
 * @date : 21:11 2021/6/30
 */
public class AdminDaoImpl extends BaseDao implements AdminDao {
    @Override
    public Admin queryAdminByUsername(Connection conn, String adminUsername) {
        String sql = "select `id`,`username`,`password`,`email` from admin where username = ?";
        return queryForOne(conn,Admin.class, sql, adminUsername);
    }


    @Override
    public Admin queryAdminByUsernameAndPassword(Connection conn,String adminUsername, String adminPassword) {
        String sql = "select `id`,`username`,`password`,`email` from admin where username = ? and password = ?";
        return queryForOne(conn,Admin.class, sql, adminUsername,adminPassword);
    }

    @Override
    public int saveAdmin(Connection conn,Admin admin) {
        String sql = "insert into admin(`username`,`password`) values(?,?)";
        return update(conn,sql, admin.getUsername(),admin.getPassword(),admin.getId(),admin.getEmail());
    }
}
