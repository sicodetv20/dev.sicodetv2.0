package ve.com.fsjv.devsicodetv;

import javax.swing.UnsupportedLookAndFeelException;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import ve.com.fsjv.devsicodetv.controllers.menu.MenuDialogManager;

/**
 * Hello world!344
 *
 */
public class tester 
{
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
    {
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
                javax.swing.JDialog.setDefaultLookAndFeelDecorated(true);
                SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.BusinessBlackSteelSkin");
                MenuDialogManager app = new MenuDialogManager();
            }
        });
    }
}
 