/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejneodatislibreria.pojos;

import java.util.ArrayList;

/**
 *
 * @author a20armandocb
 */
public class Autor {
    private String dni;
    private String nombre;
    private String direccion;
    private int edad;
    private String nacionalidad;
    public static final String NACIONALIDAD_ESP = "ESPAÑOLA";
    public static final String NACIONALIDAD_IT = "ITALIANA";
    public static final String NACIONALIDAD_FR = "FRANCESA";
    private ArrayList<Libro> libros;

    public Autor(String dni, String nombre, String direccion, int edad, String nacionalidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.libros = new ArrayList<Libro>();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }
    
    public void addLibro(Libro libro) {
        if(!libros.contains(libro)){
            this.libros.add(libro);            
        }
    }

    @Override
    public String toString() {
        return "Autor{" + "dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + ", edad=" + edad + ", nacionalidad=" + nacionalidad + ", libros=" + libros + '}';
    }
    
}
