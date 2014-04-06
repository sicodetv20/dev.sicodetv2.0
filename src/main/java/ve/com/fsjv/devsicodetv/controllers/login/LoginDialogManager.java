package ve.com.fsjv.devsicodetv.controllers.login;

import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.views.LoginDialog;
import ve.com.fsjv.devsicodetv.utils.others.ConstantsApp;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class LoginDialogManager {
    private LoginDialog form;
    public LoginDialogManager(){
        this.form = new LoginDialog();
    }
    public int login(){
        return ConstantsApp.USER_LOGGED;
    }
    
    public void initForm(){
        this.form.setTitle(TitleApp.LOGIN_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.form.setVisible(true);
    }
            
}
