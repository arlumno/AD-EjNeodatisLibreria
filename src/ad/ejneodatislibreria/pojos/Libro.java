/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejneodatislibreria.pojos;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author a20armandocb
 */
public class Libro {
    private int cod;
    private String titulo;
    private String categoria;
    private float precio;
    private Date fechaPublicacion;

    public Libro(int cod, String titulo, String categoria, float precio, Date fechaPublicacion) {
        this.cod = cod;
        this.titulo = titulo;
        this.categoria = categoria;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString() {
        return "Libro{" + "cod=" + cod + ", titulo=" + titulo + ", categoria=" + categoria + ", precio=" + precio + ", fechaPublicacion=" + fechaPublicacion + '}';
    }
    
}
