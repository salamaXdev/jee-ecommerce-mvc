package com.ecom.ecomv2.client;

import com.ecom.ecomv2.Dao.ClientDao.ClientDao;
import com.ecom.ecomv2.Dao.ClientDao.ClientDaoImpl;
import com.ecom.ecomv2.beans.Client;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "InscriptionServlet", value = "/inscription")
public class InscriptionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/client/inscription.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Récupérer les paramètres du formulaire
        String email = request.getParameter("email");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String adresse = request.getParameter("adresse");
        String codePostal = request.getParameter("codePostal");
        String ville = request.getParameter("ville");
        String tel = request.getParameter("tel");
        String motPasse = request.getParameter("motPasse");

        Client client = new Client(email,nom,prenom,adresse,codePostal,ville,tel,motPasse);

        ClientDao clientDao = new ClientDaoImpl();
        clientDao.insertClient(client);
        response.sendRedirect("identification");

    }
}
