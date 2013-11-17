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

    public List<Serializable> list(Class clazz);

    public Serializable load(Object args);

    public Object insert(Serializable obj);

    public Object update(Serializable obj);

    public Serializable findById(String clase, String id);
}
