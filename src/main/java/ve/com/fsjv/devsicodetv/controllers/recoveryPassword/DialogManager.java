package ve.com.fsjv.devsicodetv.controllers.recoveryPassword;

import ve.com.fsjv.devsicodetv.views.RecoveryPasswordDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private RecoveryPasswordDialog form;
    public DialogManager(){
        this.form = new RecoveryPasswordDialog(new JFrame(), true);
        this.form.setTitle("Recuperar Contraseña");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
