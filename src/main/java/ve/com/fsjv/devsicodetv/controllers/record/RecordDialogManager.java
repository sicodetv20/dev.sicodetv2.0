package ve.com.fsjv.devsicodetv.controllers.record;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ve.com.fsjv.devsicodetv.controllers.cause.CauseDialogManager;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;
import ve.com.fsjv.devsicodetv.views.RecordDialog;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class RecordDialogManager implements ActionListener {
    private RecordDialog recordForm;
    public RecordDialogManager(){
        this.recordForm = new RecordDialog(new JFrame(), true);
        this.recordForm.setTitle(TitleApp.RECORD_FORM_TITLE);
        this.recordForm.setSize(Toolkit.getDefaultToolkit().getScreenSize().width - 100, Toolkit.getDefaultToolkit().getScreenSize().height - 100);
        this.recordForm.setLocationRelativeTo(null);
        this.recordForm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.recordForm.getItemNew().addActionListener(this);
        this.recordForm.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        /*
        if(e.getSource() == this.recordForm.getItemNew()){
            System.out.println("hi!");
            JOptionPane.showMessageDialog(this.recordForm, "hi");
            
        }*/
    }
}
