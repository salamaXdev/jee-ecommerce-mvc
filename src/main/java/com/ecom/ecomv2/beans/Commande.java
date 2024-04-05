package com.ecom.ecomv2.beans;

import java.util.Date;

import java.util.Date;

public class Commande {
    private int numCommande;
    private int codeClient;
    private int codeArticle;
    private Date dateCommande;
    public Commande(int codeClient, int codeArticle) {
        this.codeClient = codeClient;
        this.codeArticle = codeArticle;
    }
    public Commande(int numCommande, int codeClient, int codeArticle, Date dateCommande) {
        this.numCommande = numCommande;
        this.codeClient = codeClient;
        this.codeArticle = codeArticle;
        this.dateCommande = dateCommande;
    }

    public int getNumCommande() {
        return numCommande;
    }
    public void setNumCommande(int numCommande) {
        this.numCommande = numCommande;
    }
    public int getCodeClient() {
        return codeClient;
    }
    public void setCodeClient(int codeClient) {
        this.codeClient = codeClient;
    }
    public int getCodeArticle() {
        return codeArticle;
    }
    public void setCodeArticle(int codeArticle) {
        this.codeArticle = codeArticle;
    }
    public Date getDateCommande() {
        return dateCommande;
    }
    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }
    @Override
    public String toString() {
        return "Commande{" +
                "numCommande=" + numCommande +
                ", codeClient=" + codeClient +
                ", codeArticle=" + codeArticle +
                ", dateCommande=" + dateCommande +
                '}';
    }
}
