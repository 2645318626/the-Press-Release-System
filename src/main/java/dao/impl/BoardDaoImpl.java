package dao.impl;

import bean.Board;
import bean.News;
import dao.BoardDao;

import java.sql.Connection;
import java.util.List;

/**
 * @author : author
 * @date : 22:59 2021/7/2
 */
public class BoardDaoImpl extends BaseDao implements BoardDao {
    @Override
    public List<Board> queryBoardList(Connection conn) {
        String sql = "select * from message";
        return queryForList(conn,Board.class,sql);
    }

    @Override
    public int addBoard(Connection conn, Board board) {
        String sql = "insert into message(`title`,`content`,`group`,`time`)";
        return update(conn,sql,board.getTitle(),board.getContent(),board.getGroup(),board.getDetailTime());
    }

    @Override
    public int deleteBoardById(Connection conn, int id) {
        String sql = "delete from message where id=?";
        return update(conn,sql,id);
    }

    @Override
    public Board queryBoardById(Connection conn, int id) {
        String sql = "select `id`,`title`,`content`,`group`,`detailTime` from message where id=?";
        return queryForOne(conn,Board.class,sql,id);
    }

    @Override
    public List<Board> queryBoardByGroup(Connection conn, String group) {
        String sql = "select * from message where group=?";
        return queryForList(conn,Board.class,sql,group);
    }
}
