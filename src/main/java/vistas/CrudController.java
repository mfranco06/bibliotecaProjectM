/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import java.util.List;

/**
 *
 * @author Marcos
 */
public interface CrudController<T,ID> {
    
    public void guardar(T objecto);
    public void eliminar(ID id);
    public void actualizar(T objecto);
    public List<T> listarTodos();
    
}
