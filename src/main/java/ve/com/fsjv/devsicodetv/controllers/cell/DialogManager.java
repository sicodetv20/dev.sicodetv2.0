package ve.com.fsjv.devsicodetv.controllers.cell;

import ve.com.fsjv.devsicodetv.views.CellDialog;
import javax.swing.JFrame;
import javax.swing.JDialog;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private CellDialog form;
    public DialogManager(){
        this.form = new CellDialog(new JFrame(), true);
        this.form.setTitle("Celdas de Detenidos");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
            
    
}
