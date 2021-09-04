package dao.impl;

import dbutil.DBUtil;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDao {
    public int update(Connection conn, String sql, Object... args) {/*params 参数*/
        PreparedStatement ps = null;
        try {
            // 1.预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            //设置参数,填充占位符
            for (int i = 0; i < args.length; i++) {/*数组从0开始*/
                ps.setObject(i + 1, args[i]);/* ?从1开始 */
            }
            //执行sql语句
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, ps);
        }
        return 0;
    }

    /**
     * 查询返回一个javaBean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @param <T>  返回的类型的泛型
     * @return
     */
    public <T> T queryForOne(Connection conn, Class<T> type, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获得statement
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            //执行
            rs = ps.executeQuery();
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            if (rs.next()) {
                T obj = type.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnLabel = resultSetMetaData.getColumnLabel(i + 1);

                    Field field = type.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(obj, columnValue);
                }
                return obj;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            //关闭链接
            DBUtil.close(null, ps, rs);
        }

        return null;
    }

    /**
     * 执行返回一行一列的sql语句
     *
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @return
     */
    public Object queryForSingleValue(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获得statement
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            //执行
            rs = ps.executeQuery();
            Object obj = null;
            if (rs.next()) {
                return rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭链接
            DBUtil.close(conn, ps, rs);
        }
        return null;
    }

    /**
     * 查询返回多个javaBean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @param <T>  返回的类型的泛型
     * @return
     */
    public <T> List<T> queryForList(Connection conn, Class<T> type, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获得statement
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            //执行
            rs = ps.executeQuery();
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            List<T> list = new ArrayList<>();
            int columnCount = resultSetMetaData.getColumnCount();
            while (rs.next()) {
                T obj = type.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnLabel = resultSetMetaData.getColumnLabel(i + 1);
                    Field field = type.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(obj, columnValue);
                }
                list.add(obj);
            }
            return list;
        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (
                IllegalAccessException e) {
            e.printStackTrace();
        } catch (
                InstantiationException e) {
            e.printStackTrace();
        } catch (
                NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            //关闭链接
            DBUtil.close(null, ps,rs);
        }
        return null;
    }
}

