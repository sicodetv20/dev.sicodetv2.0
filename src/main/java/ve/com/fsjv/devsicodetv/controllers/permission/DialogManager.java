package ve.com.fsjv.devsicodetv.controllers.permission;

import ve.com.fsjv.devsicodetv.views.PermissionDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private PermissionDialog form;
    public DialogManager(){
        this.form = new PermissionDialog(new JFrame(), true);
        this.form.setTitle("Definición de Permisos");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
