package com.ecom.ecomv2.admin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;


@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();
        boolean isLogin = (boolean) session.getAttribute("isLogin");
        String type = (String) session.getAttribute("type");

        if (isLogin && Objects.equals(type, "admin")){
            this.getServletContext().getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request,response);

        }else {
            response.sendRedirect("identification");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
