package com.ecom.ecomv2.Dao.ArticleDao;

import com.ecom.ecomv2.Dao.Connect;
import com.ecom.ecomv2.beans.Article;
import com.ecom.ecomv2.beans.Categorie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ArticleDaoImpl implements ArticleDao{
    @Override
    public ArrayList<Article> getAllArticles() {
        ArrayList<Article> articles= new ArrayList<>();
        try {
            Connection con = Connect.getConnection();
            String query = "SELECT * FROM articles";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("codearticle");
                String designation = resultSet.getString("designation");
                int prix = resultSet.getInt("prix");
                int stock = resultSet.getInt("stock");
                int categorie = resultSet.getInt("categorie");
                String photo = resultSet.getString("photo");
                Article article = new Article(designation,prix,stock,categorie,photo);
                article.setCodeArticle(id);
                articles.add(article);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return articles;
    }
    @Override
    public void deleteArticleById(int id) {
        try {
            Connection con = Connect.getConnection();
            String query = "delete from articles where codearticle=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch (Exception e){e.printStackTrace();}
    }
    @Override
    public Article getArticleById(int id) {
       try {
           Connection connection = Connect.getConnection();
           String query = "SELECT * FROM articles WHERE codearticle=?";
           PreparedStatement ps = connection.prepareStatement(query);
           ps.setInt(1,id);
           ResultSet resultSet = ps.executeQuery();
           if (resultSet.next()){
               String designation = resultSet.getString("designation");
               int prix = resultSet.getInt("prix");
               int stock = resultSet.getInt("stock");
               int categorie = resultSet.getInt("categorie");
               String photo = resultSet.getString("photo");
               Article article = new Article(designation,prix,stock,categorie,photo);
               article.setCodeArticle(id);
               return article;
           }
       }catch (Exception e){e.printStackTrace();}
       return null;
    }

    @Override
    public void insertArticle(Article article) {
        try {
            Connection connection = Connect.getConnection();
            String query = "INSERT INTO articles(designation,prix,stock,categorie,photo) VALUES(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,article.getDesignation());
            ps.setDouble(2,article.getPrix());
            ps.setInt(3,article.getStock());
            ps.setInt(4,article.getCategorie());
            ps.setString(5,article.getPhoto());
            ps.executeUpdate();
        }catch (Exception e){e.printStackTrace();}
    }



    @Override
    public ArrayList<Article> getArticlesByCategorie(int categorieId) {
        ArrayList<Article> articles= new ArrayList<>();
        try {
            Connection con = Connect.getConnection();
            String query = "SELECT * FROM articles A, categories C WHERE A.categorie=C.refcat AND C.refcat=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,categorieId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                String designation = resultSet.getString("designation");
                int prix = resultSet.getInt("prix");
                int stock = resultSet.getInt("stock");
                int codearticle = resultSet.getInt("codearticle");
                int categorie = resultSet.getInt("categorie");
                String photo = resultSet.getString("photo");
                Article article = new Article(designation,prix,stock,categorie,photo);
                article.setCodeArticle(codearticle);
                articles.add(article);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return articles;
    }

    @Override
    public ArrayList<Categorie> getAllCategories() {
        ArrayList<Categorie> categories = new ArrayList<>();
        try {
            Connection con = Connect.getConnection();
            String query = "SELECT * FROM categories";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int refcat = resultSet.getInt("refcat");
                String cat = resultSet.getString("cat");
                categories.add(new Categorie(refcat,cat));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return categories;
    }
}
