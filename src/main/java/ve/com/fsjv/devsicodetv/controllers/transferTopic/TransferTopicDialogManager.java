package ve.com.fsjv.devsicodetv.controllers.transferTopic;

import ve.com.fsjv.devsicodetv.views.TransferTopicDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class TransferTopicDialogManager {
    private TransferTopicDialog form;
    public TransferTopicDialogManager(){
        this.form = new TransferTopicDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.TRANSFER_TOPIC_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
