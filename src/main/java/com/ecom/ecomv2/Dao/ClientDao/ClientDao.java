package com.ecom.ecomv2.Dao.ClientDao;

import com.ecom.ecomv2.beans.Client;

import java.util.ArrayList;

public interface ClientDao {
    public void insertClient(Client client);
    public ArrayList<Client> getAllClients();
    public Client getClientById(int id);
    public void removeClientById(int id);

    public boolean checkClient(String email, String password);
    public Client getClientByEmailPass(String email, String password);
}
