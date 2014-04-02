package ve.com.fsjv.devsicodetv.controllers.cause;

import ve.com.fsjv.devsicodetv.views.CauseDialog;
import javax.swing.JFrame;
import javax.swing.JDialog;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private CauseDialog form;
    public DialogManager(){
        this.form = new CauseDialog(new JFrame(), true);
        this.form.setTitle("Causa de Detencion");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
