package ve.com.fsjv.devsicodetv.controllers.listLastAdded;

import ve.com.fsjv.devsicodetv.views.ListLastAddedDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class ListLastAddedDialogManager {
    private ListLastAddedDialog form;
    public ListLastAddedDialogManager(String type){
        this.form = new ListLastAddedDialog(new JFrame(), true);
        this.form.setTitle(type);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
