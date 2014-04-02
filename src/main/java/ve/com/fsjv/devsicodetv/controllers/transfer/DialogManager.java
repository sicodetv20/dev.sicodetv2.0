package ve.com.fsjv.devsicodetv.controllers.transfer;

import ve.com.fsjv.devsicodetv.views.TransferDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private TransferDialog form;
    public DialogManager(){
        this.form = new TransferDialog(new JFrame(), true);
        this.form.setTitle("Traslados a Audiencias y Otros");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
