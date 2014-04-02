package ve.com.fsjv.devsicodetv.controllers.findRecord;

import ve.com.fsjv.devsicodetv.views.FindRecordDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private FindRecordDialog form;
    public DialogManager(){
        this.form = new FindRecordDialog(new JFrame(), true);
        this.form.setTitle("Buscar Detenido");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
