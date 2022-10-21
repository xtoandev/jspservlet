package controller.web;

import com.sun.net.httpserver.HttpServer;
import model.AccountModel;
import service.IAccountService;
import service.iml.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    private IAccountService accountService = new AccountService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("views/login.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        AccountModel user = new AccountModel();
        user = accountService.getAccountByEmailAndPassword(email,password);//tim user
        HttpSession session = request.getSession();
        //kiem tra dang nhap
        if(user != null && user.getStatus() == 1) {
            session.setAttribute("user",user);//gan session
            session.setAttribute("role",user.getRoleID());

            if(user.getRoleID() == 1)
                response.sendRedirect(request.getContextPath()+"/admin-home");//tai khoan admin
            else
                response.sendRedirect(request.getContextPath()+"/home");//tai khoan thương
        }else if(user != null && user.getStatus() != 1){
            request.setAttribute("message", "Tài khoản đã bị khóa");//tai khoan bi khoa
            processRequest(request, response);
        }
        else{
            request.setAttribute("message", "Email hoặc mật khẩu không đúng");//sai mat khau or email
            processRequest(request, response);
        }

    }
}
