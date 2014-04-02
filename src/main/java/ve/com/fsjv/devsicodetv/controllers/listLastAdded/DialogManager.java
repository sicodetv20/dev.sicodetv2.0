package ve.com.fsjv.devsicodetv.controllers.listLastAdded;

import ve.com.fsjv.devsicodetv.views.ListLastAddedDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private ListLastAddedDialog form;
    public DialogManager(){
        this.form = new ListLastAddedDialog(new JFrame(), true);
        this.form.setTitle("Ultimos Registros Agregados");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
