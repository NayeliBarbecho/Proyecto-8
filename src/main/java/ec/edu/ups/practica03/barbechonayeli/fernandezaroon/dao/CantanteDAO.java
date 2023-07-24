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
    private int conteoCantante = 0;

    public CantanteDAO() {
        ruta = "src/main/resources/archivos/cantante.data";

        listaCantantes = new ArrayList<>();
    }

    private String rellenarCadena(String cadena, int longitudDeseada) {
        int diferencia = longitudDeseada - cadena.length();
        if (diferencia > 0) {
            StringBuilder sb = new StringBuilder(cadena);
            for (int i = 0; i < diferencia; i++) {
                sb.append(" ");
            }
            return sb.toString();
        } else {
            return cadena.substring(0, longitudDeseada);
        }
    }

    private int tamañoRegistro() {
        int tamañoInt = Integer.BYTES;
        int tamañoDouble = Double.BYTES;

        // Tamaño fijo de cadenas (suponiendo que todos los campos String se ajustan a la longitud especificada)
        int tamañoStringNombre = 25 * 2; // Cada caracter UTF-8 ocupa 2 bytes
        int tamañoStringApellido = 25 * 2;
        int tamañoStringNacionalidad = 20 * 2;
        int tamañoStringNombreArtistico = 25 * 2;
        int tamañoStringGenero = 20 * 2;

        // Tamaño de la sección de discos (10 discos * 29 bytes por disco)
        int tamañoDiscos = 10 * 29;
        // Calcular el tamaño total del registro sumando los tamaños de los campos
        int tamañoTotal = tamañoInt + tamañoStringNombre + tamañoStringApellido + tamañoInt + tamañoStringNacionalidad
                + tamañoDouble + tamañoStringNombreArtistico + tamañoStringGenero + tamañoInt + tamañoInt
                + tamañoInt + tamañoDiscos;

        return tamañoTotal;
    }

    @Override

    public void create(Cantante cantante) {
        try {
            archivo = new RandomAccessFile(ruta, "rw");

            long length = archivo.length();
            archivo.seek(length);
            listaCantantes.add(cantante);

            // Calcular el tamaño de cada registro (suponiendo que es 250 bytes como en la implementación original)
            int tamañoRegistro = 250;

            // Posicionarse al final del archivo para agregar el nuevo registro
            archivo.seek(this.tamañoRegistro());

            // Escribir los datos del compositor en el archivo binario
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

            for (int i = 0; i < 10; i++) {
                int u = (int) i * 29;
                archivo.writeInt(0 + u);
                archivo.writeUTF(this.rellenarCadena("", 15 + u));
                archivo.writeInt(0 + u);
                archivo.close();
            }

            // Actualizar el conteo de compositores (si es necesario)
            // Incrementar el conteo de cantantes
            conteoCantante++;

            // Actualizar el conteo de cantantes al principio del archivo
            archivo.seek(0);
            archivo.writeInt(conteoCantante);
        } catch (IOException e) {
            e.printStackTrace();

        } catch (Exception e3) {
            System.out.println("Eror general");
        }

    }
    private long tamañoArchivo() throws IOException {
    // Mueve el puntero al final del archivo para obtener su tamaño
    archivo.seek(archivo.length());
    return archivo.getFilePointer();
}

    @Override
public void update(Cantante cantante) {
    try {
        long tamañoArchivo = this.tamañoArchivo();
        int tamañoRegistro = 250;

        for (long o = 0; o < tamañoArchivo; o += tamañoRegistro) {
            archivo.seek(o);
            int codigoCompositor = archivo.readInt();

            if (codigoCompositor == cantante.getCodigo()) {
                // Se encontró el cantante a actualizar, mover el puntero a la posición correcta
                archivo.seek(o);

                // Actualizar los datos del cantante
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

                // Mover el puntero a la posición de discografía
                archivo.seek(161 + o);

                // Actualizar los discos del cantante
                List<Disco> discos = cantante.getDiscografia();
                for (int j = 0; j < 10; j++) {
                    int u = (int) j * 29;
                    if (j < discos.size()) {
                        Disco disco = discos.get(j);
                        archivo.writeInt(disco.getCodigo());
                        archivo.writeUTF(this.rellenarCadena(disco.getNombreDisco(), 15 + u));
                        archivo.writeInt(disco.getAnioDeLanzamiento());
                    } else {
                        archivo.writeInt(0 + u);
                        archivo.writeUTF(this.rellenarCadena("", 15 + u));
                        archivo.writeInt(0 + u);
                    }
                }

                // Salir del bucle ya que hemos actualizado los datos del cantante
                break;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
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
        long tamañoArchivo = this.tamañoArchivo();
        int tamañoRegistro = 250;

        for (long o = 0; o < tamañoArchivo; o += tamañoRegistro) {
            archivo.seek(o);
            int codigoCompositor = archivo.readInt();

            if (codigoCompositor == codigo) {
                Cantante cantante = new Cantante();

                cantante.setCodigo(codigo);
                cantante.setNombre(archivo.readUTF());
                cantante.setApellido(archivo.readUTF());
                cantante.setEdad(archivo.readInt());
                cantante.setNacionalidad(archivo.readUTF());
                cantante.setSalario(archivo.readDouble());
                cantante.setNombreArtistico(archivo.readUTF());
                cantante.setGeneroMusica(archivo.readUTF());
                cantante.setNumeroDeSencillos(archivo.readInt());
                cantante.setNumeroDeConciertos(archivo.readInt());
                cantante.setNumeroDeGiras(archivo.readInt());

                archivo.seek(161 + o);
                 for (int j = 0; j < 10; j++) {
                    int u = (int) j * 29;
                    int codigoDisco = archivo.readInt();
                    String nombreDisco = archivo.readUTF();
                    int anioDisco = archivo.readInt();
                    Disco disco = new Disco(codigoDisco, nombreDisco, anioDisco);
                    cantante.agregarDisco(disco);
                }

                return cantante;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return null; // Si no se encuentra el compositor con el código dado, devolver null
}

}
