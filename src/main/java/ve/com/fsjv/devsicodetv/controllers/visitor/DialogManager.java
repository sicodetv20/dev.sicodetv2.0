package ve.com.fsjv.devsicodetv.controllers.visitor;

import ve.com.fsjv.devsicodetv.views.VisitorDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private VisitorDialog form;
    public DialogManager(){
        this.form = new VisitorDialog(new JFrame(), true);
        this.form.setTitle("Visitante");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
