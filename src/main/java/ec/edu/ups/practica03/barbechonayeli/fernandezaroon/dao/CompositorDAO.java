/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica03.barbechonayeli.fernandezaroon.dao;

import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.Idao.IControlador;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Cancion;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Compositor;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class CompositorDAO implements IControlador {
    private List<Compositor> listaCompositor;
    private List<Cancion> listaCanciones;

    public CompositorDAO() {
        listaCompositor= new ArrayList<>();
    }
    

    @Override
    public void create(Compositor compositor) {
        listaCompositor.add(compositor);
    }
    public void crear(){
        
    }
    public void leer(){
        
    }
    public void actualizar(){
        
    }
    public void eliminar(){
        
    }

    

    @Override
    public Compositor read(int codigo) {
        for (Compositor compositor: listaCompositor) {
            if(compositor.getCodigo()==(codigo))
                return compositor;
            
        }
        return null;
    }

    @Override
    public void delete(int codigo) {
        for(int i=0;i<listaCompositor.size();i++){
            Compositor compositorGuardado=listaCompositor.get(i);
            if(compositorGuardado.getCodigo()==(codigo)){
                listaCompositor.remove(i);
                break;
            }
        }
       
    }

    @Override
    public List<Compositor> list() {
        return listaCompositor;
    }

    @Override
    public void update(Compositor compositor) {
        for(int i=0;i<listaCompositor.size();i++){
            Compositor compositorGuardado=listaCompositor.get(i);
            if(compositorGuardado.getCodigo()==(compositor.getCodigo())){
                listaCompositor.set(i, compositorGuardado);
                break;
            }
        }
    }

    public Cancion buscarPorTitulo(String titulo) {
        for(Compositor compositor : listaCompositor){
            if(compositor instanceof Compositor){
                for(Cancion cancion : compositor.getCancionesTop100()){
                    if(cancion.getTitulo().equals(titulo)){
                        
                        return cancion;
                    }
                }
            }
        }
        return null;
    }
    
}
