package controller.admin;


import model.BookModel;
import model.CategoryModel;
import service.IBookService;
import service.ICategoryService;
import service.iml.BookService;
import service.iml.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(urlPatterns = {"/admin/book"})
@MultipartConfig
public class BookController extends HttpServlet {
    private String  PATH_IMAGE = "E:/";
    private static final long serialVersionUID = 1L;

    private IBookService bookService = new BookService();
    private ICategoryService categoryService = new CategoryService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");


        String type = request.getParameter("action");
        System.out.println(type);
        try {
            switch (type) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                case "list":
                    List<BookModel> data = bookService.findAll();
                    request.setAttribute("data",data);
                    RequestDispatcher rd = request.getRequestDispatcher("/views/admin/book/index.jsp");
                    rd.forward(request, response);
                    break;

            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String type = request.getParameter("action");
        if(type.contains("save"))
            save(request, response);
        if(type.contains("update"))
            update(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("categories",categoryService.findAll());
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/book/created.jsp");
        rd.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("categories",categoryService.findAll());
        Long id = Long.parseLong(request.getParameter("id"));
        BookModel book = bookService.findOne(id);
        request.setAttribute("book",book);

        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/book/created.jsp");
        rd.forward(request, response);
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));
        bookService.delete(id);
        response.sendRedirect(request.getContextPath() + "/admin/book?action=list");
    }
    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        BookModel book = new BookModel();
        CategoryModel category = new CategoryModel();
        book.setTitle(request.getParameter("title"));
        //category.setId(Long.parseLong(request.getParameter("categories")));
        book.setCategory(category);
        book.setDescription(request.getParameter("description"));
        book.setContent(request.getParameter("content"));
        book.setPrice(request.getParameter("price"));
        //book.setBackground(request.getParameter("background"));
        book.setBackground("upload/anhnen1.jpg");
        book.setStatus(1);
        book.setCreateDate(dateFormat.format(date));
        System.out.println(request.getParameter("background"));
        InputStream inputStream = null; // input stream of the upload file

        // obtains the upload file part in this multipart request
        //Part filePart = request.getPart("background");
        //if (filePart != null) {
//            // prints out some information for debugging
//            System.out.println(filePart.getName());
//            System.out.println(filePart.getSize());
//            System.out.println(filePart.getContentType());
//
//            // obtains input stream of the upload file
//            inputStream = filePart.getInputStream();
       //}


            //bookService.save(book);
            response.sendRedirect(request.getContextPath() + "/admin/book?action=list");
        }
        private void update (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Long id = Long.parseLong(request.getParameter("id"));
            BookModel old = bookService.findOne(id);

            BookModel book = new BookModel();
            CategoryModel category = new CategoryModel();
            book.setId(id);

            book.setTitle(request.getParameter("title"));
            category.setId(Long.parseLong(request.getParameter("categoryID")));
            book.setCategory(category);
            book.setDescription(request.getParameter("description"));
            book.setContent(request.getParameter("content"));
            book.setPrice(request.getParameter("price"));
            //book.setBackground(request.getParameter("background"));
            book.setBackground("upload/anhnen1.jpg");
            book.setStatus(1);
            book.setCreateDate(old.getCreateDate());

            bookService.update(book);
            response.sendRedirect(request.getContextPath() + "/admin/book?action=list");
        }


}
