/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica03.barbechonayeli.fernandezaroon.controlador;

import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.Idao.IControladorCantante;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Cantante;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Disco;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class ControladorCantante {
    private Cantante cantante;
    private Disco disco;
    private IControladorCantante cantanteDAO;
    

    public ControladorCantante(IControladorCantante cantanteDAO) {
        this.cantanteDAO=cantanteDAO;
        
    }
    public void crear(Cantante cantante){
        this.cantante=cantante;
        cantanteDAO.create(cantante);
        
    }
   
   
    public void crearDisco(Disco disco,Cantante cantante){
        this.disco=disco;
        cantante.agregarDisco(disco);
    }
    public Cantante buscar(int codigo){
        this.cantante=cantanteDAO.read(codigo);
        System.out.println(this.cantante);
        return this.cantante;
    }
     public boolean eliminar(int codigo) {
        Cantante cantanteEncontrado=this.buscar(codigo);
        if(cantanteEncontrado!=null){
            cantanteDAO.delete(codigo);
            cantante.eliminarDisco(codigo);
            return true;
        }
        return false;
    }
     public Disco buscarporDisco(String nombre){
        return cantanteDAO.buscarPorNombreDeDisco(nombre);
    }
     public boolean eliminarDisco(int codigo){
        Disco disconcontrado=this.buscarDisco(codigo);
        if(disconcontrado!=null){
        cantante.eliminarDisco(codigo);
        return true;
        }
        return false;
     }
     

    
    
      public boolean actualizarDisco(Disco disco){
        
         Disco discoEncontrado =this.buscarDisco(disco.getCodigo());
        if(discoEncontrado!=null){
            cantante.actualizarDisco(disco);
            
            return true;
        }
        return false;   
            
         
    }
       public Disco buscarDisco(int codigo){
        cantante.leerDisco(codigo);
        System.out.println(this.cantante);
        return this.disco;
        
    }
     
    
    public boolean actualizar(Cantante cantante){
        Cantante cantanteEncontrado =this.buscar(cantante.getCodigo());
        if(cantanteEncontrado!=null){
            
            cantanteDAO.update(cantante);
            return true;
        }
        return false;
    }
     public List<Disco>listarDisco(){
        cantante.listarDisco();
        return cantante.listarDisco();
    }
    public List<Cantante>listar(){
        return cantanteDAO.list();
    }
}
