package servlet;

import bean.Board;
import bean.Category;
import bean.News;
import dao.BoardDao;
import dao.CategoryDao;
import dao.NewsDao;
import dao.impl.BoardDaoImpl;
import dao.impl.CategoryDaoImpl;
import dao.impl.NewsDaoImpl;
import dbutil.DBUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * @author : author
 * @date : 13:34 2021/6/24
 */
public class NewsServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        System.out.println(action);
        try {
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void keySearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keySearch = req.getParameter("keySearch");
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            System.out.println(keySearch);
            NewsDao newsDao = new NewsDaoImpl();
            List<News> keysList = newsDao.queryNewsListBySearchKey(conn, "%" + keySearch + "%");
            req.setAttribute("keysList", keysList);
            System.out.println("查询成功");
            req.getRequestDispatcher("/pages/user/keyShow.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            DBUtil.close(conn, null);
        }
    }

    protected void newspagesShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            NewsDao newsDao = new NewsDaoImpl();
            List<News> keyWordsList1 = keyWords(req, resp, "要闻");
            List<News> keyWordsList2 = newsDao.queryNewsListByTime(conn);//最新发表
            List<News> keyWordsList3 = keyWords(req, resp, "热点");
            List<News> keyWordsList4 = keyWords(req, resp, "国际");
            List<News> keyWordsList5 = keyWords(req, resp, "国内");
            showCategory(req, resp);
            req.getServletContext().setAttribute("keyWordsList1", keyWordsList1);
            req.getServletContext().setAttribute("keyWordsList2", keyWordsList2);
            req.getServletContext().setAttribute("keyWordsList3", keyWordsList3);
            req.getServletContext().setAttribute("keyWordsList4", keyWordsList4);
            req.getServletContext().setAttribute("keyWordsList5", keyWordsList5);
            req.getRequestDispatcher("/pages/user/newspages.jsp?").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            DBUtil.close(conn, null);
        }
    }

    public List<News> keyWords(HttpServletRequest req, HttpServletResponse resp, String keyWords) throws ServletException, IOException {
        Connection conn = null;
        List<News> keyWordsList = null;
        System.out.println(keyWords);
        try {
            conn = DBUtil.getConnection();
            NewsDao newsDao = new NewsDaoImpl();
            keyWordsList = newsDao.queryNewsListByKeyWords(conn, "%" + keyWords + "%");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            DBUtil.close(conn, null);
        }
        return keyWordsList;
    }

    public void keyShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        String type = req.getParameter("key");
        List<News> keysList = null;
        try {
            conn = DBUtil.getConnection();
            NewsDao newsDao = new NewsDaoImpl();
            keysList = newsDao.queryNewsListByType(conn, type);
            req.setAttribute("keysList", keysList);
            req.getRequestDispatcher("/pages/user/keyShow.jsp?key=" + type).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            DBUtil.close(conn, null);
        }
    }

    public void detailNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        int id = Integer.parseInt((req.getParameter("id")));
        String from = req.getParameter("from");
        try {
            conn = DBUtil.getConnection();
            NewsDao newsDao = new NewsDaoImpl();
            News news = newsDao.queryNewsById(conn, id);
            req.setAttribute("news", news);
            if ("user".equals(from)) {
                req.getRequestDispatcher("/pages/user/detailNews.jsp").forward(req, resp);
            } else if ("admin".equals(from)) {
                req.getRequestDispatcher("/pages/admin/detailNews.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/pages/user/showSingleNews.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //            DBUtil.close(conn, null);
        }
    }

    public void addNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            NewsDao newsDao = new NewsDaoImpl();
            News news = updateDom(req, resp);
            if (newsDao.addNews(conn, news) > 0) {
                req.getRequestDispatcher("/pages/user/addNews.jsp?error=yes").forward(req, resp);
            } else {
                req.getRequestDispatcher("/pages/user/addNews.jsp?error=no").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            DBUtil.close();
        }
    }

    public void pudateNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            NewsDao newsDao = new NewsDaoImpl();
            News news = updateDom(req, resp);
            if (newsDao.updateNews(conn, news) > -1) {
                req.getRequestDispatcher("/newsServlet?action=showNews&from=user").forward(req, resp);
            } else {
                req.getRequestDispatcher("/pages/user/updateNews.jsp?error=no").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            DBUtil.close();
        }
    }

    protected News updateDom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = null, type = null, author = null, content = null, imgPath = null, keyWords = null;
        Integer id = 0;
        Date date = new Date();
        String getDate = String.format("%tc", date);

        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload images = new ServletFileUpload(factory);
            try {
                List<FileItem> items = images.parseRequest(req);
                Iterator<FileItem> it = items.iterator();
                while (it.hasNext()) {
                    FileItem item = it.next();
                    String itemname = item.getFieldName();

                    if (item.isFormField()) {
                        if (itemname.equals("title")) {
                            title = item.getString("utf-8");
                        } else if (itemname.equals("type")) {
                            type = item.getString("utf-8");
                        } else if (itemname.equals("author")) {
                            author = item.getString("utf-8");
                        } else if (itemname.equals("content")) {
                            content = item.getString("utf-8");
//                            System.out.println(item.getString("utf-8"));
                        } else if (itemname.equals("keyWords")) {
                            keyWords = item.getString("utf-8");
                        } else if (itemname.equals("id")) {
                            id = Integer.valueOf((item.getString("utf-8")));
                        }
                    } else {
                        String filename = item.getName();
//                        这里的文件要修改目录
                        String path = "C:\\Users\\15312\\IdeaProjects\\myJava\\keshihua\\test1\\src\\main\\webapp\\static\\images";
                        File fullFile = new File(filename);
                        File savedFile = new File(path, fullFile.getName());
                        imgPath = "static/images/" + fullFile.getName();
                        if (savedFile.exists()) {
                            System.out.println("已经存在重复文件");
                        } else {
                            item.write(savedFile);
                            System.out.println(filename + "上传成功!!!");
                        }
                    }

                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        News news = new News();
        news.setAuthor(author);
        news.setTitle(title);
        news.setContent(content);
        news.setType(type);
        news.setImgPath(imgPath);
        news.setGetDate(getDate);
        news.setPublisher((String) req.getSession().getAttribute("username"));
        news.setKeyWords(keyWords);
        news.setId(id);
        return news;
    }

    public void deleteNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            int id = Integer.parseInt((req.getParameter("id")));
            NewsDao newsDao = new NewsDaoImpl();
            if (newsDao.deleteNewsById(conn, id) > 0) {
                req.getRequestDispatcher("/newsServlet?action=showNews&from=user").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            DBUtil.close();
        }
    }

    public void showNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String from = req.getParameter("from");
            List<News> list;
            News news;
            NewsDao newsDao = new NewsDaoImpl();
            if ("admin".equals(from)) {
                list = newsDao.queryNewsList(conn);
                req.setAttribute("list", list);
                showCategory(req, resp);
                req.getRequestDispatcher("/pages/admin/adminEdit.jsp").forward(req, resp);
            } else if ("user".equals(from)) {
                String publisher = (String) req.getSession().getAttribute("username");
                showCategory(req, resp);
                list = newsDao.queryNewsByPublisher(conn, publisher);
                req.setAttribute("list", list);
                req.getRequestDispatcher("/pages/user/editNews.jsp").forward(req, resp);
            } else if ("querySingleById".equals(from)) {
                int id = Integer.parseInt(req.getParameter("id"));
                showCategory(req, resp);
                news = newsDao.queryNewsById(conn, id);
                req.setAttribute("news", news);
                req.getRequestDispatcher("/pages/user/updateNews.jsp?id=" + id).forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            DBUtil.close();
        }
    }

    protected void indexShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            NewsDao newsDao = new NewsDaoImpl();
            List<News> list = newsDao.queryNewsList(conn);
            req.setAttribute("list", list);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            DBUtil.close();
        }
    }

    public void editBoard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dom = req.getParameter("dom");
        try {
            Method method = this.getClass().getDeclaredMethod(dom, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void showBoardList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boardList(req,resp);
        req.getRequestDispatcher("/pages/admin/editBoard.jsp").forward(req,resp);
    }

    protected void boardShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boardList(req,resp);
        req.getRequestDispatcher("/pages/user/board.jsp").forward(req,resp);
    }

    public void boardList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Board> boardList = null;
        BoardDao boardDao = new BoardDaoImpl();
        Connection conn=null;
        try {
            conn = DBUtil.getConnection();
            boardList = boardDao.queryBoardList(conn);
            req.getServletContext().setAttribute("boardList",boardList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void addBoard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String group = req.getParameter("group");
        Date date = new Date();
        String getDate = String.format("%tc", date);
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setGroup(group);
        board.setDetailTime(getDate);
        BoardDao boardDao = new BoardDaoImpl();
        Connection conn = null;
        try{
            conn = DBUtil.getConnection();
            if(boardDao.addBoard(conn, board)>-1){
                boardList(req,resp);
                req.getRequestDispatcher("/pages/admin/editCategory.jsp?error=yes").forward(req,resp);
            }else{
                req.getRequestDispatcher("/pages/admin/addBoard.jsp?error=no").forward(req,resp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void deleteBoard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try {
            conn = DBUtil.getConnection();
            if (boardDao.deleteBoardById(conn,id)>-1){
                showBoardList(req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    protected void showBoardById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try{
            conn = DBUtil.getConnection();
            if(boardDao.queryBoardById(conn, id) != null){
                Board board = boardDao.queryBoardById(conn, id);
                req.setAttribute("board",board);
                System.out.println("成功！");
                System.out.println(req.getServletContext().getAttribute("boardList"));
                req.getRequestDispatcher("/pages/user/detailBoard.jsp").forward(req,resp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
//            DBUtil.close();
        }
    }

    protected void showBoardByGroup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String group = req.getParameter("group");
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try{
            conn = DBUtil.getConnection();
            List<Board> boardList = boardDao.queryBoardByGroup(conn, group);
            req.getServletContext().setAttribute("boardList",boardList);
            req.getRequestDispatcher("/pages/user/keyBoard.jsp?group="+group).forward(req,resp);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
//            DBUtil.close();
        }
    }

    public void editCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String dom = req.getParameter("dom");
        System.out.println(dom);
        Method method = this.getClass().getDeclaredMethod(dom, HttpServletRequest.class, HttpServletResponse.class);
        method.invoke(this, req, resp);
    }

    protected void addCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String addType = req.getParameter("addType");
            CategoryDao categoryDao = new CategoryDaoImpl();
            categoryDao.addNewsType(conn, addType);
            showCategory(req, resp);
            req.getRequestDispatcher("/pages/admin/editCategory.jsp?error=yes").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            DBUtil.close();
        }
    }

    protected void deleteCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            Integer sid = Integer.valueOf(req.getParameter("sid"));
            CategoryDao categoryDao = new CategoryDaoImpl();
            NewsDao newsDao = new NewsDaoImpl();
            categoryDao.deleteNewsTypeBySid(conn, sid);
            showCategory(req, resp);
            categoryDao.queryNewsListBySid(conn, sid);
            if (newsDao.queryNewsByType(conn, req.getParameter("type")) != null) {
                newsDao.deleteNewsByType(conn, req.getParameter("type"));
                System.out.println("该类型新闻已删除！");
            }
            req.getRequestDispatcher("/pages/admin/editCategory.jsp?error=delete").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            DBUtil.close();
        }
    }

    protected void showCategoryBoard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showCategory(req, resp);
        req.getRequestDispatcher("/pages/admin/editCategory.jsp").forward(req, resp);
    }

    public void showCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            CategoryDao categoryDao = new CategoryDaoImpl();
            List<Category> categoryList = categoryDao.queryNewsTypeList(conn);
            req.getServletContext().setAttribute("categoryList", categoryList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            DBUtil.close();
        }
    }
}
