/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.operaciones;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ve.com.fsjv.devsicodetv.utilitarios.conexion.ConexionSicodetUtil;

/**
 *
 * @author Juan
 */
public class OperacionesBDSicodet implements InicializadorMetodos {

    @Override
    public Serializable consultarId(String clase, String id) {
        Transaction tx = null;
        Serializable obj;
        Session session = ConexionSicodetUtil.getSessionFactory().getCurrentSession();
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
            ConexionSicodetUtil.closeQuietly(session);
        }
        return obj;
    }

    /*
     * Permite el registro en base de datos de cualquier objeto que sea de tipo
     * Serializable y se encuentre mapeado por Hibernate
     */
    @Override
    public Object agregar(Serializable obj) {
        Transaction tx = null;
        Session session = ConexionSicodetUtil.getSessionFactory().getCurrentSession();
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
            ConexionSicodetUtil.closeQuietly(session);
        }
        return obj;
    }

    @Override
    public List<Serializable> listar(Class clase) {
        try {
            Session sesion = ConexionSicodetUtil.getSessionFactory().getCurrentSession();
            sesion.beginTransaction();
            List<Serializable> retorno = sesion.createQuery("from " + clase.getName()).list();
            sesion.getTransaction().commit();
            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Serializable> list(Class clase, String condicion) {
        try {
            Session sesion = ConexionSicodetUtil.getSessionFactory().getCurrentSession();
            sesion.beginTransaction();
            List<Serializable> retorno = sesion.createQuery("from " + clase.getName() + " as v " + condicion).list();
            sesion.getTransaction().commit();
            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Serializable cargar(Object clase) {
        try {
            Session sesion = ConexionSicodetUtil.getSessionFactory().getCurrentSession();
            sesion.beginTransaction();
            Serializable obj = (Serializable) sesion.createCriteria(clase.getClass());

            sesion.close();
            return obj;
        } catch (Exception e) {
            System.err.println("Error en la Carga del Objeto " + e);
            return null;
        }
    }

    @Override
    public Object actualizar(Serializable obj) {
        Transaction tx = null;
        Session session = ConexionSicodetUtil.getSessionFactory().getCurrentSession();
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
            ConexionSicodetUtil.closeQuietly(session);
        }
        return obj;
    }

    public Serializable findById(Class clase, Serializable id) {
        Transaction tx = null;
        Serializable obj;
        Session session = ConexionSicodetUtil.getSessionFactory().getCurrentSession();
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
            ConexionSicodetUtil.closeQuietly(session);
        }
        return obj;

        // return null;
    }
}
