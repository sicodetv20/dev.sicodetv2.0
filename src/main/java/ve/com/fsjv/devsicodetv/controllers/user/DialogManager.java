package ve.com.fsjv.devsicodetv.controllers.user;

import ve.com.fsjv.devsicodetv.views.UserDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private UserDialog form;
    public DialogManager(){
        this.form = new UserDialog(new JFrame(), true);
        this.form.setTitle("Usuarios");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
