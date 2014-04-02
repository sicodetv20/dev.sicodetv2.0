package ve.com.fsjv.devsicodetv.controllers.transferType;

import ve.com.fsjv.devsicodetv.views.TransferTypeDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private TransferTypeDialog form;
    public DialogManager(){
        this.form = new TransferTypeDialog(new JFrame(), true);
        this.form.setTitle("Tipos de Traslados");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
