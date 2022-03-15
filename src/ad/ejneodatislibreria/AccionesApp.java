/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejneodatislibreria;

import ad.ejneodatislibreria.pojos.Autor;
import ad.ejneodatislibreria.pojos.Libro;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a20armandocb
 */
class AccionesApp {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public AccionesApp() {

    }

    void altaAutor() {
        try {
//            Libro lib1 = new Libro(001, "Historias para no dormir", "Drama", 20.95F, dateFormat.parse("13/04/2019"));
//            Libro lib2 = new Libro(002, "Mancato", "Western", 20.95F, dateFormat.parse("04/11/2020"));
//
//            Autor a1 = new Autor("53170624Y", "Armando", "un lugar tranquilo 123", 38, Autor.NACIONALIDAD_ESP);
//            a1.addLibro(lib1);
//
//            Autor a2 = new Autor("12345678Z", "Mario Luciano", "papidipupi 33", 58, Autor.NACIONALIDAD_IT);
//            a2.addLibro(lib2);
//
//            OdbConnection.getOdb().store(a1);
//            peticiones.SalidasGui.mensaje("Guardado Autor: \n" + a1.toString());
//            OdbConnection.getOdb().store(a2);
//            peticiones.SalidasGui.mensaje("Guardado Autor: \n" + a2.toString());
//            
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }

    void addLibroToAutor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void modDirAutor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void modPrecioLibro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void delLibro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void listarAutoresItalianos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void listarLibrosFiltroFechas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void listarAutoresEspanolesMayores60() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void listarAutoresPorNacionalidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void listarLibrosAutor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void listarDatosLibro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
