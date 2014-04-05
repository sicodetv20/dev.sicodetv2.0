package ve.com.fsjv.devsicodetv.controllers.transfer;


import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;
import ve.com.fsjv.devsicodetv.views.TransferDialog;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class TransferDialogManager {
    private TransferDialog form;
    public TransferDialogManager(){
        this.form = new TransferDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.TRANSFER_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
