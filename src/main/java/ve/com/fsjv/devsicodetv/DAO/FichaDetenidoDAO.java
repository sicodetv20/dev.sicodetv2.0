/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.DAO;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import ve.com.fsjv.devsicodetv.utilitarios.conexion.ConexionSicodetUtil;
/**
 *
 * @author FAMILIA-SJ
 */
public class FichaDetenidoDAO extends SicodetDAO {
    
    public List<Serializable> buscarPorJoinPersona(Class clase, String condicion){
        try {
            Session sesion = ConexionSicodetUtil.getSessionFactory().getCurrentSession();
            sesion.beginTransaction();
            List<Serializable> retorno = sesion.createQuery("from " + clase.getName() + " v join v.persona p "+condicion).list();
            sesion.getTransaction().commit();
            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
