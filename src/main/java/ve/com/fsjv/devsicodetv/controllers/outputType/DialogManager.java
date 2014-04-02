package ve.com.fsjv.devsicodetv.controllers.outputType;

import ve.com.fsjv.devsicodetv.views.OutputTypeDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private OutputTypeDialog form;
    public DialogManager(){
        this.form = new OutputTypeDialog(new JFrame(), true);
        this.form.setTitle("Tipos de Salidas");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
