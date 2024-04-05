package com.ecom.ecomv2.admin;

import com.ecom.ecomv2.Dao.CommandeDao.CommandeDao;
import com.ecom.ecomv2.Dao.CommandeDao.CommandeDaoImpl;
import com.ecom.ecomv2.beans.Client;
import com.ecom.ecomv2.beans.Commande;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "commandesServlet", value = "/commandes")
public class commandesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandeDao commandeDao = new CommandeDaoImpl();
        ArrayList<Commande> commandes = commandeDao.getAllCommandes();
        request.setAttribute("commandes",commandes);
        this.getServletContext().getRequestDispatcher("/WEB-INF/admin/commands.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
