package ve.com.fsjv.devsicodetv.controllers.block;

import ve.com.fsjv.devsicodetv.views.BlockDialog;
import javax.swing.JFrame;
import javax.swing.JDialog;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;

/**
 *
 * @author Tecnosoluciones-NS
 */
public class BlockDialogManager {
    private BlockDialog form;
    public BlockDialogManager(){
        this.form = new BlockDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.BLOCK_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
