package com.ecom.ecomv2.client;
import com.ecom.ecomv2.Dao.ArticleDao.ArticleDao;
import com.ecom.ecomv2.Dao.ArticleDao.ArticleDaoImpl;
import com.ecom.ecomv2.beans.Article;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
@WebServlet(name = "DetailServlet", value = "/detail")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codeArticle = Integer.parseInt(request.getParameter("num"));
        ArticleDao articleDao = new ArticleDaoImpl();
        Article article = articleDao.getArticleById(codeArticle);
        request.setAttribute("article",article);
        this.getServletContext().getRequestDispatcher("/WEB-INF/client/detail.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
