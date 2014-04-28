package ve.com.fsjv.devsicodetv.controllers.listLastAdded;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;
import ve.com.fsjv.devsicodetv.views.ListLastAddedDialog;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class ListLastAddedDialogManager {
    private ListLastAddedDialog form;
    public ListLastAddedDialogManager(String type, DefaultTableModel aModel){
        this.form = new ListLastAddedDialog(new JFrame(), true);
        this.form.tblLastAdded.setModel(aModel);
        this.form.setTitle(type);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setModal(true);
        this.form.setVisible(true);
    }
}
