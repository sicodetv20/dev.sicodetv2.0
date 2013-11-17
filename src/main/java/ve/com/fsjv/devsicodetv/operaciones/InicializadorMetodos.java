/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.operaciones;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface InicializadorMetodos {

    public List<Serializable> listar(Class clase);

    public Serializable cargar(Object args);

    public Object agregar(Serializable obj);

    public Object actualizar(Serializable obj);

    public Serializable consultarId(String clase, String id);
}
