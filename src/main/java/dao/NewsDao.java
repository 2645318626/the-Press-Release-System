package dao;

import bean.News;

import java.sql.Connection;
import java.util.List;

/**
 * @author : author
 * @date : 22:34 2021/6/30
 */
public interface NewsDao {

    /**
     * 查询信息所有信息
     *
     * @return 如果返回null, 说明没有新闻。反之亦然
     */
    public List<News> queryNewsList(Connection conn);

    /**
     * 新闻添加
     *
     * @param news
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int addNews(Connection conn, News news);

    /**
     * 删除新闻信息
     *
     * @param id
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int deleteNewsById(Connection conn, int id);

    /**
     * 更新新闻户信息
     *
     * @param news
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int updateNews(Connection conn, News news);

    /**
     * 根据新闻id查询一条信息
     *
     * @param id
     * @return 如果返回null, 说明没有新闻。反之亦然
     */
    public News queryNewsById(Connection conn, int id);

    /**
     * 根据新闻发布者查询信息
     *
     * @param publisher
     * @return 如果返回null, 说明没有新闻。反之亦然
     */
    public List<News> queryNewsByPublisher(Connection conn, String publisher);

    /**
     * 根据新闻种类查询信息
     *
     * @param type
     * @return 如果返回null, 说明没有新闻。反之亦然
     */
    public List<News> queryNewsByType(Connection conn, String type);

    /**
     * 根据新闻类别查询新闻信息
     *
     * @return 如果返回null, 说明没有新闻。反之亦然
     */
    public List<News> queryNewsListByType(Connection conn, String type);

    /**
     * 根据搜索词模糊查询新闻信息
     *
     * @return 如果返回null, 说明没有新闻。反之亦然
     */
    public List<News> queryNewsListBySearchKey(Connection conn, String searchKey);

    /**
     * 根据关键词模糊查询新闻信息
     *
     * @return 如果返回null, 说明没有新闻。反之亦然
     */
    public List<News> queryNewsListByKeyWords(Connection conn, String keyWords);

    /**
     * 根据最近更新时间查询新闻信息
     *
     * @return 如果返回null, 说明没有新闻。反之亦然
     */
    public List<News> queryNewsListByTime(Connection conn);

//    /**
//     * 根据最近更新时间查询新闻信息
//     *
//     * @return 如果返回null, 说明没有新闻。反之亦然
//     */
//    public List<News> queryNewsListBySid(Integer sid);

    /**
     * 根据种类删除新闻信息
     *
     * @param type
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int deleteNewsByType(Connection conn,String type);

}
