/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo;

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
//constructor con el arreglo de discografia

    public Cantante() {
        this.discografia = new ArrayList<>();
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

    public void agregarDisco(Disco disco) {
        
           discografia.add(disco);
        System.out.println(discografia);
        
    }
    

    
     

   public void actualizarDisco(Disco disco){
       for(int i=0;i<discografia.size();i++){
            Disco discoGuardado =discografia.get(i);
            if(discoGuardado.getCodigo()==(disco.getCodigo())){
                discografia.set(i, discoGuardado);
                break;
            }
        }
   }
    public void eliminarDisco(int codigo){
         for(int i=0;i<discografia.size();i++){
            Disco discoGuardado=discografia.get(i);
            if(discoGuardado.getCodigo()==(codigo)){
                discografia.remove(i);
                break;
            }
        }
    }
    public Disco leerDisco(int codigo){
        for (Disco disco: discografia) {
            if(disco.getCodigo()==(codigo))
                return disco;
            
        }
        return null;
    }
     public List<Disco> listarDisco() {
        return discografia;
    }
    @Override
    public String toString() {
        return super.toString() + "\nCantante{" + "nombreArtistico=" + nombreArtistico + ", generoMusica=" + generoMusica + ", numeroDeSencillos=" + numeroDeSencillos + ", numeroDeConciertos=" + numeroDeConciertos + ", numeroDeGiras=" + numeroDeGiras + ", discografia=" + discografia + '}';
    }

  

}
