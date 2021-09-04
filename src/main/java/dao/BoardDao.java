package dao;

import bean.Board;
import bean.News;

import java.sql.Connection;
import java.util.List;

/**
 * @author : author
 * @date : 22:50 2021/7/2
 */
public interface BoardDao {
    /**
     * 查询所有信息
     *
     * @return 如果返回null, 说明没有新闻。反之亦然
     */
    public List<Board> queryBoardList(Connection conn);

    /**
     * 添加公告
     *
     * @param board
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int addBoard(Connection conn, Board board);

    /**
     * 删除新闻信息
     *
     * @param id
     * @return 返回-1表示操作失败，其他是sql语句影响的行数
     */
    public int deleteBoardById(Connection conn, int id);

    /**
     * 根据公告id查询一条信息
     *
     * @param id
     * @return 如果返回null, 说明没有公告。反之亦然
     */
    public Board queryBoardById(Connection conn, int id);

    /**
     * 根据组群查询信息
     *
     * @param group
     * @return 如果返回null, 说明没有新闻。反之亦然
     */
    public List<Board> queryBoardByGroup(Connection conn, String group);
}
