package com.ecom.ecomv2.client;

import com.ecom.ecomv2.Dao.CommandeDao.CommandeDao;
import com.ecom.ecomv2.Dao.CommandeDao.CommandeDaoImpl;
import com.ecom.ecomv2.beans.Commande;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "EnregistreServlet", value = "/enregistre")
public class EnregistreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        HashMap<Integer, String> cart = (HashMap<Integer, String>) session.getAttribute("cart");
        int id = (int) session.getAttribute("id");
        CommandeDao commandeDao = new CommandeDaoImpl();
        for (Map.Entry<Integer, String> entry : cart.entrySet()) {
            int productId = entry.getKey();
            commandeDao.addCommande(new Commande(id,productId));
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/client/enregistre.jsp").forward(request,response);
        session.removeAttribute("cart");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
