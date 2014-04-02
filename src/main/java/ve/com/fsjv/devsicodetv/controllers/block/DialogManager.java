package ve.com.fsjv.devsicodetv.controllers.block;

import ve.com.fsjv.devsicodetv.views.BlockDialog;
import javax.swing.JFrame;
import javax.swing.JDialog;

/**
 *
 * @author Tecnosoluciones-NS
 */
public class DialogManager {
    private BlockDialog form;
    public DialogManager(){
        this.form = new BlockDialog(new JFrame(), true);
        this.form.setTitle("Bloques y Secciones de Celdas");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
