//package dao.impl;
//
//import dbutil.DBUtil;
//
//import java.io.File;
//import java.lang.reflect.Field;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public abstract class BaseDaoSaved {
//    Connection conn;
//    PreparedStatement ps;
//    ResultSet rs;
//
//    public int update(String sql, Object... args) {/*params 参数*/
//        int result = -1;
//        try {
//            //获得链接对象
//            conn = DBUtil.getConnection();
//            //获得声明
//            ps = conn.prepareStatement(sql);
//            //设置参数
//            for (int i = 0; i < args.length; i++) {/*数组从0开始*/
//                ps.setObject(i + 1, args[i]);/* ?从1开始 */
//            }
//            //执行sql语句
//            result = ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DBUtil.close(null, ps, conn);
//        }
//        return result;
//    }
//
//    /**
//     * 查询返回一个javaBean的sql语句
//     *
//     * @param type 返回的对象类型
//     * @param sql  执行的sql语句
//     * @param args sql对应的参数值
//     * @param <T>  返回的类型的泛型
//     * @return
//     */
//    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
//        List<T> list = new ArrayList<>();
//        try {
//            //获得链接对象
//            conn = DBUtil.getConnection();
//            //获得statement
//            ps = conn.prepareStatement(sql);
//            for (int i = 0; i < args.length; i++) {
//                ps.setObject(i + 1, args[i]);
//            }
//            //执行
//            rs = ps.executeQuery();
//            Field[] fields = type.getDeclaredFields();/*声明所有字段*/
//            if (rs.next()) {
//                T obj = (T) type.newInstance();
//                for (Field field : fields) {
//                    String fieldName = field.getName();
//                    field.setAccessible(true);
//                    field.set(obj, rs.getObject(fieldName));
//                }
//                list.add(obj);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } finally {
//            //关闭链接
//            DBUtil.close(rs, ps, conn);
//        }
//        return list.get(0);
//    }
//
//    /**
//     * 执行返回一行一列的sql语句
//     *
//     * @param sql  执行的sql语句
//     * @param args sql对应的参数值
//     * @return
//     */
//    public Object queryForSingleValue(String sql, Object... args) {
//        String result = null;
//        try {
//            //获得链接对象
//            conn = DBUtil.getConnection();
//            //获得statement
//            ps = conn.prepareStatement(sql);
//            for (int i = 0; i < args.length; i++) {
//                ps.setObject(i + 1, args[i]);
//            }
//            //执行
//            rs = ps.executeQuery();
//            result = rs.getString("args");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            //关闭链接
//            DBUtil.close(rs, ps, conn);
//        }
//        return result;
//    }
//
//    /**
//     * 查询返回多个javaBean的sql语句
//     *
//     * @param type 返回的对象类型
//     * @param sql  执行的sql语句
//     * @param args sql对应的参数值
//     * @param <T>  返回的类型的泛型
//     * @return
//     */
//    public <T> List<T> queryForList(Class type, String sql, Object... args) {
//        List<T> list = new ArrayList<>();
//        try {
//            //获得链接对象
//            conn = DBUtil.getConnection();
//            //获得statement
//            ps = conn.prepareStatement(sql);
//            for (int i = 0; i < args.length; i++) {
//                ps.setObject(i + 1, args[i]);
//            }
//            //执行
//            rs = ps.executeQuery();
//            Field[] fields = type.getDeclaredFields();/*声明所有字段*/
//            while (rs.next()) {
//                Object obj = type.newInstance();
//                for (Field field : fields) {
//                    String fieldName = field.getName();
//                    field.setAccessible(true);
//                    field.set(obj, rs.getObject(fieldName));
//                }
//                list.add((T) obj);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } finally {
//            //关闭链接
//            DBUtil.close(rs, ps, conn);
//        }
//        return list;
//    }
//}
//
