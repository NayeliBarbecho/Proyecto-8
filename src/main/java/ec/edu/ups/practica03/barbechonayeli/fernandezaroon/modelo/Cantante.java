/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class Cantante extends Persona {

    private String nombreArtistico;
    private String generoMusica;
    private int numeroDeSencillos;
    private int numeroDeConciertos;
    private int numeroDeGiras;
    private ArrayList<Disco> discografia;
    private Disco disco;
    private RandomAccessFile archivo;
    private String ruta;

//constructor con el arreglo de discografia
    public Cantante() {
        ruta = "src/main/resources/archivos/cantante2.data";
        archivo = crearArchivo();

        this.discografia = new ArrayList<>();
    }

    private RandomAccessFile crearArchivo() {
        try {
            return new RandomAccessFile("src/main/resources/archivos/cantante.data", "rw");
        } catch (FileNotFoundException e) {
            return null;
        }

    }

    public Cantante(String nombreArtistico, String generoMusica, int numeroDeSencillos, int numeroDeConciertos, int numeroDeGiras, int codigo, String nombre, String apellido, int edad, String nacionalidad, double salario) {
        super(codigo, nombre, apellido, edad, nacionalidad, salario);
        this.nombreArtistico = nombreArtistico;
        this.generoMusica = generoMusica;
        this.numeroDeSencillos = numeroDeSencillos;
        this.numeroDeConciertos = numeroDeConciertos;
        this.numeroDeGiras = numeroDeGiras;
        discografia = new ArrayList();
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getGeneroMusica() {
        return generoMusica;
    }

    public void setGeneroMusica(String generoMusica) {
        this.generoMusica = generoMusica;
    }

    public int getNumeroDeSencillos() {
        return numeroDeSencillos;
    }

    public void setNumeroDeSencillos(int numeroDeSencillos) {
        this.numeroDeSencillos = numeroDeSencillos;
    }

    public ArrayList<Disco> getDiscografia() {
        return discografia;
    }

    public int getNumeroDeConciertos() {
        return numeroDeConciertos;
    }

    public void setNumeroDeConciertos(int numeroDeConciertos) {
        this.numeroDeConciertos = numeroDeConciertos;
    }

    public int getNumeroDeGiras() {
        return numeroDeGiras;
    }

    public void setNumeroDeGiras(int numeroDeGiras) {
        this.numeroDeGiras = numeroDeGiras;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.discografia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cantante other = (Cantante) obj;
        if (!Objects.equals(this.discografia, other.discografia)) {
            return false;
        }
        return true;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public double calcularSalario() {

        double salarioTotal = getSalario();
        if (getNumeroDeSencillos() > 10 && getNumeroDeGiras() > 3) {
            salarioTotal += 1000;
        } else if (getNumeroDeSencillos() > 0 && getNumeroDeSencillos() <= 10) {
            salarioTotal *= 1.05;
        }

        if (getNumeroDeGiras() > 0 && getNumeroDeGiras() <= 3) {
            salarioTotal *= 1.03;
        }
        if (discografia.size() >= 5) {

            salarioTotal
                    += 2000;
        }

        return salarioTotal;

    }

    public void agregarDisco(Disco discos) {

        discografia.add(discos);

    }

    private int obtenerTamañoArchivo() {
        try {
            return (int) this.archivo.length();
        } catch (IOException e) {
            return 0;
        }
    }

    public void createDisco(Disco disco) {
        try {
            archivo.seek(0);
            if (getNumeroDeSencillos() == 10) {
                return;
            }
            for (int i = 0; i < this.obtenerTamañoArchivo(); i += 350) {
                archivo.seek(i);
                if (archivo.readInt() == getCodigo()) {
                    archivo.seek(i + 149 + (getNumeroDeSencillos() * 25));
                    archivo.writeInt(disco.getCodigo());
                    archivo.writeUTF(disco.getNombreDisco());
                    archivo.writeInt(disco.getAnioDeLanzamiento());
                    break;
                }
            }

        } catch (IOException e) {

        }
    }

    public Disco readDisco(int codigo) {
        try {
            archivo.seek(0);

            for (int i = 0; i < this.obtenerTamañoArchivo(); i += 350) {
                archivo.seek(i);
                if (archivo.readInt() == getCodigo()) {
                    for (int j = 0; j < 10; j++) {
                        archivo.seek(i + 149 + (i * 25));
                        if (archivo.readInt() == codigo) {
                            archivo.seek(i + 149 + (i * 25));
                            int codigon = archivo.readInt();
                            String nombre = archivo.readUTF();
                            int anio = archivo.readInt();
                            return new Disco(codigon, nombre, anio);
                        }
                    }
                }
            }
            return null;

        } catch (IOException e) {
            return null;
        }
    }

    public void updateDisco(Disco disco) {
        try {
            archivo.seek(0);

            for (int i = 0; i < obtenerTamañoArchivo(); i += obtenerTamañoArchivo()) {
                archivo.seek(i);
                if (archivo.readInt() == getCodigo()) {
                    for (int j = 0; j < 10; j++) {
                        archivo.seek(i + 149 + (j * 25));
                        int codigoDisco = archivo.readInt();
                        if (codigoDisco == disco.getCodigo()) {
                            archivo.writeInt(disco.getCodigo());
                            archivo.writeUTF(disco.getNombreDisco());
                            archivo.writeInt(disco.getAnioDeLanzamiento());
                            break;
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error al actualizar el disco");
        }
    }

    public void deleteDisco(Disco disco) {
        try {
            archivo.seek(0);

            for (int i = 0; i < obtenerTamañoArchivo(); i += obtenerTamañoArchivo()) {
                archivo.seek(i);
                if (archivo.readInt() == getCodigo()) {
                    for (int j = 0; j < 10; j++) {
                        archivo.seek(i + 149 + (j * 25));
                        int codigoDisco = archivo.readInt();
                        if (codigoDisco == disco.getCodigo()) {
                            archivo.writeInt(0);
                            archivo.writeUTF("");
                            archivo.writeInt(0);
                            break;
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error al eliminar el disco");
        }
    }

    public List<Disco> listarDisco() {
        return discografia;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCantante{" + "nombreArtistico=" + nombreArtistico + ", generoMusica=" + generoMusica + ", numeroDeSencillos=" + numeroDeSencillos + ", numeroDeConciertos=" + numeroDeConciertos + ", numeroDeGiras=" + numeroDeGiras + ", discografia=" + discografia + '}';
    }

}
