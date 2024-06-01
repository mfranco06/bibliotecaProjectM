/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaprojectm.modelo;

import vistas.ConnectionDBA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marcos
 */
public class loginUsuario {

    public boolean authenticate(String email, String contraseña) {

        boolean isAuthenticated = false;
        try {
            Connection connection = ConnectionDBA.getConnection();
            String query = "SELECT * FROM usuarios WHERE correo_electronico = ? AND contrasena = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, contraseña);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                isAuthenticated = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return isAuthenticated;
    }
}


