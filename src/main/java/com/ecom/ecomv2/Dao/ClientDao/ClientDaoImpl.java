package com.ecom.ecomv2.Dao.ClientDao;

import com.ecom.ecomv2.Dao.Connect;
import com.ecom.ecomv2.beans.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class ClientDaoImpl implements ClientDao{
    @Override
    public void insertClient(Client client) {
        try {

            Connection connection = Connect.getConnection();
            String query = "INSERT INTO clients(email,nom,prenom,adresse,codepostal,ville,tel,motpasse)" +
                    "VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, client.getEmail());
            ps.setString(2, client.getNom());
            ps.setString(3, client.getPrenom());
            ps.setString(4, client.getAdresse());
            ps.setString(5, client.getCodePostal());
            ps.setString(6, client.getVille());
            ps.setString(7, client.getTel());
            ps.setString(8, client.getMotPasse());

            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Client> getAllClients() {
        return null;
    }

    @Override
    public Client getClientById(int id) {
        Client client = null;
        try {
            Connection con = Connect.getConnection();
            String query = "SELECT * FROM clients WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()){
                String email = resultSet.getString("email");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String adresse = resultSet.getString("adresse");
                String codepostal = resultSet.getString("codepostal");
                String ville = resultSet.getString("ville");
                String tel = resultSet.getString("tel");
                client = new Client(id,email,nom,prenom,adresse,codepostal,ville,tel);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public void removeClientById(int id) {

    }

    @Override
    public boolean checkClient(String email, String password) {
        boolean isExist=false;
        try {
            Connection con = Connect.getConnection();
            String query = "SELECT * FROM clients WHERE email=? AND motpasse=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()){
                isExist=true;
                return isExist;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return isExist;
    }

    @Override
    public Client getClientByEmailPass(String email, String password) {

        try {
            Connection con = Connect.getConnection();
            String query = "SELECT * FROM clients WHERE email=? AND motpasse=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()){
               int id = resultSet.getInt("id");
               String email1 = resultSet.getString("email");
               String nom = resultSet.getString("nom");
               String prenom = resultSet.getString("prenom");
                String adresse = resultSet.getString("adresse");
                String codepostal = resultSet.getString("codepostal");
                String ville = resultSet.getString("ville");
                String tel = resultSet.getString("tel");

                Client client = new Client(email1,nom,prenom,adresse,codepostal,ville,tel,password);
                client.setId(id);
                return client;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
