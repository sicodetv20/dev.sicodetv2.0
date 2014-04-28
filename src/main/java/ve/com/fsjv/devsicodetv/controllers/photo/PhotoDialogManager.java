package ve.com.fsjv.devsicodetv.controllers.photo;

import ve.com.fsjv.devsicodetv.views.PhotoDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class PhotoDialogManager {
    private PhotoDialog form;
    public PhotoDialogManager(){
        this.form = new PhotoDialog(new JFrame(), true);
        this.form.setTitle("Galeria de Photos");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
