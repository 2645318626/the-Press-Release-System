package dao.impl;

import bean.News;
import dao.NewsDao;

import java.sql.Connection;
import java.util.List;

/**
 * @author : author
 * @date : 22:45 2021/6/30
 */
public class NewsDaoImpl extends BaseDao implements NewsDao {

    @Override
    public List<News> queryNewsList(Connection conn) {
        String sql="select *from news";
        return queryForList(conn,News.class,sql);
    }

    @Override
    public int addNews(Connection conn,News news) {
        String sql="insert into news(`title`,`author`,`content`,`type`,`imgPath`,`publisher`,`getDate`,`keyWords`) values(?,?,?,?,?,?,?,?)";
        return update(conn,sql,news.getTitle(),news.getAuthor(),news.getContent(),news.getType(),news.getImgPath(),news.getPublisher(),news.getGetDate(),news.getKeyWords());
    }


    @Override
    public int deleteNewsById(Connection conn,int id) {
        String sql="delete from news where id = ?";
        return update(conn,sql,id);
    }

    @Override
    public int updateNews(Connection conn,News news) {
        String sql="update news set `title`=?,`author`=?,`content`=?,`type`=?,`imgPath`=?,`getDate`=?,`keyWords`=? where id =?";
        return update(conn,sql,news.getType(),news.getAuthor(),news.getContent(),news.getType(),news.getImgPath(),news.getGetDate(),news.getKeyWords(),news.getId());
    }

    @Override
    public News queryNewsById(Connection conn,int id) {
        String sql="select * from news where id=?";
        return queryForOne(conn,News.class,sql,id);
    }

    @Override
    public List<News> queryNewsByPublisher(Connection conn,String publisher) {
        String sql="select * from news where publisher=?";
        return queryForList(conn,News.class,sql,publisher);
    }

    @Override
    public List<News> queryNewsByType(Connection conn,String type) {
        String sql="select * from news where type=?";
        return queryForList(conn,News.class,sql,type);
    }

    @Override
    public List<News> queryNewsListBySearchKey(Connection conn,String searchKey) {
        String sql="select * from news where concat(title,content,type,author,keyWords) like ?";
        return queryForList(conn,News.class,sql,searchKey);
    }

    @Override
    public List<News> queryNewsListByKeyWords(Connection conn,String keyWords) {
        String sql= "select * from news where keyWords like ?";
        return queryForList(conn,News.class,sql,keyWords);
    }

    @Override
    public List<News> queryNewsListByType(Connection conn,String type) {
        String sql="select * from news where type=?";
        return queryForList(conn,News.class,sql,type);
    }

    @Override
    public List<News> queryNewsListByTime(Connection conn) {
        String sql="SELECT * FROM `news` ORDER BY getDate DESC";
        return queryForList(conn,News.class,sql);
    }

    @Override
    public int deleteNewsByType(Connection conn,String type) {
        String sql="delete from `news` where type=? ";
        return update(conn,sql,type);
    }

//    @Override
//    public List<News> queryNewsListBySid(Integer sid) {
//        String sql="SELECT * FROM `news` WHERE sid=? ";
//        return queryForList(News.class,sql,sid);
//    }


}
