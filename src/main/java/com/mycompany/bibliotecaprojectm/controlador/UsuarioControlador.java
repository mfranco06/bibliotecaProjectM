/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaprojectm.controlador;

import vistas.CrudController;
import com.mycompany.bibliotecaprojectm.modelo.Usuario;
import com.mycompany.bibliotecaprojectm.repositorio.UsuarioRepositorio;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class UsuarioControlador implements CrudController<Usuario, Integer> {

    private final UsuarioRepositorio repositorio = new UsuarioRepositorio();
    
    @Override
    public void guardar(Usuario usuario) {
       repositorio.registrarUsuario(usuario); 
    }

    @Override
    public void actualizar(Usuario usuario) {
    repositorio.actualizarUsuario(usuario);
    }

    @Override
    public List<Usuario> listarTodos() {
       return repositorio.listarUsuarios();
    }

    @Override
    public void eliminar(Integer id) {
        repositorio.eliminarUsuario(id);
    }
    
    public Usuario buscarUsuario(int id){
    
     return Usuario.listaUsuarios.stream()
             .filter(usuario->usuario.getId() ==id)
             .findFirst()
             .orElse(null);
    }
    public Usuario login(String email, String password) {
        return Usuario.listaUsuarios.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email) && u.getContraseña().equals(password))
                .findFirst()
                .orElse(null);
    }
}
