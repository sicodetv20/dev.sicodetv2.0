package ve.com.fsjv.devsicodetv.DAO;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author TecnoSoluciones-NS
 */
public interface DAO {

    public List<Serializable> list(Class clase);

    public Serializable load(Object args);

    public Object insert(Serializable obj);

    public Object update(Serializable obj);

    public Serializable findById(String clase, String id);
    
}
