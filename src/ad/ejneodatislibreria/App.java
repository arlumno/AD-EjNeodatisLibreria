/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad.ejneodatislibreria;

import menu.Menu;
import utilidades.Log;

/**
 *
 * @author a20armandocb
 */
public class App {

    
    /**
     * @param args the command line arguments
     */
    static private Log log = Log.getInstance();

    public static void main(String[] args) {
        boolean continuar = true;
        Menu menu = construirMenuPrincipal();
        
        do {
            try {
                continuar = menuAcciones(menu);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } while (continuar);
        System.exit(0);
    }

    private static Menu construirMenuPrincipal() {
        Menu menu = new Menu();
        AccionesApp app = new AccionesApp();


        
        menu.setTituloMenu("Menu Neodatis Librería");
        menu.setTextoSalir("Salir");
        log.addToLog("Iniciado el programa");

        menu.addOpcion("TEST", () -> {
            app.test();
        });
        //menu.addLabel("Altas");
        menu.addOpcion("Alta Autor", () -> {
            app.altaAutor();
        });
        menu.addOpcion("Añadir Libro", () -> {
            app.addLibroToAutor();
        });
                
        menu.addLabel("Modificaciones");
        menu.addOpcion("Dirección Autor", () -> {
            app.modDirAutor();
        });
        menu.addOpcion("Precio Libro", () -> {
            app.modPrecioLibro();
        });

        
        menu.addLabel("Borrar");
        menu.addOpcion("Borrar Libro", () -> {
            app.delLibro();
        });
        
        menu.addLabel("Consultas");
        menu.addOpcion("Listado Autores Italianos", () -> {
            app.listarAutoresItalianos();
        });
        menu.addOpcion("Listado libros entre fechas", () -> {
            app.listarLibrosFiltroFechas();
        });        
        menu.addOpcion("Listado Autores Españoles mayores de 60 años", () -> {
            app.listarAutoresEspanolesMayores60();
        });
        
        menu.addOpcion("Listado Autores por Nacionalidad", () -> {
            app.listarNumeroAutoresPorNacionalidad();
        });        
        
        menu.addOpcion("Listado Libros del Autor", () -> {
            app.listarLibrosAutor();
        });        
        
        menu.addOpcion("Datos Libro", () -> {
            app.listarDatosLibro();
        });    
        
        menu.addOpcion("Lista Autores y Libros", () -> {
            app.listarAutoresYLibros();
        });
        
        /* Log de libreriaAr 1.4 */
        menu.addLabel("LOG");
        menu.addOpcion("Ver Log", () -> {
            peticiones.SalidasGui.bloqueTexto("Log", utilidades.Log.getInstance().getLog());
        });
        menu.addOpcion("Borrar Log", () -> {
            utilidades.Log.getInstance().borrarLog();
        });
        

        return menu;
    }

    private static boolean menuAcciones(Menu menu) throws Exception {
        boolean continuar = true;
        menu.mostrarGUI();
        //menu.mostrar();
        switch (menu.getSeleccion()) {
            case 0:
                //salir
                continuar = false;
                log.addToLog("finalizado el programa");
                System.out.println("Bye Bye!");
                break;
            //deprecated, ahora se asigna directamente la funcion al añadir el boton
//            case 1:
//                System.out.println(EntradasGui.pedirFecha("mensaje").toString());
//                break;

        }
        return continuar;
    }

}
