package ve.com.fsjv.devsicodetv.controllers.listTransferByClose;

import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;
import ve.com.fsjv.devsicodetv.views.ListTransferByCloseDialog;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class ListTransferByCloseDialogManager {
    private ListTransferByCloseDialog form;
    public ListTransferByCloseDialogManager(){
        this.form = new ListTransferByCloseDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.TRANSFER_BY_CLOSE_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
