package ve.com.fsjv.devsicodetv.controllers.cause;

import ve.com.fsjv.devsicodetv.views.CauseDialog;
import javax.swing.JFrame;
import javax.swing.JDialog;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class CauseDialogManager {
    private CauseDialog form;
    public CauseDialogManager(){
        this.form = new CauseDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.CAUSE_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
