package ve.com.fsjv.devsicodetv.controllers.outputTopic;

import ve.com.fsjv.devsicodetv.views.OutputTopicDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private OutputTopicDialog form;
    public DialogManager(){
        this.form = new OutputTopicDialog(new JFrame(), true);
        this.form.setTitle("Topicos de Salidas");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
