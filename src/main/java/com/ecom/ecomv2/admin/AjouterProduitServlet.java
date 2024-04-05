package com.ecom.ecomv2.admin;

import com.ecom.ecomv2.Dao.ArticleDao.ArticleDao;
import com.ecom.ecomv2.Dao.ArticleDao.ArticleDaoImpl;
import com.ecom.ecomv2.beans.Article;
import com.ecom.ecomv2.beans.Categorie;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AjouterProduitServlet", value = "/ajouterproduit")
public class AjouterProduitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArticleDao articleDao = new ArticleDaoImpl();
        ArrayList<Categorie> categories= articleDao.getAllCategories();
        request.setAttribute("categories",categories);
        this.getServletContext().getRequestDispatcher("/WEB-INF/admin/ajouterproduit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String designation = request.getParameter("designation");
        int prix = Integer.parseInt(request.getParameter("prix"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        int category = Integer.parseInt(request.getParameter("category"));
        String photo = request.getParameter("photo");

        ArticleDao articleDao = new ArticleDaoImpl();
        articleDao.insertArticle(new Article(designation,prix,stock,category,photo));

        response.sendRedirect("produits");
    }
}
