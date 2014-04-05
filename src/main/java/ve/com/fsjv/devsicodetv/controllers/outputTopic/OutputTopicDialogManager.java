package ve.com.fsjv.devsicodetv.controllers.outputTopic;

import ve.com.fsjv.devsicodetv.views.OutputTopicDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class OutputTopicDialogManager {
    private OutputTopicDialog form;
    public OutputTopicDialogManager(){
        this.form = new OutputTopicDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.OUTPUT_TOPIC_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
