package dao;

import bean.User;

import java.sql.Connection;

public interface UserDao {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 如果返回null, 说明没有这个用户。反之亦然
     */
    public User queryUserByUsername(Connection conn,String username);

    /**
     * 根据 用户名和密码查询用户信息
     *
     * @param username
     * @param password
     * @return 如果返回null, 说明用户名或密码错误, 反之亦然
     */
    public User queryUserByUsernameAndPassword(Connection conn,String username, String password);

    /**
     * 保存用户信息
     *
     * @param user
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int saveUser(Connection conn,User user);

    /**
     * 保存用户信息
     *
     * @param username
     * @param email
     * @return 如果返回null, 说明用户名或密码错误, 反之亦然
     */
    public User queryUserByUsernameAndEmail(Connection conn,String username, String email);

    /**
     * 根据用户的用户名修改用户信息
     *
     * @param username
     * @param password
     * @return 如果返回-1, 说明修改失败, 反之亦然
     */
    public int updateUser(Connection conn,String username,String password);

}
