package ve.com.fsjv.devsicodetv.controllers.outputType;

import ve.com.fsjv.devsicodetv.views.OutputTypeDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class OutputTypeDialogManager {
    private OutputTypeDialog form;
    public OutputTypeDialogManager(){
        this.form = new OutputTypeDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.OUTPUT_TYPE_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
