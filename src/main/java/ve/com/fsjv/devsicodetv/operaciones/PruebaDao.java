/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.operaciones;

import java.io.Serializable;
import java.util.List;
import ve.com.fsjv.devsicodetv.modelos.Prueba;

/**
 *
 * @author Juan
 */
public class PruebaDao extends OperacionesBDSicodet {
    
    public static void main( String[] args ){
        Prueba pr = new Prueba();
        PruebaDao pruebaDao = new PruebaDao();
        List objetos = pruebaDao.list(Prueba.class,"where id=1");
        for(int i=0; i<objetos.size(); i++){
            Prueba pr1 = (Prueba) objetos.get(i);
            pr1.setDescripcion("nueva");
            pruebaDao.actualizar(pr1);
            System.out.println(pr1.getDescripcion());
        }
        //pruebaDao.agregar(pr);
    }
            
}
