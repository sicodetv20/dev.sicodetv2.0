package ve.com.fsjv.devsicodetv.controllers.listTransferByClose;

import ve.com.fsjv.devsicodetv.views.ListTransferByCloseDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private ListTransferByCloseDialog form;
    public DialogManager(){
        this.form = new ListTransferByCloseDialog(new JFrame(), true);
        this.form.setTitle("Traslados por Finalizar");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
