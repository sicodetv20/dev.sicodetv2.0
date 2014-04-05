package ve.com.fsjv.devsicodetv.controllers.login;

import ve.com.fsjv.devsicodetv.views.LoginDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class LoginDialogManager {
    private LoginDialog form;
    public LoginDialogManager(){
        this.form = new LoginDialog(new JFrame(), true);
        this.form.setTitle("Inicio de Sesion");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
