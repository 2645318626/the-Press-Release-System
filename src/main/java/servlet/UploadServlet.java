package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * @author : author
 * @date : 15:33 2021/6/27
 */
@WebServlet(name="UploadServlet",value = "/uploadServlet")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        boolean isMultipart=ServletFileUpload.isMultipartContent(request);
        if(isMultipart)
        {
            FileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload upload=new ServletFileUpload(factory);
            try {
                List<FileItem> items=upload.parseRequest(request);
                Iterator<FileItem> it = items.iterator();
                while(it.hasNext())
                {
                    FileItem item = it.next();
                    String itemname = item.getFieldName();
                    int sno=-1;
                    String sname=null;

                    if(item.isFormField())
                    {
                        if(itemname.equals("sno"))
                        {
                            sno=Integer.parseInt(item.getString("utf-8"));
                        }else if(itemname.equals("sname"))
                        {
                            sname=item.getString("utf-8");
                            sname=item.getName();
                        }
                        else
                        {
                            System.out.println("其他字段");
                        }
                    }else
                    {
                        String filename=item.getName();
                        //String path=request.getSession().getServletContext().getRealPath("upload");
                        String path="C:\\Users\\15312\\IdeaProjects\\myJava\\keshihua\\test1\\src\\main\\webapp\\images";
                        File file=new File(path,filename);
                        item.write(file);
                        request.setAttribute("news", filename+"上传成功,谢谢分享");
                        request.getRequestDispatcher("/newsServlet?action=addNews").forward(request, response);
//                        System.out.println(filename+"上传成功!!!");
                        return;
                    }

                }
            } catch (FileUploadException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //1 先判断上传的数据是否多段数据（只有是多段的数据，才是文件上传的）
//        if (ServletFileUpload.isMultipartContent(req)) {
////           创建FileItemFactory工厂实现类
//            FileItemFactory fileItemFactory = new DiskFileItemFactory();
//            // 创建用于解析上传数据的工具类ServletFileUpload类
//            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
//            try {
//                // 解析上传的数据，得到每一个表单项FileItem
//                List<FileItem> list = servletFileUpload.parseRequest(req);
//                // 循环判断，每一个表单项，是普通类型，还是上传的文件
//                for (FileItem fileItem : list) {
//
//                    if (fileItem.isFormField()) {
//                        // 普通表单项
//                        System.out.println("表单项的name属性值：" + fileItem.getFieldName());
//                        // 参数UTF-8.解决乱码问题
//                        System.out.println("表单项的value属性值：" + fileItem.getString("UTF-8"));
//                    } else {
//                        // 上传的文件
//                        System.out.println("表单项的name属性值：" + fileItem.getFieldName());
//                        System.out.println("上传的文件名：" + fileItem.getName());
//                        fileItem.write(new File("e:\\" + fileItem.getName()));
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        req.getRequestDispatcher("/newsServlet?action=add").forward(req,resp);
//    }
//}
