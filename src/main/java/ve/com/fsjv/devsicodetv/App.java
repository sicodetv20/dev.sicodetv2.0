package ve.com.fsjv.devsicodetv;

import ve.com.fsjv.devsicodetv.utilitarios.conexion.ConexionSicodet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Session sesion = ConexionSicodet.getSessionFactory().getCurrentSession();
        sesion.beginTransaction();
        System.out.println( "Hello World! - " + sesion.beginTransaction().toString() );
    }
}
