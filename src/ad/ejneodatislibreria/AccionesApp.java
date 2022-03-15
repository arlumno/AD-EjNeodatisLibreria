/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejneodatislibreria;

import ad.ejneodatislibreria.pojos.Autor;
import ad.ejneodatislibreria.pojos.Libro;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author a20armandocb
 */
class AccionesApp {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public AccionesApp() {

    }

    private long obtenerIdLibro(Libro libro) {
        long resultado = -1;
        try {
            ICriterion filtro = Where.equal("cod", libro.getCod());
            IQuery query = new CriteriaQuery(Libro.class, filtro);
            Object objeto = OdbConnection.getOdb().getObjects(query).getFirst();
            //TODO resultado = objeto.
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
        return resultado;
    }

    void altaAutor() {
        try {
            Libro lib1 = new Libro(001, "Historias para no dormir", "Drama", 20.95F, dateFormat.parse("13/04/2019"));
            Libro lib2 = new Libro(002, "Mancato", "Western", 12.95F, dateFormat.parse("04/11/2020"));

            Autor a1 = new Autor("53170624Y", "Armando", "un lugar tranquilo 123", 38, Autor.NACIONALIDAD_ESP);
            a1.addLibro(lib1);

            Autor a2 = new Autor("12345678Z", "Mario Luciano", "papidipupi 33", 58, Autor.NACIONALIDAD_IT);
            a2.addLibro(lib2);

            OdbConnection.getOdb().store(a1);
            peticiones.SalidasGui.mensaje("Guardado Autor: \n" + a1.toString());
            OdbConnection.getOdb().store(a2);
            peticiones.SalidasGui.mensaje("Guardado Autor: \n" + a2.toString());

            OdbConnection.getOdb().close();

        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }

    }

    void addLibroToAutor() {
        try {
            Libro lib3 = new Libro(003, "The Autonomo", "Terror", 36.95F, dateFormat.parse("25/09/2019"));
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }

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
