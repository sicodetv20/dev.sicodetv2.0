package ve.com.fsjv.devsicodetv.controllers.visit;

import ve.com.fsjv.devsicodetv.views.VisitDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private VisitDialog form;
    public DialogManager(){
        this.form = new VisitDialog(new JFrame(), true);
        this.form.setTitle("Visitas");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
