/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica03.barbechonayeli.fernandezaroon.controlador;

import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.Idao.IControlador;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Cancion;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Compositor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ControladorCompositor {
    private Compositor compositor;
    private Cancion cancion;
    private IControlador compositorDAO;
     

    public ControladorCompositor(IControlador compositorDAO) {
        this.compositorDAO=compositorDAO;
       
    }
     
    
    public void crear(Compositor compositor){
        this.compositor=compositor;
        compositorDAO.create(compositor);
        
    }
    public void crearCancion(Cancion cancion,Compositor compositor){
        this.cancion=cancion;
        compositor.agregarCancion(cancion);
    }
    public Cancion buscarCancionPorTitulo(String titulo){
        compositor.leerCancionTitulo(titulo);
        System.out.println(this.compositor);
        return this.cancion;
        
    }
    
    public Cancion buscarCancion(int codigo){
        compositor.leerCancion(codigo);
        System.out.println(this.compositor);
        return this.cancion;
        
    }
    public boolean eliminarCancion(int codigo){
        Cancion cancionEncontrada=this.buscarCancion(codigo);
        if(cancionEncontrada!=null){
        compositor.eliminarCancion(codigo);
        return true;
        }
        return false;
    }
      public Compositor buscar(int codigo){
        this.compositor=compositorDAO.read(codigo);
        System.out.println(this.compositor);
        return this.compositor;
    }
      
     public boolean eliminarCompositor(int codigo) {
        Compositor compositorEncontrado=this.buscar(codigo);
        if(compositorEncontrado!=null){
            compositorDAO.delete(codigo);
            compositor.eliminarCancion(codigo);
            return true;
        }
        return false;
    }
    
    public boolean actualizar(Compositor compositor){
        Compositor compositorEncontrado =this.buscar(compositor.getCodigo());
        if(compositorEncontrado!=null){
            
            compositorDAO.update(compositor);
            return true;
        }
        return false;
    }
    public boolean actualizarCancion(Cancion cancion){
        Cancion cancionEncontrada=this.buscarCancion(cancion.getCodigo());
        if(cancionEncontrada!=null){
            compositor.actualizarCancion(cancion);
            
            return true;
        }
        return false;
    }
    public List<Cancion>listarCancion(){
        compositor.listarCanciones();
        return compositor.listarCanciones();
    }
    
    public List<Compositor>listar(){
        compositor.listarCanciones();
        return compositorDAO.list();
        
       
    }
    
}
