/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ve.com.fsjv.devsicodetv.utilitarios.conexion.ConexionPersonalUtil;

/**
 *
 * @author Juan
 */
public class PersonalDAO implements DAO {

    @Override
    public Serializable findById(String clase, String id) {
        Transaction tx = null;
        Serializable obj;
        Session session = ConexionPersonalUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            obj = (Serializable) session.load(clase, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            ConexionPersonalUtil.closeQuietly(session);
        }
        return obj;

        // return null;
    }

    /*
     * Permite el registro en base de datos de cualquier objeto que sea de tipo
     * Serializable y se encuentre mapeado por Hibernate
     */
    @Override
    public Object insert(Serializable obj) {
        Transaction tx = null;
        Session session = ConexionPersonalUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            ConexionPersonalUtil.closeQuietly(session);
        }
        return obj;
    }

    @Override
    public List<Serializable> list(Class clazz) {
        try {
            Session sesion = ConexionPersonalUtil.getSessionFactory().getCurrentSession();
            sesion.beginTransaction();
            List<Serializable> retorno = sesion.createQuery("from " + clazz.getName()).list();
            sesion.getTransaction().commit();
            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Serializable> list(Class clazz, String whereClause) {
        try {
            Session sesion = ConexionPersonalUtil.getSessionFactory().getCurrentSession();
            sesion.beginTransaction();
            List<Serializable> retorno = sesion.createQuery("from " + clazz.getName() + " as v " + whereClause).list();
            sesion.getTransaction().commit();
            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Serializable load(Object clazz) {
        try {
            Session sesion = ConexionPersonalUtil.getSessionFactory().getCurrentSession();
            sesion.beginTransaction();
            Serializable obj = (Serializable) sesion.createCriteria(clazz.getClass());

            sesion.close();
            return obj;
        } catch (Exception e) {
            System.err.println("Error en la Carga del Objeto " + e);
            return null;
        }
    }

    @Override
    public Object update(Serializable obj) {
        Transaction tx = null;
        Session session = ConexionPersonalUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            ConexionPersonalUtil.closeQuietly(session);
        }
        return obj;
    }

    public Serializable findById(Class clase, Serializable id) {
        Transaction tx = null;
        Serializable obj;
        Session session = ConexionPersonalUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            obj = (Serializable) session.load(clase, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            ConexionPersonalUtil.closeQuietly(session);
        }
        return obj;

        // return null;
    }

    public int count(String clase) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
