package ve.com.fsjv.devsicodetv.controllers.user;

import ve.com.fsjv.devsicodetv.views.UserDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class UserDialogManager {
    private UserDialog form;
    public UserDialogManager(){
        this.form = new UserDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.USER_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
