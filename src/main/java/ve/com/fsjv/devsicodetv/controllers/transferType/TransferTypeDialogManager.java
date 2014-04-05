package ve.com.fsjv.devsicodetv.controllers.transferType;

import ve.com.fsjv.devsicodetv.views.TransferTypeDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class TransferTypeDialogManager {
    private TransferTypeDialog form;
    public TransferTypeDialogManager(){
        this.form = new TransferTypeDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.TRANSFER_TYPE_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
