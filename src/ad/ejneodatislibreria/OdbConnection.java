/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejneodatislibreria;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 *
 * @author a20armandocb
 */
public class OdbConnection {
    private final static String BASE_DATOS = "Libreria.DB";
    private static ODB odb;
    
    private OdbConnection(){
        
    }

    public static ODB getOdb() {
        if(odb == null){
            odb = ODBFactory.open(BASE_DATOS);
        }
        return odb;
    }
    
    
}
