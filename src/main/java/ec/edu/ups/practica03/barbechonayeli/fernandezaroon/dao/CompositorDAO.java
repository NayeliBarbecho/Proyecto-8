/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica03.barbechonayeli.fernandezaroon.dao;

import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.Idao.IControlador;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Cancion;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Cantante;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Compositor;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Disco;
import ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo.Persona;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class CompositorDAO implements IControlador {

    private List<Compositor> listaCompositor;
    private List<Cancion> listaCanciones;
    private RandomAccessFile archivo;
    private String ruta;

    public CompositorDAO() {
        listaCompositor = new ArrayList<>();
        ruta = "src/main/resources/archivos/compositor.data";
        archivo = crearArchivo();
    }

    private RandomAccessFile crearArchivo() {
        try {
            return new RandomAccessFile("src/main/resources/archivos/cantante.data", "rw");
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
    public void create(Compositor compositor) {
        try {
            archivo.seek(this.obtenerTamañoArchivo());
            archivo.writeInt(compositor.getCodigo());

            archivo.writeUTF(this.rellenarCadena(compositor.getNombre(), 25));
            archivo.writeUTF(this.rellenarCadena(compositor.getApellido(), 25));
            archivo.writeInt(compositor.getEdad());

            archivo.writeUTF(this.rellenarCadena(compositor.getNacionalidad(), 20));

            archivo.writeDouble(compositor.getSalario());

            archivo.writeInt(compositor.getNumeroDeComposiciones());

            //150
            for (int i = 0; i < 10; i++) {
                archivo.writeInt(0);
                archivo.writeUTF(this.rellenarCadena("", 15));
                archivo.writeUTF(this.rellenarCadena("", 100));
                archivo.writeDouble(0);
            }

        } catch (IOException e) {

        }
    }

    @Override
    public Compositor read(int codigo) {
        try {
            archivo.seek(0);
            for (int i = 0; i < this.obtenerTamañoArchivo(); i += 4982) {
                archivo.seek(i);
                if (archivo.readInt() == codigo) {
                    archivo.seek(i);
                    int cod = archivo.readInt();
                    String nombre = archivo.readUTF();
                    String apellido = archivo.readUTF();
                    int edad = archivo.readInt();
                    String nacionalidad = archivo.readUTF();
                    double salario = archivo.readDouble();
                    Compositor compositor = new Compositor(codigo, codigo, nombre, apellido, edad, nacionalidad, salario);
                    for (int j = 0; j < 10; j++) {
                        int codigoCancion = archivo.readInt();
                        if (codigoCancion != 0) {
                            String titulo = archivo.readUTF();
                            String letra = archivo.readUTF();
                            double duracion = archivo.readDouble();
                            compositor.agregarCancion(new Cancion(codigoCancion, titulo, letra, duracion));
                        }

                    }
                    for (int j = 0; j < 10; j++) {
                        int codCantante = archivo.readInt();
                        if (codCantante != 0) {
                            String nombreCantante = archivo.readUTF();
                            String apellidoCantante = archivo.readUTF();
                            int edadCantante = archivo.readInt();
                            String nacionalidadCantante = archivo.readUTF();
                            double salarioCantante = archivo.readDouble();
                            String nombreArtistico = archivo.readUTF();
                            String genero = archivo.readUTF();
                            int numConciertos = archivo.readInt();
                            int numSencillos = archivo.readInt();
                            int numGiras = archivo.readInt();
                            Cantante cantante = new Cantante(nombreArtistico, genero, numSencillos, numConciertos, numGiras, codigo, nombre, apellido, edad, nacionalidad, salario);

                            for (int k = 0; k < 10; k++) {

                                int codigoDisco = archivo.readInt();
                                if (codigoDisco != 0) {
                                    String nombreDisco = archivo.readUTF();
                                    int anio = archivo.readInt();
                                    cantante.agregarDisco(new Disco(codigoDisco, nombreDisco, anio));
                                } else {
                                    break;
                                }

                            }
                            compositor.agregarCliente(cantante);
                        }
                    }
                    return compositor;
                }

            }
        } catch (IOException e) {
            return null;
        }
        return null;
    }

    @Override
    public void delete(Compositor compositor) {
        try {
            archivo.seek(0);
            for (int i = 0; i < this.obtenerTamañoArchivo(); i += 4982) {
                archivo.seek(i);
                if (archivo.readInt() == compositor.getCodigo()) {
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

                    for (int j = 0; j < 10; j++) {
                        archivo.writeInt(0);
                        archivo.writeUTF(this.rellenarCadena("", 15));
                        archivo.writeUTF(this.rellenarCadena("", 100));
                        archivo.write(0);
                    }

                }
            }

        } catch (IOException e) {
        }

    }

    @Override
    public List<Compositor> list() {
        try {
            archivo.seek(0);
            List<Compositor> lista = new ArrayList<>();
            for (int i = 0; i < this.obtenerTamañoArchivo(); i += 4982) {

                archivo.seek(i);
                int cod = archivo.readInt();
                String nombre = archivo.readUTF();
                String apellido = archivo.readUTF();
                int edad = archivo.readInt();
                String nacionalidad = archivo.readUTF();
                double salario = archivo.readDouble();

                int numComposiciones = archivo.readInt();

                Compositor compositor = new Compositor(numComposiciones, cod, nombre, apellido, edad, nacionalidad, salario);

                for (int j = 0; j < 10; j++) {

                    int codigoCancion = archivo.readInt();
                    if (codigoCancion != 0) {
                        String titulo = archivo.readUTF();
                        String letra = archivo.readUTF();
                        double tiempoMinutos = archivo.readDouble();
                        compositor.agregarCancion(new Cancion(cod, titulo, letra, tiempoMinutos));
                    } else {
                        break;
                    }

                }
                listaCompositor.add(compositor);

            }
            return listaCompositor;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void update(Compositor compositor) {
        try {
            archivo.seek(0);
            for (int i = 0; i < this.obtenerTamañoArchivo(); i += 4982) {
                archivo.seek(i);
                if (archivo.readInt() == compositor.getCodigo()) {
                    archivo.seek(i);
                    archivo.writeInt(compositor.getCodigo());

                    archivo.writeUTF(this.rellenarCadena(compositor.getNombre(), 25));

                    archivo.writeUTF(this.rellenarCadena(compositor.getApellido(), 25));

                    archivo.writeInt(compositor.getEdad());

                    archivo.writeUTF(this.rellenarCadena(compositor.getNacionalidad(), 20));

                    archivo.writeDouble(compositor.getSalario());

                    archivo.writeInt(compositor.getNumeroDeComposiciones());

                    if (compositor.listarCanciones() != null) {
                        for (Cancion cancion : compositor.listarCanciones()) {
                            archivo.writeInt(cancion.getCodigo());
                            archivo.writeUTF(this.rellenarCadena(cancion.getTitulo(), 15));
                            archivo.writeUTF(this.rellenarCadena(cancion.getLetra(), 25));
                            archivo.writeDouble(cancion.getTiempoEnMinutos());
                        }
                    } else {
                        for (int j = 0; j < 10; j++) {
                            archivo.writeInt(0);
                            archivo.writeUTF(this.rellenarCadena("", 15));
                            archivo.writeUTF(this.rellenarCadena("", 100));
                            archivo.writeDouble(0);
                        }
                    }
                }
            }

        } catch (IOException e) {
        }
    }

    public Cancion buscarPorTitulo(String titulo) {
        for (Compositor compositor : listaCompositor) {
            if (compositor instanceof Compositor) {
                for (Cancion cancion : compositor.getCancionesTop100()) {
                    if (cancion.getTitulo().equals(titulo)) {

                        return cancion;
                    }
                }
            }
        }
        return null;
    }

}
