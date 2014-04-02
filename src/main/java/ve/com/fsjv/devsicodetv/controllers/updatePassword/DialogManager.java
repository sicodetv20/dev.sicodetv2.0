package ve.com.fsjv.devsicodetv.controllers.updatePassword;

import ve.com.fsjv.devsicodetv.views.UpdatePasswordDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private UpdatePasswordDialog form;
    public DialogManager(){
        this.form = new UpdatePasswordDialog(new JFrame(), true);
        this.form.setTitle("Actualizar Contraseña");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
