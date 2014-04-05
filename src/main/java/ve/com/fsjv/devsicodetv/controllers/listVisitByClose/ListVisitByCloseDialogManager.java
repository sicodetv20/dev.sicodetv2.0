package ve.com.fsjv.devsicodetv.controllers.listVisitByClose;

import ve.com.fsjv.devsicodetv.views.ListVisitByCloseDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class ListVisitByCloseDialogManager {
    private ListVisitByCloseDialog form;
    public ListVisitByCloseDialogManager(){
        this.form = new ListVisitByCloseDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.VISIT_BY_CLOSE_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
