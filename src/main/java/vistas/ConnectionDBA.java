/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ConnectionDBA {
    private static final String DATABASE="proyectoprogra1";
    private static final String SERVER_NAME="proyectofinalprogra1.postgres.database.azure.com";
    private static final String PORT ="5432";
    private static final String URL="jdbc:postgresql://"+SERVER_NAME+":"+PORT+"/"+DATABASE;
    private static final String SERVER_ADMIN_LOGIN_NAME="MarcosF";
    private static final String PASSWORD_ADMIN_LOGIN_PASSWORD="Mf0002$$";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, SERVER_ADMIN_LOGIN_NAME, PASSWORD_ADMIN_LOGIN_PASSWORD);
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Error en la conexion");
            e.printStackTrace();
        }
        return connection;
    }

    PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    PreparedStatement prepareStatement(String query, int RETURN_GENERATED_KEYS) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
