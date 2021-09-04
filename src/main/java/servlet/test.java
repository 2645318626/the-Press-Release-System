//package servlet;
//
//import bean.News;
//import dbutil.DBUtil;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//
///**
// * @author : author
// * @date : 1:07 2021/6/26
// */
//public class test {
////    protected void UploadServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        String imgPath = req.getParameter("imgPath");
////        //1 先判断上传的数据是否多段数据（只有是多段的数据，才是文件上传的）
////        if (ServletFileUpload.isMultipartContent(req)) {
//////           创建FileItemFactory工厂实现类
////            FileItemFactory fileItemFactory = new DiskFileItemFactory();
////            // 创建用于解析上传数据的工具类ServletFileUpload类
////            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
////            try {
////                // 解析上传的数据，得到每一个表单项FileItem
////                List<FileItem> list = servletFileUpload.parseRequest(req);
////                // 循环判断，每一个表单项，是普通类型，还是上传的文件
////                for (FileItem fileItem : list) {
////
////                    if (fileItem.isFormField()) {
////                        // 普通表单项
////
////                        System.out.println("表单项的name属性值：" + fileItem.getFieldName());
////                        // 参数UTF-8.解决乱码问题
////                        System.out.println("表单项的value属性值：" + fileItem.getString("UTF-8"));
////
////                    } else {
////                        // 上传的文件
////                        System.out.println("表单项的name属性值：" + fileItem.getFieldName());
////                        System.out.println("上传的文件名：" + fileItem.getName());
////
////                        fileItem.write(new File("C:\\Users\\15312\\IdeaProjects\\myJava\\keshihua\\test1\\src\\main\\webapp\\images" + fileItem.getName()));
////                    }
////                }
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////        }
////    }
//    public static void main(String[] args) {
//
//        Connection connection = DBUtil.getConnection();
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        Date date = new Date();
//        String update = String.format("%tc",date);
////        System.out.println(update);
//        String keySearch="的";
//
//        try {
//            String sql = "select * from news where concat(title,content,type,author) like '" + "%"+keySearch+"%" + "'";
//            preparedStatement = connection.prepareStatement(sql);
////            preparedStatement.setString(1, "%"+keySearch+"%");
//            resultSet = preparedStatement.executeQuery();
//            List<News> list = new ArrayList<>();
//            while (resultSet.next()) {
//                News news = new News();
//                Integer id = resultSet.getInt("id");
//                String title = resultSet.getString("title");
//                String author = resultSet.getString("author");
//                String content = resultSet.getString("content");
//                String type = resultSet.getString("type");
//                String imgPath = resultSet.getString("imgPath");
//                String getDate = resultSet.getString("getDate");
//                int sid = resultSet.getInt("sid");
//                News.categoryEnum categoryEnum = new News.categoryEnum(sid,type);
//
//                news.setAuthor(author);
//                news.setType(categoryEnum);
//                news.setTitle(title);
//                news.setContent(content);
//                news.setImgPath(imgPath);
//                news.setId(id);
//                news.setGetDate(getDate);
//                list.add(news);
//            }
////            System.out.println(list);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
////            DBUtil.close(preparedStatement, connection);
//        }
//    }
//}
