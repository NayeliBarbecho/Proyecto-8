/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica03.barbechonayeli.fernandezaroon.Idao;


import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Cancion;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Compositor;

import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Persona;
import java.util.List;




/**
 *
 * @author LENOVO
 */
public interface  IControlador {
   
    public void  create(Compositor compositor );
    public void update(Compositor compositor);
    public abstract Compositor read(int codigo);
    public void delete(int codigo);
    public Cancion  buscarPorTitulo(String titulo);
    public List<Compositor> list();
   
        
    
   
}
