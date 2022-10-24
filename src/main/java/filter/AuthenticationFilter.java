package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String url = request.getRequestURI();
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        session.getAttribute("user");

        if (url.contains("admin")) {
            if (session.getAttribute("user") != null) {
                if (Integer.parseInt(session.getAttribute("role").toString()) == 1) {
                    chain.doFilter(request,response);
                } else {
                    request.setAttribute("message", "Bạn không có quyền truy cập,Chưa đăng nhập,Vui lòng đăng nhập bằng tài khoản Admin");//sai mat khau or email
                    RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
                    rd.forward(request, response);
                }
            } else {
                request.setAttribute("message", "Chưa đăng nhập,Vui lòng đăng nhập bằng tài khoản Admin");//sai mat khau or email
                RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
                rd.forward(request, response);
            }
        }else {
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
