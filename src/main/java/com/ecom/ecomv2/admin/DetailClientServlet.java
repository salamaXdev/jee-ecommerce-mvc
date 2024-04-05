package com.ecom.ecomv2.admin;

import com.ecom.ecomv2.Dao.ArticleDao.ArticleDao;
import com.ecom.ecomv2.Dao.ArticleDao.ArticleDaoImpl;
import com.ecom.ecomv2.Dao.ClientDao.ClientDao;
import com.ecom.ecomv2.Dao.ClientDao.ClientDaoImpl;
import com.ecom.ecomv2.beans.Article;
import com.ecom.ecomv2.beans.Client;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DetailClientServlet", value = "/detailclient")
public class DetailClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codeClient = Integer.parseInt(request.getParameter("num"));
        ClientDao clientDao = new ClientDaoImpl();
        Client client = clientDao.getClientById(codeClient);
        request.setAttribute("client",client);
        this.getServletContext().getRequestDispatcher("/WEB-INF/admin/detailclient.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
