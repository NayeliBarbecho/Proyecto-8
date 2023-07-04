/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica03.barbechonayeli.fernandezaroon.modelo;

import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class Disco {
    //atributos
    private int codigo;
    private String nombreDisco;
    private int anioDeLanzamiento;
   
    //Constructor con parametros

    public Disco(int codigo, String nombre, int anioDeLanzamiento) {
        this.codigo = codigo;
        this.nombreDisco = nombre;
        this.anioDeLanzamiento = anioDeLanzamiento;
    }
//getters y setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreDisco() {
        return nombreDisco;
    }

    public void setNombreDisco(String nombreDisco) {
        this.nombreDisco = nombreDisco;
    }

    public int getAnioDeLanzamiento() {
        return anioDeLanzamiento;
    }

    public void setAnioDeLanzamiento(int anioDeLanzamiento) {
        this.anioDeLanzamiento = anioDeLanzamiento;
    }
   
    //Equals y HashCode
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disco other = (Disco) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nombreDisco);
        return hash;
    }
    
   
//To String 
    @Override
    public String toString() {
        return "Disco{" + "codigo=" + codigo + ", nombre=" + nombreDisco+ ", anioDeLanzamiento=" + anioDeLanzamiento + '}';
    }
    
}
