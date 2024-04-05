package com.ecom.ecomv2.Dao.CommandeDao;

import com.ecom.ecomv2.Dao.Connect;
import com.ecom.ecomv2.beans.Commande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class CommandeDaoImpl implements CommandeDao{
    @Override
    public void addCommande(Commande commande) {
        try {
            Connection connection = Connect.getConnection();
            String query = "INSERT INTO commandes(codeclient,codearticle) VALUES(?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,commande.getCodeClient());
            ps.setInt(2,commande.getCodeArticle());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public Commande getCommandeById(int numCommande) {
        return null;
    }
    @Override
    public ArrayList<Commande> getAllCommandes() {
        ArrayList<Commande> commandes = new ArrayList<>();
        try {
            Connection connection = Connect.getConnection();
            String query = "SELECT * FROM commandes";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int numCom = resultSet.getInt("numcommande");
                int codeclient = resultSet.getInt("codeclient");
                int codearticle = resultSet.getInt("codearticle");
                Date datecommande = resultSet.getDate("datecommande");
                commandes.add(new Commande(numCom,codeclient,codearticle,datecommande));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return commandes;
    }

    @Override
    public void updateCommande(Commande commande) {}

    @Override
    public void deleteCommande(int numCommande) {}
}
