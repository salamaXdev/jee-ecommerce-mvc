package com.ecom.ecomv2.beans;


public class Categorie {
    private int idcat;
    private String categorie;
    public Categorie(int idcat, String categorie) {
        this.idcat = idcat;
        this.categorie = categorie;
    }
    public int getIdcat() {
        return idcat;
    }
    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
