package com.ecom.ecomv2.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
public class Connect {
    private static Connection connection;
    private Connect(){}
    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "123456");
        }catch (Exception e){e.printStackTrace();}
    }
    public static Connection getConnection(){
        return connection;
    }
}
