package ve.com.fsjv.devsicodetv.controllers.role;

import ve.com.fsjv.devsicodetv.views.RoleDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private RoleDialog form;
    public DialogManager(){
        this.form = new RoleDialog(new JFrame(), true);
        this.form.setTitle("Rol de Usuario");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
