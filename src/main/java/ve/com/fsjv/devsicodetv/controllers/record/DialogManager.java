package ve.com.fsjv.devsicodetv.controllers.record;

import ve.com.fsjv.devsicodetv.views.RecordDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private RecordDialog form;
    public DialogManager(){
        this.form = new RecordDialog(new JFrame(), true);
        this.form.setTitle("Ficha del Detenido");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
