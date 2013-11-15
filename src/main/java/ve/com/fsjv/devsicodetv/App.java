package ve.com.fsjv.devsicodetv;

import javax.swing.UnsupportedLookAndFeelException;
import ve.com.fsjv.devsicodetv.utilitarios.otros.Procesos;
//import ve.com.fsjv.devsicodetv.utilitarios.otros.ConstantesApp;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import ve.com.fsjv.devsicodetv.utilitarios.conexion.ConexionSicodetUtil;
import ve.com.fsjv.devsicodetv.utilitarios.conexion.ConexionSeguridadUtil;
import ve.com.fsjv.devsicodetv.utilitarios.conexion.ConexionPersonalUtil;
import ve.com.fsjv.devsicodetv.controladores.MenuDialogManager;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
    {
        /*
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }*/
        
         Session sesion = ConexionSicodetUtil.getSessionFactory().openSession();
         try{
             sesion.getTransaction().begin();
             System.out.println("Session: " + sesion.getTransaction().toString());
         }catch(HibernateException excep){
             System.err.println("Exception: " + excep);
         }
         /*
         Session sesion2 = ConexionSeguridadUtil.getSessionFactory().openSession();
         try{
             sesion2.getTransaction().begin();
             System.out.println("Session: " + sesion2.getTransaction().toString());
         }catch(HibernateException excep){
             System.err.println("Exception: " + excep);
         }
         
         Session sesion3 = ConexionPersonalUtil.getSessionFactory().openSession();
         try{
             sesion3.getTransaction().begin();
             System.out.println("Session: " + sesion3.getTransaction().toString());
         }catch(HibernateException excep){
             System.err.println("Exception: " + excep);
         }
         */
         MenuDialogManager app = new MenuDialogManager();
    }
}
