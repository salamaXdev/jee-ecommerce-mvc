package com.ecom.ecomv2.client;

import com.ecom.ecomv2.Dao.ArticleDao.ArticleDao;
import com.ecom.ecomv2.Dao.ArticleDao.ArticleDaoImpl;
import com.ecom.ecomv2.beans.Article;
import com.ecom.ecomv2.beans.Categorie;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CatalogueServlet", value = "/catalogue")
public class CatalogueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                ArticleDao articleDao = new ArticleDaoImpl();
                String category = request.getParameter("category");
                ArrayList<Article> articles;
                if (category != null && !category.isEmpty()) {
                    articles = articleDao.getArticlesByCategorie(Integer.parseInt(category));
                } else {
                    articles = articleDao.getAllArticles();
                }
                ArrayList<Categorie> categories = articleDao.getAllCategories();
                request.setAttribute("articles", articles);
                request.setAttribute("categories", categories);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/client/catalogue.jsp");
                dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
