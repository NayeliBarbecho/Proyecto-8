/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica03.barbechonayeli.fernandezaroon.Idao;

import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Cantante;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Disco;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface IControladorCantante {
    public void create (Cantante cantante);
    public  Cantante read(int codigo);
    public void update(Cantante cantante);
    public void delete(Cantante cantante);
    public List<Cantante> list();
    public Disco buscarPorNombreDeDisco(String nombre);
    
   
   
}
