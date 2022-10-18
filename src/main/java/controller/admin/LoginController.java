package controller.admin;

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
import java.io.IOException;
@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    private IAccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("views/login.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("user"+ email+"pass: " + password);
        AccountModel user = new AccountModel();

        user = accountService.getAccountByEmailAndPassword(email,password);

        if(user != null && user.getStatus() == 1) {

            response.sendRedirect(request.getContextPath()+"/home");
        }else {
            System.out.println("user"+ email+"pass: " + password);
        }

    }
}
