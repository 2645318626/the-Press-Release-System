package dao.impl;

import bean.Category;
import bean.News;
import dao.CategoryDao;

import java.sql.Connection;
import java.util.List;

/**
 * @author : author
 * @date : 0:23 2021/7/1
 */
public class CategoryDaoImpl extends BaseDao implements CategoryDao {
    @Override
    public List<Category> queryNewsTypeList(Connection conn) {
        String sql="select * from category";
        return queryForList(conn,Category.class,sql);
    }

    @Override
    public int addNewsType(Connection conn,String type) {
        String sql="insert into category(`type`) value(?)";
        return update(conn,sql,type);
    }

    @Override
    public int deleteNewsTypeBySid(Connection conn,int sid) {
        String sql="delete from category where sid=?";
        return update(conn,sql,sid);
    }

    @Override
    public News queryNewsListBySid(Connection conn,int sid) {
        String sql="select * from category where sid=?";
        return queryForOne(conn,News.class,sql,sid);
    }
}
