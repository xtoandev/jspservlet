package controller.admin;

import model.AccountModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-home"})
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        checkLogin(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        checkLogin(request,response);
    }

    public static void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.getAttribute("user");

        if(session.getAttribute("user") != null){
            if(Integer.parseInt(session.getAttribute("role").toString()) == 1)
            {
                RequestDispatcher rd = request.getRequestDispatcher("views/admin/home.jsp");
                rd.forward(request, response);
            }
            else{
                request.setAttribute("message", "Bạn không có quyền truy cập,Chưa đăng nhập,Vui lòng đăng nhập bằng tài khoản Admin");//sai mat khau or email
                RequestDispatcher rd = request.getRequestDispatcher("views/login.jsp");
                rd.forward(request, response);
            }
        }
        else {
            request.setAttribute("message", "Chưa đăng nhập,Vui lòng đăng nhập bằng tài khoản Admin");//sai mat khau or email
            RequestDispatcher rd = request.getRequestDispatcher("views/login.jsp");
            rd.forward(request, response);
        }
    }
}
