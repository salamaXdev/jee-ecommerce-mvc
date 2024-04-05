package com.ecom.ecomv2.Dao.ArticleDao;

import com.ecom.ecomv2.beans.Article;
import com.ecom.ecomv2.beans.Categorie;

import java.util.ArrayList;

public interface ArticleDao {
    public ArrayList<Article> getAllArticles();
    public void deleteArticleById(int id);
    public Article getArticleById(int id);
    public void insertArticle(Article article);
    public ArrayList<Article> getArticlesByCategorie(int categorie);

    public ArrayList<Categorie> getAllCategories();
}
