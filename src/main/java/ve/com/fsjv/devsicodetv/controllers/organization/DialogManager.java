package ve.com.fsjv.devsicodetv.controllers.organization;

import ve.com.fsjv.devsicodetv.views.OrganizationDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;
/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private OrganizationDialog form;
    public DialogManager(){
        this.form = new OrganizationDialog(new JFrame(), true);
        this.form.setTitle("Organismos");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
