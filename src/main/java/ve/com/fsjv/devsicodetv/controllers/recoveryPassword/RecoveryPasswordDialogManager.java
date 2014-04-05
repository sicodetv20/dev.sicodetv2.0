package ve.com.fsjv.devsicodetv.controllers.recoveryPassword;

import ve.com.fsjv.devsicodetv.views.RecoveryPasswordDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class RecoveryPasswordDialogManager {
    private RecoveryPasswordDialog form;
    public RecoveryPasswordDialogManager(){
        this.form = new RecoveryPasswordDialog(new JFrame(), true);
        this.form.setTitle("Recuperar Contraseña");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
