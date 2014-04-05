package ve.com.fsjv.devsicodetv.controllers.visitType;

import ve.com.fsjv.devsicodetv.views.VisitTypeDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class VisitTypeDialogManager {
    private VisitTypeDialog form;
    public VisitTypeDialogManager(){
        this.form = new VisitTypeDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.VISIT_TYPE_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
