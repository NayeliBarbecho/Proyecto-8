/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica03.barbechonayeli.fernandezaroon.dao;

import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.Idao.IControladorCantante;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Cancion;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Cantante;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Disco;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class CantanteDAO implements IControladorCantante {
    private List<Cantante> listaCantantes;
    private  String ruta = "C:\\Users\\LENOVO\\Music\\cantante.txt";
    
    

    public CantanteDAO() {
        
        listaCantantes= new ArrayList<>();
    }
    public void crear(Cantante cantante) {
   try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(ruta, true))) {
            // Escribir la información del compositor
            dos.write(cantante.getCodigo());
            dos.writeUTF(cantante.getNombre());
            dos.writeUTF(cantante.getApellido());
            dos.writeInt(cantante.getEdad());
             
        } catch (IOException e) {
            System.out.println("Error al crear el compositor: " + e.getMessage());
        }
    }

    

    @Override
    public void create(Cantante cantante) {
        listaCantantes.add(cantante);
    }

    @Override
    public void update(Cantante cantante) {
         for(int i=0;i<listaCantantes.size();i++){
            Cantante cantanteGuardado=listaCantantes.get(i);
            if(cantanteGuardado.getCodigo()==(cantante.getCodigo())){
                listaCantantes.set(i, cantanteGuardado);
                break;
            }
        }
    }

    @Override
    public Cantante read(int codigo) {
         for (Cantante cantante: listaCantantes) {
            if(cantante.getCodigo()==(codigo))
                return cantante;
            
        }
        return null;
    }

    @Override
    public void delete(int codigo) {
         for(int i=0;i<listaCantantes.size();i++){
            Cantante cantanteGuardado=listaCantantes.get(i);
            if(cantanteGuardado.getCodigo()==(codigo)){
                listaCantantes.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Cantante> list() {
        return listaCantantes;
    }

    @Override
    public Disco buscarPorNombreDeDisco(String nombre) {
        for(Cantante cantante : listaCantantes){
            if(cantante instanceof Cantante){
                for(Disco disco : cantante.getDiscografia()){
                    if(disco.getNombreDisco().equals(nombre)){
                        
                        return disco;
                    }
                }
            }
        }
        return null;
    }
    
}
