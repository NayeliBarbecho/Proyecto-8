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
import java.nio.charset.StandardCharsets;
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

        archivo = crearArchivo();
        listaCantantes = new ArrayList<>();
    }

    private RandomAccessFile crearArchivo() {
        try {
            return new RandomAccessFile("src/main/resources/archivos/cantante2.data", "rw");
        } catch (FileNotFoundException e) {
            return null;
        }

    }

    private int obtenerTamañoArchivo() {
        try {
            return (int) this.archivo.length();
        } catch (IOException e) {
            return 0;
        }
    }

    private String rellenarCadena(String cadena, int longitudDeseada) {
        return String.format("%-" + longitudDeseada + "s", cadena).substring(0, longitudDeseada);
    }

    @Override
    public void create(Cantante cantante) {
        try {
            archivo.seek(this.obtenerTamañoArchivo());
            archivo.writeInt(cantante.getCodigo());

            archivo.writeUTF(this.rellenarCadena(cantante.getNombre(), 25));
            archivo.writeUTF(this.rellenarCadena(cantante.getApellido(), 25));
            archivo.writeInt(cantante.getEdad());

            archivo.writeUTF(this.rellenarCadena(cantante.getNacionalidad(), 20));

            archivo.writeDouble(cantante.getSalario());

            archivo.writeUTF(this.rellenarCadena(cantante.getNombreArtistico(), 25));

            archivo.writeUTF(this.rellenarCadena(cantante.getGeneroMusica(), 20));
            archivo.writeInt(cantante.getNumeroDeSencillos());

            archivo.writeInt(cantante.getNumeroDeConciertos());

            archivo.writeInt(cantante.getNumeroDeGiras());
            //149
            for (int i = 0; i < 10; i++) {
                archivo.writeInt(0);
                archivo.writeUTF(this.rellenarCadena("", 15));
                archivo.writeInt(0);
            }

        } catch (IOException e) {

        }
    }

    @Override
    public Cantante read(int codigo) {
        try {
            archivo.seek(0);

            for (int i = 0; i < this.obtenerTamañoArchivo(); i += 399) {
                archivo.seek(i);
                if (archivo.readInt() == codigo) {
                    archivo.seek(i);
                    int cod = archivo.readInt();
                    String nombre = archivo.readUTF();
                    String apellido = archivo.readUTF();
                    int edad = archivo.readInt();
                    String nacionalidad = archivo.readUTF();
                    double salario = archivo.readDouble();
                    String nombreArtistico = archivo.readUTF();
                    String genero = archivo.readUTF();
                    int numSencillos = archivo.readInt();
                    int numConciertos = archivo.readInt();
                    int numGiras = archivo.readInt();
                    Cantante cantante = new Cantante(nombreArtistico, genero, numSencillos, numConciertos, numGiras, codigo, nombre, apellido, edad, nacionalidad, salario);

                    for (int j = 0; j < 10; j++) {

                        int codigoDisco = archivo.readInt();
                        if (codigoDisco != 0) {
                            String nombreDisco = archivo.readUTF();
                            int anio = archivo.readInt();
                            cantante.agregarDisco(new Disco(codigoDisco, nombreDisco, anio));
                        } else {
                            return cantante;
                        }

                    }
                    return cantante;
                }

            }
        } catch (IOException e) {
            return null;
        }
        return null;
    }

    @Override
    public void update(Cantante cantante) {
        try {
            archivo.seek(0);
            for (int i = 0; i < this.obtenerTamañoArchivo(); i += 399) {
                archivo.seek(i);
                if (archivo.readInt() == cantante.getCodigo()) {
                    archivo.seek(i);
                    archivo.writeInt(cantante.getCodigo());

                    archivo.writeUTF(this.rellenarCadena(cantante.getNombre(), 25));

                    archivo.writeUTF(this.rellenarCadena(cantante.getApellido(), 25));

                    archivo.writeInt(cantante.getEdad());

                    archivo.writeUTF(this.rellenarCadena(cantante.getNacionalidad(), 20));

                    archivo.writeDouble(cantante.getSalario());

                    archivo.writeUTF(this.rellenarCadena(cantante.getNombreArtistico(), 25));

                    archivo.writeUTF(this.rellenarCadena(cantante.getGeneroMusica(), 20));

                    archivo.writeInt(cantante.getNumeroDeConciertos());
                    archivo.writeInt(cantante.getNumeroDeSencillos());

                    archivo.writeInt(cantante.getNumeroDeGiras());
                    if (cantante.listarDisco() != null) {
                        for (Disco disco : cantante.listarDisco()) {
                            archivo.writeInt(disco.getCodigo());
                            archivo.writeUTF(this.rellenarCadena(disco.getNombreDisco(), 15));
                            archivo.writeInt(disco.getAnioDeLanzamiento());
                        }
                    } else {
                        for (int j = 0; j < 10; j++) {
                            archivo.writeInt(0);
                            archivo.writeUTF(this.rellenarCadena("", 15));
                            archivo.writeInt(0);
                        }
                    }
                }
            }

        } catch (IOException e) {
        }
    }

    @Override
    public void delete(Cantante cantante) {
        try {
            archivo.seek(0);
            for (int i = 0; i < this.obtenerTamañoArchivo(); i += 399) {
                archivo.seek(i);
                if (archivo.readInt() == cantante.getCodigo()) {
                    archivo.seek(i);
                    archivo.writeInt(0);

                    archivo.writeUTF(this.rellenarCadena("", 25));

                    archivo.writeUTF(this.rellenarCadena("", 25));

                    archivo.writeInt(0);

                    archivo.writeUTF(this.rellenarCadena("", 20));

                    archivo.writeDouble(0);

                    archivo.writeUTF(this.rellenarCadena("", 25));

                    archivo.writeUTF(this.rellenarCadena("", 20));

                    archivo.writeInt(0);

                    archivo.writeInt(0);

                    for (int j = 0; j < 10; j++) {
                        archivo.writeInt(0);
                        archivo.writeUTF(this.rellenarCadena("", 15));
                        archivo.writeInt(0);
                    }

                }
            }

        } catch (IOException e) {
        }
    }

    @Override
    public List<Cantante> list() {
        try {
            archivo.seek(0);
            List<Cantante> lista = new ArrayList<>();
            for (int i = 0; i < this.obtenerTamañoArchivo(); i += 399) {

                archivo.seek(i);
                int cod = archivo.readInt();
                String nombre = archivo.readUTF();
                String apellido = archivo.readUTF();
                int edad = archivo.readInt();
                String nacionalidad = archivo.readUTF();
                double salario = archivo.readDouble();
                String nombreArtistico = archivo.readUTF();
                String genero = archivo.readUTF();
                int numConciertos = archivo.readInt();
                int numSencillos = archivo.readInt();
                int numGiras = archivo.readInt();
                Cantante cantante = new Cantante(nombreArtistico, genero, numSencillos, numConciertos, numGiras, cod, nombre, apellido, edad, nacionalidad, salario);

                for (int j = 0; j < 10; j++) {

                    int codigoDisco = archivo.readInt();
                    if (codigoDisco != 0) {
                        String nombreDisco = archivo.readUTF();
                        int anio = archivo.readInt();
                        cantante.agregarDisco(new Disco(codigoDisco, nombreDisco, anio));
                    } else {
                        break;
                    }

                }
                lista.add(cantante);

            }
            return lista;
        } catch (IOException e) {
            return null;
        }

    }

    //
//        @Override
//        public Cantante buscarPorDisco(String nombre) {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        }
    @Override
    public Disco buscarPorNombreDeDisco(String nombre) {
         for (Cantante cantante : listaCantantes) {
        List<Disco> discos = cantante.listarDisco();
        if (discos != null) {
            for (Disco disco : discos) {
                if (disco.getNombreDisco().equalsIgnoreCase(nombre)) {
                    return disco;
                }
            }
        }
    }
    return null;
    }

}
