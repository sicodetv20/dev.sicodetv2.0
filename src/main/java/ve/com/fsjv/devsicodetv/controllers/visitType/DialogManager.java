package ve.com.fsjv.devsicodetv.controllers.visitType;

import ve.com.fsjv.devsicodetv.views.VisitTypeDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private VisitTypeDialog form;
    public DialogManager(){
        this.form = new VisitTypeDialog(new JFrame(), true);
        this.form.setTitle("Tipos de Visitas");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
