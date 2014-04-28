package ve.com.fsjv.devsicodetv;

import java.io.Serializable;
import java.util.Calendar;
import javax.swing.UnsupportedLookAndFeelException;
import org.hibernate.Session;
import ve.com.fsjv.devsicodetv.controllers.MenuDialogManager;
import ve.com.fsjv.devsicodetv.utils.connect.ConexionSicodetUtil;
import ve.com.fsjv.devsicodetv.models.VisitType;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
    {
        Session sesion = ConexionSicodetUtil.getSessionFactory().getCurrentSession();
    }
}
 