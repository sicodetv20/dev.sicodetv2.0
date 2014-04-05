package ve.com.fsjv.devsicodetv.controllers.crime;

import ve.com.fsjv.devsicodetv.views.CrimeDialog;
import javax.swing.JFrame;
import javax.swing.JDialog;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;
/**
 *
 * @author TecnoSoluciones-NS
 */
public class CrimeDialogManager {
    private CrimeDialog form;
    public CrimeDialogManager(){
        this.form = new CrimeDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.CRIME_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
