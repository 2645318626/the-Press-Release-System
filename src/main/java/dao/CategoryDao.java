package dao;

import bean.Category;
import bean.News;

import java.sql.Connection;
import java.util.List;

/**
 * @author : author
 * @date : 0:22 2021/7/1
 */
public interface CategoryDao {
    /**
     * 查询所有新闻的种类信息
     * @return 如果返回null, 说明没有类别。反之亦然
     */
    public List<Category> queryNewsTypeList(Connection conn);
    /**
     * 添加新闻种类
     *
     * @param type
     * @return 如果返回null, 说明没有类别。反之亦然
     */
    public int addNewsType(Connection conn,String type);
    /**
     * 删除新闻信息
     *
     * @param sid
     * @return 如果返回-1, 说明失败。反之亦然
     */
    public int deleteNewsTypeBySid(Connection conn,int sid);

    /**
     *
     * 根据sid查询最新新闻信息
     *
     * @param sid
     * @return 如果返回null, 说明没有类别。反之亦然
     */
    public News queryNewsListBySid(Connection conn,int sid);

}
