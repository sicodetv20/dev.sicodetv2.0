package ve.com.fsjv.devsicodetv.controllers.findRecord;

import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;
import ve.com.fsjv.devsicodetv.views.SimpleSearchRecordDialog;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class SimpleSearchRecordDialogManager {
    private SimpleSearchRecordDialog form;
    public SimpleSearchRecordDialogManager(){
        this.form = new SimpleSearchRecordDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.SIMPLE_SEARCH_RECORD_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
