/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejneodatislibreria;

import ad.ejneodatislibreria.pojos.Autor;
import ad.ejneodatislibreria.pojos.Libro;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

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

    void runStopServer() {
        StringBuilder anuncio = new StringBuilder();
        if (OdbServer.isRun()) {
            anuncio.append("Apagando servidor...\n");
            if (OdbServer.stop()) {
                anuncio.append("--- Servidor apagado con éxito ---");
            } else {
                anuncio.append("--- Error al apagar el servidor ---");
            }
        } else {
            anuncio.append("Iniciando servidor...\n");
            if (OdbServer.run()) {
                anuncio.append("--- Servidor iniciado con éxito ---");
            } else {
                anuncio.append("--- Error al iniciar el servidor ---");
            }
        }
        peticiones.SalidasGui.mensaje(anuncio.toString());

    }

    void altaAutor() {
        try {
            Libro lib1 = new Libro(1, "Historias para no dormir", "Drama", 20.95F, dateFormat.parse("13/04/2019"));
            Autor a1 = new Autor("53170624Y", "Armando", "un lugar tranquilo 123", 38, Autor.NACIONALIDAD_ESP);
            Libro lib6 = new Libro(9, "Historias para seguir sin dormir", "Drama", 23.95F, dateFormat.parse("13/04/2020"));
            a1.addLibro(lib1);
            a1.addLibro(lib6);

            Libro lib2 = new Libro(002, "Mancato", "Western", 12.95F, dateFormat.parse("04/11/2020"));
            Autor a2 = new Autor("12345678Z", "Mario Luciano", "papidipupi 33", 58, Autor.NACIONALIDAD_IT);
            a2.addLibro(lib2);

            Libro lib3 = new Libro(4, "PewPew", "Comedia", 13.45F, dateFormat.parse("09/05/2021"));
            Autor a3 = new Autor("87654321Z", "Alberti D'niente", "maquefa 73", 65, Autor.NACIONALIDAD_IT);
            a3.addLibro(lib3);

            Libro lib4 = new Libro(5, "Cosas", "Costumbrista", 61.15F, dateFormat.parse("22/10/2020"));
            Autor a4 = new Autor("11223344J", "Marisa Mars", "congoja  66", 65, Autor.NACIONALIDAD_ESP);
            a4.addLibro(lib4);

            Libro lib5 = new Libro(6, "Mondie", "Costumbrista", 21.15F, dateFormat.parse("29/10/2019"));
            Autor a5 = new Autor("44332211F", "Fransua Piaf", "parisie 33", 25, Autor.NACIONALIDAD_FR);
            a5.addLibro(lib5);

            if (obtenerDniAutor(a1) == null) {

                OdbConnection.getOdb().store(a1);
                peticiones.SalidasGui.mensaje("Guardado Autor: \n" + a1.toString());

            }

            if (obtenerDniAutor(a2) == null) {
                OdbConnection.getOdb().store(a2);
                peticiones.SalidasGui.mensaje("Guardado Autor: \n" + a2.toString());
            }

            if (obtenerDniAutor(a3) == null) {
                OdbConnection.getOdb().store(a3);
                peticiones.SalidasGui.mensaje("Guardado Autor: \n" + a3.toString());
            }

            if (obtenerDniAutor(a4) == null) {
                OdbConnection.getOdb().store(a4);
                peticiones.SalidasGui.mensaje("Guardado Autor: \n" + a4.toString());
            }
            if (obtenerDniAutor(a5) == null) {
                OdbConnection.getOdb().store(a5);
                peticiones.SalidasGui.mensaje("Guardado Autor: \n" + a5.toString());
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
                String nuevaDireccion = "el nuevo sitio " + ((int) (Math.random() * 1000));
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
        String nombreAutor = "Mario Luciano";
        String tituloLibro = "Mancato";
        float precioAnterior = 0;
        float precioNuevo = (float) ((int) (Math.random() * 10000)) / 100;
        Autor autor = null;
        try {
            ICriterion filtro = Where.equal("nombre", nombreAutor);
            IQuery query = new CriteriaQuery(Autor.class, filtro);
            autor = (Autor) OdbConnection.getOdb().getObjects(query).getFirst();
        } catch (IndexOutOfBoundsException ex) {
            peticiones.SalidasGui.mensaje("El autor indicado no existe.");
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
        if (autor != null) {
            ArrayList<Libro> libros = autor.getLibros();
            boolean encontrado = false;
            for (Libro libro : libros) {
                if (libro.getTitulo().equals(tituloLibro)) {
                    precioAnterior = libro.getPrecio();
                    libro.setPrecio(precioNuevo);
                    encontrado = true;
                }
            }
            if (encontrado) {
                try {
                    OdbConnection.getOdb().store(autor);
                    peticiones.SalidasGui.mensaje("Actualizado el precio del libro: " + tituloLibro + "\nde " + precioAnterior + " a " + precioNuevo);
                } catch (Exception ex) {
                    peticiones.SalidasGui.mensaje(ex.toString());
                }

            } else {
                peticiones.SalidasGui.mensaje("No se ha encontrado el libro en el autor: " + autor.getNombre());
            }

            try {
                OdbConnection.getOdb().close();
            } catch (Exception ex) {
                peticiones.SalidasGui.mensaje(ex.toString());
            }
        }
    }

    void delLibro() {
        String nombreAutor = "Armando";
        int codLibro = 003;
        Autor autor = null;
        try {
            ICriterion filtro = Where.equal("nombre", nombreAutor);
            IQuery query = new CriteriaQuery(Autor.class, filtro);
            autor = (Autor) OdbConnection.getOdb().getObjects(query).getFirst();
        } catch (IndexOutOfBoundsException ex) {
            peticiones.SalidasGui.mensaje("El autor indicado no existe.");
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
        if (autor != null) {
            ArrayList<Libro> libros = autor.getLibros();
            Libro libroEliminar = null;
            for (Libro libro : libros) {
                if (libro.getCod() == codLibro) {
                    libroEliminar = libro;
                }
            }
            if (libroEliminar != null) {
                try {
                    OdbConnection.getOdb().delete(libroEliminar);
                    peticiones.SalidasGui.mensaje("Se ha eliminado el libro: " + libroEliminar.getTitulo() + "\ndel autor:  " + autor.getNombre());
                } catch (Exception ex) {
                    peticiones.SalidasGui.mensaje(ex.toString());
                }

            } else {
                peticiones.SalidasGui.mensaje("No se ha encontrado el libro en el autor: " + autor.getNombre());
            }

            try {
                OdbConnection.getOdb().close();
            } catch (Exception ex) {
                peticiones.SalidasGui.mensaje(ex.toString());
            }
        }
    }

    void listarAutoresItalianos() {
        StringBuilder resultado = new StringBuilder();
        try {
            ICriterion filtro = Where.equal("nacionalidad", Autor.NACIONALIDAD_IT);
            IQuery query = new CriteriaQuery(Autor.class, filtro);
            Object[] autoresObj = OdbConnection.getOdb().getObjects(query).toArray();
            resultado.append("Autores (" + autoresObj.length + "):\n");
            for (Object autorObj : autoresObj) {
                resultado.append(" >> " + ((Autor) autorObj).toString() + "\n");
            }
            peticiones.SalidasGui.mensaje(resultado.toString());
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
        try {
            OdbConnection.getOdb().close();
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
    }

    void listarLibrosFiltroFechas() {
        try {
            String dni = "53170624Y";
            Date fechaInicio = dateFormat.parse("01/09/2019");
            Date fechafin = dateFormat.parse("21/12/2022");
            Date fechaLibro;
            Autor autor = obtenerAutor(dni);
            if (autor != null) {
                StringBuilder resultado = new StringBuilder();
                resultado.append("Libros para el Autor: " + autor.getNombre() + "\n");
                for (Libro libro : autor.getLibros()) {
                    fechaLibro = libro.getFechaPublicacion();
                    if (fechaLibro.after(fechaInicio) && fechaLibro.before(fechafin)) {
                        resultado.append("   >>> " + libro.toString() + "\n");
                    }
                }
                peticiones.SalidasGui.mensaje(resultado.toString());
            }
        } catch (ParseException ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
    }

    void listarAutoresEspanolesMayores60() {
        StringBuilder resultado = new StringBuilder();
        Autor autor;
        StringBuilder libros = new StringBuilder();
        try {
            ICriterion filtro = new And()
                    .add(Where.equal("nacionalidad", Autor.NACIONALIDAD_ESP))
                    .add(Where.gt("edad", 60));

            IQuery query = new CriteriaQuery(Autor.class, filtro);
            Object[] autoresObj = OdbConnection.getOdb().getObjects(query).toArray();
            resultado.append("Autores (" + autoresObj.length + "):\n");
            resultado.append("Nombre                Edad                Libros\n");
            resultado.append("------                ----                ------\n");
            for (Object autorObj : autoresObj) {
                autor = (Autor) autorObj;
                for (Libro libro : autor.getLibros()) {
                    libros.append(libro.getTitulo() + ", ");
                }
                resultado.append(autor.getNombre() + "                " + autor.getEdad() + "                " + libros.toString() + "\n");
            }
            peticiones.SalidasGui.mensaje(resultado.toString());
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
        try {
            OdbConnection.getOdb().close();
        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
    }

    void listarNumeroAutoresPorNacionalidad() {
        try {
            StringBuilder resultado = new StringBuilder();
            Values groupby = OdbConnection.getOdb().getValues(new ValuesCriteriaQuery(Autor.class).field("nacionalidad").count("dni").groupBy("nacionalidad"));

            while (groupby.hasNext()) {
                ObjectValues objetos = (ObjectValues) groupby.next();
                resultado.append(objetos.getByAlias("nacionalidad") + ": " + objetos.getByIndex(1) + "\n");
            }
            //para comparar hago un listado:

            IQuery query = new CriteriaQuery(Autor.class).orderByAsc("nacionalidad");
            Object[] autoresObj = OdbConnection.getOdb().getObjects(query).toArray();

            resultado.append("Autores (" + autoresObj.length + "):\n");
            for (Object autorObj : autoresObj) {
                resultado.append(" >> " + ((Autor) autorObj).toString() + "\n");
            }
            peticiones.SalidasGui.mensaje(resultado.toString());

        } catch (Exception ex) {
            peticiones.SalidasGui.mensaje(ex.toString());
        }
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
