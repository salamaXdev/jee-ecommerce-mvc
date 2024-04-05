package com.ecom.ecomv2.beans;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("TestJpa");
            entityManager = entityManagerFactory.createEntityManager();
            Client client = entityManager.find(Client.class,2);
            System.out.println(client);

        }finally {

            System.out.println("L'insertion d'un nouvelle client : ");
            Client client = new Client("salama@gmail.com","SALAMA","ANAS","12 RUE","24000","EL JADIDA","-6574848","123");
            entityManager.persist(client);


            System.out.println("Lecture de tous les clients : ");
            List<Client> clients = entityManager.createQuery("FROM Client", Client.class).getResultList();


            for (Client c:clients) {
                System.out.println(c);
            }

        }

    }
}
