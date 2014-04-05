package ve.com.fsjv.devsicodetv.controllers.role;

import ve.com.fsjv.devsicodetv.views.RoleDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class RoleDialogManager {
    private RoleDialog form;
    public RoleDialogManager(){
        this.form = new RoleDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.ROLE_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
