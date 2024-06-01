/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaprojectm.repositorio;

import vistas.ConnectionDBA;
import com.mycompany.bibliotecaprojectm.modelo.Libro;
import com.mycompany.bibliotecaprojectm.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class LibroRepositorio  {

    public void agregarLibro(Libro libro) {
        String query = "INSERT INTO libros (ISBN, titulo, autor, anio_publicacion, editorial, cantidad_disponible) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = ConnectionDBA.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, libro.getISBN());
            statement.setString(2, libro.getTitulo());
            statement.setString(3, libro.getAutor());
            statement.setInt(4, libro.getAnioPublicacion());
            statement.setString(5, libro.getEditorial());
            statement.setInt(6, libro.getCantidadDisponible());

            statement.executeUpdate();
            System.out.println("Libro agregado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar el libro a la base de datos: " + e.getMessage());
        }
    }

     public void actualizarLibro(Libro libro) {
        String query = "UPDATE libros SET titulo = ?, autor = ?, anio_publicacion = ?, editorial = ?, cantidad_disponible = ? WHERE ISBN = ?";
        try {
            PreparedStatement statement = ConnectionDBA.getConnection().prepareStatement(query);
            statement.setString(1, libro.getTitulo());
            statement.setString(2, libro.getAutor());
            statement.setInt(3, libro.getAnioPublicacion());
            statement.setString(4, libro.getEditorial());
            statement.setInt(5, libro.getCantidadDisponible());
            statement.setString(6, libro.getISBN());

            int filasActualizadas = statement.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Libro actualizado correctamente.");
            } else {
                System.out.println("No se encontró el libro para actualizar.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar libro: " + e.getMessage());
        }
    }
public void eliminarLibro(String ISBN) {
        String query = "DELETE FROM libros WHERE ISBN = ?";
        try {
            PreparedStatement statement = ConnectionDBA.getConnection().prepareStatement(query);
            statement.setString(1, ISBN);

            int filasEliminadas = statement.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Libro eliminado correctamente.");
            } else {
                System.out.println("No se encontró el libro para eliminar.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar libro: " + e.getMessage());
        }
    }
public List<Libro> listarLibros() {
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT * FROM libros";
        try {
            PreparedStatement statement = ConnectionDBA.getConnection().prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String ISBN = resultSet.getString("ISBN");
                String titulo = resultSet.getString("nombre");
                String autor = resultSet.getString("direccion");
                int anioPublicacion = resultSet.getInt("año publicación");
                String editorial = resultSet.getString("identificacion");
                int cantidadDisponible = resultSet.getInt("apellido");
                

                Libro libro = new Libro(ISBN, titulo, autor, anioPublicacion, editorial, cantidadDisponible);
                libros.add(libro);

            }
        } catch (SQLException e) {
            System.out.println("Error al buscar usuario por ID: " + e.getMessage());
        }
        return libros;
    }
}
