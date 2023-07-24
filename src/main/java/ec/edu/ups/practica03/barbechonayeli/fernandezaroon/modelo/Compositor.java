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
public class Compositor extends Persona {
    //atributos
   private int numeroDeComposiciones;
   //lista de la Clase cancion 
   
   private ArrayList<Cancion> cancionesTop100;
   //lista de la clase cantante
   private ArrayList<Cantante>clientes;
//Constructor con parametros
   private RandomAccessFile archivo;
    private String ruta;
      

    public Compositor() {
        ruta = "src/main/resources/archivos/compositor.data";
        archivo = crearArchivo();
        this.cancionesTop100 = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }
    
    private RandomAccessFile crearArchivo() {
        try {
            return new RandomAccessFile("src/main/resources/archivos/cantante.data", "rw");
        } catch (FileNotFoundException e) {
            return null;
        }

    }

    public Compositor(int numeroDeComposiciones, int codigo, String nombre, String apellido, int edad, String nacionalidad, double salario) {
        super(codigo, nombre, apellido, edad, nacionalidad, salario);
        this.numeroDeComposiciones = numeroDeComposiciones;
        cancionesTop100 = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public ArrayList<Cancion> getCancionesTop100() {
        return cancionesTop100;
    }

    public ArrayList<Cantante> getClientes() {
        return clientes;
    }
 public List<Cancion> listarCanciones() {
        try  {
        archivo.seek(0);

        for (int i = 0; i < obtenerTamañoArchivo(); i += obtenerTamañoArchivo()) {
            archivo.seek(i);
            if (archivo.readInt() == getCodigo()) {
                for (int j = 0; j < 10; j++) {
                    archivo.seek(i + 149 + (j * 25));
                    int codigoDisco = archivo.readInt();
                    if (codigoDisco != 0) {
                        String Titulo = archivo.readUTF();
                        String letra = archivo.readUTF();
                        
                        double tiempoM=archivo.readDouble();
                        cancionesTop100.add(new Cancion(codigoDisco, Titulo, letra, tiempoM));
                    }
                }
                break;
            }
        }

    } catch (IOException e) {
        System.out.println("Error al listar los discos");
    }

    return cancionesTop100;
    }

   

  
   
   

   
    
//Conatructor vacio
   
    //Getters y Setters

    public int getNumeroDeComposiciones() {
        return numeroDeComposiciones;
    }

    public void setNumeroDeComposiciones(int numeroDeComposiciones) {
        this.numeroDeComposiciones = numeroDeComposiciones;
    }

    

    
//Hashcode y Equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.cancionesTop100);
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
        final Compositor other = (Compositor) obj;
        if (!Objects.equals(this.cancionesTop100, other.cancionesTop100)) {
            return false;
        }
        return true;
    }
    private int obtenerTamañoArchivo() {
          try {
            return (int) this.archivo.length();
        } catch (IOException e) {
            return 0;
        }
    }
    
    public void agregarCancion(Cancion cancion) {
       try {
            archivo.seek(0);
            if (getNumeroDeComposiciones()== 10) {
                return;
            }
            for (int i = 0; i < this.obtenerTamañoArchivo(); i += 350) {
                archivo.seek(i);
                if (archivo.readInt() == getCodigo()) {
                    archivo.seek(i + 133 + (getNumeroDeComposiciones()* 25));
                    archivo.writeInt(cancion.getCodigo());
                    archivo.writeUTF(cancion.getLetra());
                    archivo.writeUTF(cancion.getTitulo());
                    archivo.writeDouble(cancion.getTiempoEnMinutos());;
                    break;
                }
            }

        } catch (IOException e) {
            

        }
        
        
    }
    

   public void actualizarCancion(Cancion cancion){
       
    try  {
        archivo.seek(0);

        for (int i = 0; i < obtenerTamañoArchivo(); i += obtenerTamañoArchivo()) {
            archivo.seek(i);
            if (archivo.readInt() ==getCodigo()) {
                for (int j = 0; j < 10; j++) {
                    archivo.seek(i + 133 + (j * 25));
                    int codigoCancion = archivo.readInt();
                    if (codigoCancion == cancion.getCodigo()) {
                        archivo.writeInt(cancion.getCodigo());
                        archivo.writeUTF(cancion.getTitulo());
                        archivo.writeUTF(cancion.getLetra());
                        archivo.writeDouble(cancion.getTiempoEnMinutos());
                        break;
                    }
                }
            }
        }

    } catch (IOException e) {
        System.out.println("Error al actualizar el disco");
    }
}
    public void eliminarCancion(Cancion cancion){
         try  {
        archivo.seek(0);

        for (int i = 0; i < obtenerTamañoArchivo(); i += obtenerTamañoArchivo()) {
            archivo.seek(i);
            if (archivo.readInt() == getCodigo()) {
                for (int j = 0; j < 10; j++) {
                    archivo.seek(i + 149 + (j * 25));
                    int codigoDisco = archivo.readInt();
                    if (codigoDisco == cancion.getCodigo()) {
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
     public Cancion leerCancionTitulo(int codigo){
        for (Cancion cancion: cancionesTop100) {
            if(cancion.getCodigo()==(codigo))
                return cancion;
            
        }
        return null;
    }
      public void agregarCliente(Cantante cliente) {
        clientes.add(cliente);
    }

    
    public Cancion leerCancion(int codigo){
        try {
            archivo.seek(0);

            for (int i = 0; i < this.obtenerTamañoArchivo(); i += 350) {
                archivo.seek(i);
                if (archivo.readInt() == getCodigo()) {
                    for (int j = 0; j < 10; j++) {
                        archivo.seek(i + 133 + (i * 25));
                        if (archivo.readInt() == codigo) {
                            archivo.seek(i + 149 + (i * 25));
                            int codigon = archivo.readInt();
                            String titulo = archivo.readUTF();
                            String letra = archivo.readUTF();
                            double tiempoM = archivo.readDouble();
                            return new Cancion(codigo, titulo, letra, tiempoM);
                        }
                    }
                }
            }
            return null;

        } catch (IOException e) {
            return null;
        }
    }
     
   @Override
    public double calcularSalario() {
        
      int numeroDeCanciones = cancionesTop100.size(); 
      double salarioTotal = getSalario();
      if (numeroDeComposiciones > 5) {
           salarioTotal += 
           300;
        }
    if (numeroDeCanciones >= 1 && numeroDeCanciones <= 3) {
            salarioTotal *= 1.1;
        }else if (numeroDeCanciones >= 4 && numeroDeCanciones <= 6) {
            salarioTotal *= 1.2;
        }else if (numeroDeCanciones > 6) {
            salarioTotal *= 1.2;
        
        }
       return salarioTotal;

        }
    
 
    public List<Cantante> list() {
        try {
            archivo.seek(0);
            List<Cantante> lista = new ArrayList<>();
            for (int i = 0; i < this.obtenerTamañoArchivo(); i += 350) {

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
   


            
    @Override
    public String toString() {
        return super.toString()+"\nCompositor{" + "numeroDeComposiciones=" + numeroDeComposiciones + ", cancionesTop100=" + cancionesTop100 + ", clientes=" + clientes + '}';
    }

  
   

}
