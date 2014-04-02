package ve.com.fsjv.devsicodetv.controllers.output;

import ve.com.fsjv.devsicodetv.views.OutputDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private OutputDialog form;
    public DialogManager(){
        this.form = new OutputDialog(new JFrame(), true);
        this.form.setTitle("Control de Salidas");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
    
}
