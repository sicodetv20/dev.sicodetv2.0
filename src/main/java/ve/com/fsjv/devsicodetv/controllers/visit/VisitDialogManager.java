package ve.com.fsjv.devsicodetv.controllers.visit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;
import ve.com.fsjv.devsicodetv.views.VisitDialog;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class VisitDialogManager {
    private VisitDialog form;
    public VisitDialogManager(){
        this.form = new VisitDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.VISIT_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
