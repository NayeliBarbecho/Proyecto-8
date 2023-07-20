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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class CantanteDAO implements IControladorCantante {

    private List<Cantante> listaCantantes;
    private RandomAccessFile archivo;
    private String ruta;

    public CantanteDAO() {
        ruta = "src/main/resources/archivos/cantante.data";

        listaCantantes = new ArrayList<>();
    }

    @Override
    public void create(Cantante cantante) {
        try {
            archivo = new RandomAccessFile(ruta, "rw");

            long length = archivo.length();
            archivo.seek(length);
            archivo.writeInt(cantante.getCodigo());
            archivo.writeUTF(cantante.getNombre());
            archivo.writeUTF(cantante.getApellido());
            archivo.writeInt(cantante.getEdad());
            archivo.writeUTF(cantante.getNacionalidad());
            archivo.writeUTF(cantante.getNombreArtistico());
            archivo.writeInt(cantante.getNumeroDeConciertos());
            archivo.writeDouble(cantante.getSalario());
            archivo.writeInt(cantante.getNumeroDeGiras());
            archivo.writeInt(cantante.getNumeroDeSencillos());
            archivo.close();
        } catch (FileNotFoundException e1) {
            System.out.println("Ruta de archivo no econtrado");
        } catch (IOException e2) {
            System.out.println("Error de escritura");
        } catch (Exception e3) {
            System.out.println("Eror general");
        }

    }

    @Override
    public void update(Cantante cantante) {
        for (int i = 0; i < listaCantantes.size(); i++) {
            Cantante cantanteGuardado = listaCantantes.get(i);
            if (cantanteGuardado.getCodigo() == (cantante.getCodigo())) {
                listaCantantes.set(i, cantanteGuardado);
                break;
            }
        }
    }
    

   

    @Override
    public void delete(int codigo) {
        for (int i = 0; i < listaCantantes.size(); i++) {
            Cantante cantanteGuardado = listaCantantes.get(i);
            if (cantanteGuardado.getCodigo() == (codigo)) {
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
        for (Cantante cantante : listaCantantes) {
            if (cantante instanceof Cantante) {
                for (Disco disco : cantante.getDiscografia()) {
                    if (disco.getNombreDisco().equals(nombre)) {

                        return disco;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Cantante read(int codigo) {
        
        try {
            while (archivo.length()==150) {
                int codi=archivo.readInt();
            
                if(codi==codigo){
                
                
                //bytes 25
                String nombre=archivo.readUTF();
                
                //bytes 25
                String apellido=archivo.readUTF();
                
                //bytes 25
                String nacionalidad=archivo.readUTF();
                
                //bytes 42
                String nombreArtistico=archivo.readUTF();
                
                //8 bytes
                double salario=archivo.readDouble();
                
                int edad=archivo.readInt();
                
                int conciertos=archivo.readInt();
                
                int giras=archivo.readInt();
                
                int sencillos=archivo.readInt();
                
                Cantante cantante =new Cantante(nombreArtistico, nombre, sencillos, conciertos, giras, codigo, nombre, apellido, edad, nacionalidad, salario);
                for (int i = 1; i < 10; i++) {
                    
                }
                
            }
        
            
            }
               
                
            
        } catch (Exception e) {
        }
           
        
           
    
    
}
