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
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
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

    private int obtenerCodLibro(Libro libro) {
        int resultado = -1;
        try {
            ICriterion filtro = Where.equal("cod", libro.getCod());
            IQuery query = new CriteriaQuery(Libro.class, filtro);
            Libro libBD = (Libro) OdbConnection.getOdb().getObjects(query).getFirst();
            resultado = libBD.getCod();
            //TODO resultado = objeto.
        } catch (IndexOutOfBoundsException ex) {
            //no hay resultados.
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
        return resultado;
    }

    private String obtenerDniAutor(Autor autor) {
        String resultado = null;
        try {
            ICriterion filtro = Where.equal("dni", autor.getDni());
            IQuery query = new CriteriaQuery(Autor.class, filtro);
            Autor autorBD = (Autor) OdbConnection.getOdb().getObjects(query).getFirst();
            resultado = autorBD.getDni();
            //TODO resultado = objeto.
        } catch (IndexOutOfBoundsException ex) {
            //no hay resultados.
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
        return resultado;
    }

    private Libro obtenerLibro(int cod) {
        Libro libro = null;
        try {
            ICriterion filtro = Where.equal("cod", cod);
            IQuery query = new CriteriaQuery(Libro.class, filtro);
            libro = (Libro) OdbConnection.getOdb().getObjects(query).getFirst();
        } catch (IndexOutOfBoundsException ex) {
            peticiones.SalidasGui.mensaje("El libro indicado no existe.");
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
        return libro;
    }

    private Autor obtenerAutor(String dni) {
        Autor autor = null;
        try {
            ICriterion filtro = Where.equal("dni", dni);
            IQuery query = new CriteriaQuery(Autor.class, filtro);
            autor = (Autor) OdbConnection.getOdb().getObjects(query).getFirst();
        } catch (IndexOutOfBoundsException ex) {
            peticiones.SalidasGui.mensaje("El autor indicado no existe.");
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
        return autor;
    }

    void test() {
        Libro lib2;
        try {
            lib2 = new Libro(004, "Mancato", "Western", 12.95F, dateFormat.parse("04/11/2020"));
            String text = Long.toString(obtenerCodLibro(lib2));
            peticiones.SalidasGui.mensaje(text);
        } catch (ParseException ex) {
            Logger.getLogger(AccionesApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void altaAutor() {
        try {
            Libro lib1 = new Libro(001, "Historias para no dormir", "Drama", 20.95F, dateFormat.parse("13/04/2019"));
            Libro lib2 = new Libro(002, "Mancato", "Western", 12.95F, dateFormat.parse("04/11/2020"));

            Autor a1 = new Autor("53170624Y", "Armando", "un lugar tranquilo 123", 38, Autor.NACIONALIDAD_ESP);
            a1.addLibro(lib1);

            Autor a2 = new Autor("12345678Z", "Mario Luciano", "papidipupi 33", 58, Autor.NACIONALIDAD_IT);
            a2.addLibro(lib2);

            if (obtenerDniAutor(a1) == null) {

                OdbConnection.getOdb().store(a1);
                peticiones.SalidasGui.mensaje("Guardado Autor: \n" + a1.toString());

            }

            if (obtenerDniAutor(a2) == null) {
                OdbConnection.getOdb().store(a2);
                peticiones.SalidasGui.mensaje("Guardado Autor: \n" + a2.toString());
            }

            OdbConnection.getOdb().close();

        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        } finally {
            try {
                OdbConnection.getOdb().close();
            } catch (Exception ex) {
                peticiones.SalidasGui.mensaje(ex.toString());
            }
        }

    }

    void addLibroToAutor() {
        try {
            String dniAutor = "53170624Y";
            Autor autor = obtenerAutor(dniAutor);
            if (autor != null) {
                Libro libro = new Libro(003, "The Autonomo", "Terror", 36.95F, dateFormat.parse("25/09/2019"));
                int codLibro = obtenerCodLibro(libro);
                if (codLibro == -1) {
                    autor.addLibro(libro);
                } else {
                    autor.addLibro(obtenerLibro(codLibro));
                }
                OdbConnection.getOdb().store(autor);

                //     OdbConnection.getOdb().commit();
                peticiones.SalidasGui.mensaje("Guardado Libro: \n" + libro.toString());
            }

        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        } finally {
            try {
                OdbConnection.getOdb().close();
            } catch (Exception ex) {
                peticiones.SalidasGui.mensaje(ex.toString());
            }
        }

    }

    void modDirAutor() {
        try {
            String dniAutor = "53170624Y";
            Autor autor = obtenerAutor(dniAutor);
            if (autor != null) {
                String viejaDireccion = autor.getDireccion();
                String nuevaDireccion = "el nuevo sitio 321";
//                String nuevaDireccion = "happyland 321";
                autor.setDireccion(nuevaDireccion);

                OdbConnection.getOdb().store(autor);
                peticiones.SalidasGui.mensaje("Actualizada la dirección de " + autor.getNombre() + "\n  " + viejaDireccion + " -> " + autor.getDireccion() + "\n Autor: \n " + autor.toString());
            }

        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        } finally {
            try {
                OdbConnection.getOdb().close();
            } catch (Exception ex) {
                peticiones.SalidasGui.mensaje(ex.toString());
            }
        }

    }

    void modPrecioLibro() {
        try {
            String nombreAutor = "53170624Y";
            String tituloLibro = "53170624Y";

            ICriterion filtro = new And()
                                        .add(Where.equal("titulo", tituloLibro))
                                        .add(Where.equal("autor.nombrePais", "España")
                                            
            );
            IQuery query = new CriteriaQuery(Libro.class, filtro);
            Libro libro = (Libro) OdbConnection.getOdb().getObjects(query).getFirst();

            if (autor != null) {
                String viejaDireccion = autor.getDireccion();
                String nuevaDireccion = "el nuevo sitio 321";
//                String nuevaDireccion = "happyland 321";
                autor.setDireccion(nuevaDireccion);

                OdbConnection.getOdb().store(autor);
                peticiones.SalidasGui.mensaje("Actualizada la dirección de " + autor.getNombre() + "\n  " + viejaDireccion + " -> " + autor.getDireccion() + "\n Autor: \n " + autor.toString());
            }
        } catch (IndexOutOfBoundsException ex) {
            peticiones.SalidasGui.mensaje("El libro indicado no existe.");
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        } finally {
            try {
                OdbConnection.getOdb().close();
            } catch (Exception ex) {
                peticiones.SalidasGui.mensaje(ex.toString());
            }
        }
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
        String dni = "53170624Y";
        Autor autor = obtenerAutor(dni);
        if (autor != null) {
            StringBuilder resultado = new StringBuilder();
            resultado.append("Libros para el Autor: " + autor.getNombre() + ", Total:  " + autor.getLibros().size() + "\n");
            for (Libro libro : autor.getLibros()) {
                resultado.append("   >>> " + libro.toString() + "\n");
            }
            peticiones.SalidasGui.mensaje(resultado.toString());
        }

    }

    void listarDatosLibro() {
        int cod = 3;
        Libro libro = obtenerLibro(cod);
        if (libro != null) {
            StringBuilder resultado = new StringBuilder();
            resultado.append("Datos libro:\n" + libro.toString());
            peticiones.SalidasGui.mensaje(resultado.toString());
        }
    }

    void listarAutoresYLibros() {
        try {
            StringBuilder resultado = new StringBuilder();

            Object[] autoresObj = OdbConnection.getOdb().getObjects(Autor.class).toArray();
            resultado.append("Autores (" + autoresObj.length + "):\n");
            for (Object autorObj : autoresObj) {
                resultado.append(" >> " + ((Autor) autorObj).toString() + "\n");
            }

            Object[] librosObj = OdbConnection.getOdb().getObjects(Libro.class).toArray();
            resultado.append(" -------------- ");
            resultado.append("\nLibros (" + librosObj.length + "):\n");
            for (Object libroObj : librosObj) {
                resultado.append(" >> " + ((Libro) libroObj).toString() + "\n");
            }

            peticiones.SalidasGui.mensaje(resultado.toString());
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }

    }

}
