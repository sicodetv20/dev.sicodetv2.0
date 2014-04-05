package ve.com.fsjv.devsicodetv.controllers.updatePassword;

import ve.com.fsjv.devsicodetv.views.UpdatePasswordDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class UpdatePasswordDialogManager {
    private UpdatePasswordDialog form;
    public UpdatePasswordDialogManager(){
        this.form = new UpdatePasswordDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.UPDATE_PASSWORD_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
