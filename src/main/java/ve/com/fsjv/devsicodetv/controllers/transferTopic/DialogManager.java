package ve.com.fsjv.devsicodetv.controllers.transferTopic;

import ve.com.fsjv.devsicodetv.views.TransferTopicDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private TransferTopicDialog form;
    public DialogManager(){
        this.form = new TransferTopicDialog(new JFrame(), true);
        this.form.setTitle("Topicos de  Traslados");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
