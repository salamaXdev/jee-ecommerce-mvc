package com.ecom.ecomv2.client;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "PanierServlet", value = "/panier")
public class PanierServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("designation")!=null && request.getParameter("codeArticle")!=null) {
            String designation = request.getParameter("designation");
            int codeArticle = Integer.parseInt(request.getParameter("codeArticle"));
            HashMap<Integer, String> cart;
            HttpSession session = request.getSession();
            if (session.getAttribute("cart") == null) {
                cart = new HashMap<>();
            } else {
                cart = (HashMap<Integer, String>) session.getAttribute("cart");
            }
                cart.put(codeArticle, designation);
                session.setAttribute("cart", cart);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/client/panier.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clearCartParam = request.getParameter("clearCart");
        if ("true".equals(clearCartParam)) {
            // Clear the cart
            HttpSession session = request.getSession();
            session.removeAttribute("cart");
            response.sendRedirect("catalogue");
        }
    }
}
