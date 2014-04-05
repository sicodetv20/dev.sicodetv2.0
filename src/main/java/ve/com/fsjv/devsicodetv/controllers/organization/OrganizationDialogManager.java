package ve.com.fsjv.devsicodetv.controllers.organization;

import ve.com.fsjv.devsicodetv.views.OrganizationDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;
/**
 *
 * @author TecnoSoluciones-NS
 */
public class OrganizationDialogManager {
    private OrganizationDialog form;
    public OrganizationDialogManager(){
        this.form = new OrganizationDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.ORGANIZATION_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
