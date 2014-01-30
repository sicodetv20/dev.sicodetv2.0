/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv;

import ve.com.fsjv.devsicodetv.DAO.FichaDetenidoDAO;
import ve.com.fsjv.devsicodetv.controladores.CapturarFotoManager;
import ve.com.fsjv.devsicodetv.modelos.FichaDetenido;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionCampoVacio;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionComponenteNulo;

/**
 *
 * @author Juan
 */
public class Pruebas {
    public static void main(String args[]) throws Exception{
        FichaDetenidoDAO dao = new FichaDetenidoDAO();
        FichaDetenido detenido = (FichaDetenido) dao.list(FichaDetenido.class, "where idficha_detenido=1").get(0);
        System.out.println(detenido);
        new CapturarFotoManager(detenido);
    }
}
