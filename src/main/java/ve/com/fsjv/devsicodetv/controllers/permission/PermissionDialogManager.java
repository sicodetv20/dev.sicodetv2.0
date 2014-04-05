package ve.com.fsjv.devsicodetv.controllers.permission;

import ve.com.fsjv.devsicodetv.views.PermissionDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class PermissionDialogManager {
    private PermissionDialog form;
    public PermissionDialogManager(){
        this.form = new PermissionDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.PERMISSION_TYPE_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
