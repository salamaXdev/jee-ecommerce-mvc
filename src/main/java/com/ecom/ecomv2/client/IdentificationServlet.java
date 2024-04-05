package com.ecom.ecomv2.client;

import com.ecom.ecomv2.Dao.ClientDao.ClientDao;
import com.ecom.ecomv2.Dao.ClientDao.ClientDaoImpl;
import com.ecom.ecomv2.Dao.Connect;
import com.ecom.ecomv2.beans.Client;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.Objects;

public class IdentificationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/client/identification.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String motPasse = request.getParameter("motPasse");
        ClientDao clientDao = new ClientDaoImpl();
        boolean isExist = clientDao.checkClient(email,motPasse);
        String adminEmail = getInitParameter("email");
        String adminPassword = getInitParameter("password");
        if (isExist){
            Client client = clientDao.getClientByEmailPass(email,motPasse);
            HttpSession session = request.getSession();
            session.setAttribute("nom", client.getNom());
            session.setAttribute("prenom", client.getPrenom());
            session.setAttribute("id", client.getId());
            session.setAttribute("isLogin", true);
            session.setAttribute("type","client");
            response.sendRedirect("accueil");
        } else if (Objects.equals(email, adminEmail) && Objects.equals(motPasse,adminPassword)) {
            HttpSession session = request.getSession();
            String adminName = getInitParameter("name");
            session.setAttribute("nom", adminName);
            session.setAttribute("email", adminEmail);
            session.setAttribute("isLogin", true);
            session.setAttribute("type","admin");
            response.sendRedirect("admin");
        } else{
            request.setAttribute("message", "l'utilisateur n'esxiste pas !");
            this.getServletContext().getRequestDispatcher("/WEB-INF/client/identification.jsp").forward(request,response);
        }
    }
}
