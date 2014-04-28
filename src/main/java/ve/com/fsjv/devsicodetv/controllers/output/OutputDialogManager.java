package ve.com.fsjv.devsicodetv.controllers.output;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;
import ve.com.fsjv.devsicodetv.views.OutputDialog;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class OutputDialogManager implements ActionListener {
    private OutputDialog form;
    public OutputDialogManager(){
        this.form = new OutputDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.OUTPUT_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
       
    }
    
}
