package ve.com.fsjv.devsicodetv.controllers.listVisitByClose;

import ve.com.fsjv.devsicodetv.views.ListVisitByCloseDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private ListVisitByCloseDialog form;
    public DialogManager(){
        this.form = new ListVisitByCloseDialog(new JFrame(), true);
        this.form.setTitle("Visitas Por Finalizar");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
