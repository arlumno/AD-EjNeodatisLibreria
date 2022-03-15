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

    public static ODB getOdb() throws Exception {
        if(odb == null || odb.isClosed()){
            try{               
                odb = ODBFactory.open(BASE_DATOS);
            }catch(Exception e){
                throw new Exception("Error: La base de datos está siendo usada.");
            }
        }        
        return odb;
    }
    
    
}
