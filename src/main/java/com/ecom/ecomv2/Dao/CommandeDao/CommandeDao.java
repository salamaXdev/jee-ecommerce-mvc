package com.ecom.ecomv2.Dao.CommandeDao;

import com.ecom.ecomv2.beans.Commande;

import java.util.ArrayList;

public interface CommandeDao {
    public void addCommande(Commande commande);
    public Commande getCommandeById(int numCommande);
    public ArrayList<Commande> getAllCommandes();
    public void updateCommande(Commande commande);
    public void deleteCommande(int numCommande);



}
