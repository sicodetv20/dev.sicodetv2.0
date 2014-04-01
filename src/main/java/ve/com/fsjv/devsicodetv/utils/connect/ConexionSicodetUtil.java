/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.utils.connect;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author franklin
 */
public class ConexionSicodetUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            sessionFactory = new Configuration().configure("ConexionSicodet.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void closeQuietly(Session session) {
        try {
            if (session != null) {
                session.close();
            }
        } catch (Exception e) {
            // eat -it up
        }
    }
}
