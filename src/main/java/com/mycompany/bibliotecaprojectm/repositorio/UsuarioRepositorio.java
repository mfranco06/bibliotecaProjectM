/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaprojectm.repositorio;


import vistas.ConnectionDBA;
import com.mycompany.bibliotecaprojectm.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class UsuarioRepositorio {
  
    
    public void registrarUsuario(Usuario usuario) {
        
        String query = "INSERT INTO usuarios (nombre, direccion, telefono, identificacion, apellido, email, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = ConnectionDBA.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getDireccion());
            statement.setString(3, usuario.getTelefono());
            statement.setString(4, usuario.getIdentificacion());
            statement.setString(5, usuario.getApellido());
            statement.setString(6, usuario.getEmail());
            statement.setString(7, usuario.getContraseña());

            // Ejecutar la consulta
            int filasInsertadas = statement.executeUpdate();

            // Obtener el ID generado para el nuevo usuario
            if (filasInsertadas > 0) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    usuario.setId(resultSet.getInt(1));
                    System.out.println("Usuario registrado con ID: " + usuario.getId());
                }
            } else {
                System.out.println("No se pudo registrar el usuario.");
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
        }
    }    
public static Usuario buscarUsuarioPorId(ConnectionDBA connection, int id) {
        String query = "SELECT * FROM usuarios WHERE id = ?";
        try {
            PreparedStatement statement = ConnectionDBA.getConnection().prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String direccion = resultSet.getString("direccion");
                String telefono = resultSet.getString("telefono");
                String identificacion = resultSet.getString("identificacion");
                String apellido = resultSet.getString("apellido");
                String email = resultSet.getString("correo electrónico");
                String contraseña = resultSet.getString("contraseña");

                Usuario usuario = new Usuario(nombre, direccion, telefono, identificacion, apellido, email, contraseña);
                usuario.setId(id);
                return usuario;
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar usuario por ID: " + e.getMessage());
        }
        return null;
    }  
 public void actualizarUsuario(Usuario usuario) {
        String query = "UPDATE usuarios SET nombre = ?, direccion = ?, telefono = ?, identificacion = ? WHERE id = ?";
        try {
            PreparedStatement statement = ConnectionDBA.getConnection().prepareStatement(query);
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getDireccion());
            statement.setString(3, usuario.getTelefono());
            statement.setString(4, usuario.getIdentificacion());
            statement.setInt(5, usuario.getId());

            int filasActualizadas = statement.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("No se encontró el usuario para actualizar.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
    }
public void eliminarUsuario(Integer id) {
        String query = "DELETE FROM usuarios WHERE id = ?";
        try {
            PreparedStatement statement = ConnectionDBA.getConnection().prepareStatement(query);
            statement.setInt(1, id);

            int filasEliminadas = statement.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("No se encontró el usuario para eliminar.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuarios";
        try {
            PreparedStatement statement = ConnectionDBA.getConnection().prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String direccion = resultSet.getString("direccion");
                String telefono = resultSet.getString("telefono");
                String identificacion = resultSet.getString("identificacion");
                String apellido = resultSet.getString("apellido");
                String email = resultSet.getString("correo electrónico");

                Usuario usuario = new Usuario(id, nombre, direccion, telefono, identificacion, apellido, email);
                usuarios.add(usuario);

            }
        } catch (SQLException e) {
            System.out.println("Error al buscar usuario por ID: " + e.getMessage());
        }
        return usuarios;
    }
    
}
