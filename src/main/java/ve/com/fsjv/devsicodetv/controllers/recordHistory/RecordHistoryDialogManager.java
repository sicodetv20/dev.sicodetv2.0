package ve.com.fsjv.devsicodetv.controllers.recordHistory;

import ve.com.fsjv.devsicodetv.views.RecordHistoryDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class RecordHistoryDialogManager {
    private RecordHistoryDialog form;
    public RecordHistoryDialogManager(){
        this.form = new RecordHistoryDialog(new JFrame(), true);
        this.form.setTitle("Historial del Detenido");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
