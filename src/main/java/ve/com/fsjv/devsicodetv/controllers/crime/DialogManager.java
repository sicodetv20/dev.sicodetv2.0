package ve.com.fsjv.devsicodetv.controllers.crime;

import ve.com.fsjv.devsicodetv.views.CrimeDialog;
import javax.swing.JFrame;
import javax.swing.JDialog;
/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private CrimeDialog form;
    public DialogManager(){
        this.form = new CrimeDialog(new JFrame(), true);
        this.form.setTitle("Tipos de Delitos");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
