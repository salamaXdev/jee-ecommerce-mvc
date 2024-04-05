package com.ecom.ecomv2.admin;

import com.ecom.ecomv2.Dao.ArticleDao.ArticleDao;
import com.ecom.ecomv2.Dao.ArticleDao.ArticleDaoImpl;
import com.ecom.ecomv2.beans.Article;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProduitsServlet", value = "/produits")
public class ProduitsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArticleDao articleDao = new ArticleDaoImpl();
        ArrayList<Article> articles = articleDao.getAllArticles();
        request.setAttribute("articles",articles);
        this.getServletContext().getRequestDispatcher("/WEB-INF/admin/produits.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codeArticle = Integer.parseInt(request.getParameter("codeArticle"));
        ArticleDao articleDao = new ArticleDaoImpl();
        articleDao.deleteArticleById(codeArticle);
        response.sendRedirect("produits");

    }
}
