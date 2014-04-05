package ve.com.fsjv.devsicodetv.controllers.record;

import javax.swing.JDialog;
import javax.swing.JFrame;

import ve.com.fsjv.devsicodetv.views.RecordDialog;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;


/**
 *
 * @author TecnoSoluciones-NS
 */
public class RecordDialogManager {
    private RecordDialog form;
    public RecordDialogManager(){
        this.form = new RecordDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.RECORD_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
