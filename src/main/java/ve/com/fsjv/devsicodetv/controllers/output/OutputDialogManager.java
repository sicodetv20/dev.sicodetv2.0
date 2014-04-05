package ve.com.fsjv.devsicodetv.controllers.output;

import javax.swing.JDialog;
import javax.swing.JFrame;

import ve.com.fsjv.devsicodetv.views.OutputDialog;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class OutputDialogManager {
    private OutputDialog form;
    public OutputDialogManager(){
        this.form = new OutputDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.OUTPUT_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
    
}
