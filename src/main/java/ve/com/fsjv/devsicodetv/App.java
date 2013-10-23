package ve.com.fsjv.devsicodetv;

import ve.com.fsjv.devsicodetv.utilitarios.conexion.ConexionSicodet;
import ve.com.fsjv.devsicodetv.utilitarios.conexion.ConexionSeguridad;
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
        Session sesion = ConexionSicodet.getSessionFactory().openSession();
        sesion.beginTransaction();
        
        Session sesion2 = ConexionSeguridad.getSessionFactory().openSession();
        sesion2.beginTransaction();
        System.out.println( "Sesion 1: " + sesion.beginTransaction().toString() + "\nsesion 2: " + sesion2.beginTransaction().toString());
    }
}
