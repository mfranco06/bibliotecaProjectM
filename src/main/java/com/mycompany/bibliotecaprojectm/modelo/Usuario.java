/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaprojectm.modelo;

import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author Marcos
 */
public class Usuario {
    public static List<Usuario> listaUsuarios = new ArrayList<>();
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String identificacion;
    private String apellido;
    private String email;
    private String contraseña;
    private int rol;

    
    
public Usuario(String nombre, String direccion, String telefono, String identificacion,String apellido, String email, String contraseña) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
    } 

    public Usuario(int id, String nombre, String direccion, String telefono, String identificacion, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.apellido = apellido;
        this.email = email;
        
    }

    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

public Usuario(){}

public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
}
    