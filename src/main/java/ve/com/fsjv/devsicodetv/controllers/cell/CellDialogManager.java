package ve.com.fsjv.devsicodetv.controllers.cell;

import ve.com.fsjv.devsicodetv.views.CellDialog;
import javax.swing.JFrame;
import javax.swing.JDialog;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class CellDialogManager {
    private CellDialog form;
    public CellDialogManager(){
        this.form = new CellDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.CELL_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
            
    
}
