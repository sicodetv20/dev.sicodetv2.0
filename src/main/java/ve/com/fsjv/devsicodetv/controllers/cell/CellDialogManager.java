package ve.com.fsjv.devsicodetv.controllers.cell;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.controllers.listLastAdded.ListLastAddedDialogManager;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;
import ve.com.fsjv.devsicodetv.views.CellDialog;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class CellDialogManager implements ActionListener {
    private CellDialog form;
    public CellDialogManager(){
        this.form = new CellDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.CELL_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setSize(445, 350);
        this.form.getBtnLastAdded().addActionListener(this);
        this.form.getBtnCancel().addActionListener(this);
        this.form.getBtnDelete().addActionListener(this);
        this.form.getBtnEdit().addActionListener(this);
        this.form.getBtnFind().addActionListener(this);
        this.form.getBtnNew().addActionListener(this);
        this.form.getBtnOpen().addActionListener(this);
        this.form.getBtnSave().addActionListener(this);
        this.actionInit();
        this.form.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.form.getBtnLastAdded()){
            this.actionList();
        }else if(e.getSource() == this.form.getBtnCancel()){
            this.actionCancel();
        }else if(e.getSource() == this.form.getBtnDelete()){
            this.actionDelete();
        }else if(e.getSource() == this.form.getBtnEdit()){
            this.actionEdit();
        }else if(e.getSource() == this.form.getBtnFind()){
            this.actionFind();
        }else if(e.getSource() == this.form.getBtnNew()){
            this.actionNew();
        }else if(e.getSource() == this.form.getBtnOpen()){
            this.actionOpen();
        }else if(e.getSource() == this.form.getBtnSave()){
            this.actionSave();
        }
    }
    
    private void actionInit(){
        this.form.getBtnCancel().setEnabled(false);
        this.form.getBtnDelete().setEnabled(false);
        this.form.getBtnEdit().setEnabled(false);
        this.form.getBtnFind().setEnabled(false);
        this.form.getBtnOpen().setEnabled(true);
        this.form.getBtnLastAdded().setEnabled(true);
        this.form.getBtnNew().setEnabled(true);
        this.form.getBtnSave().setEnabled(false);
        this.form.getCmbBlock().setSelectedIndex(0);
        this.form.getCmbBlock().setEnabled(false);
        this.form.getTxtTitle().setText("");
        this.form.getTxtTitle().setEditable(false);
        this.form.getTxtDescription().setText("");
        this.form.getTxtDescription().setEditable(false);
        this.form.getTxtAmount().setText("0");
        this.form.getTxtAmount().setEditable(false);
        this.form.getTxtDisponibility().setText("0");
    }
    
    private void actionList(){
        ListLastAddedDialogManager dialog = new ListLastAddedDialogManager(TitleApp.LAST_CELLS_ADDED_FORM_TITLE, null);
    }
    
    private void actionCancel(){
        this.actionInit();
    }
    
    private void actionDelete(){
        this.actionInit();
    }
    
    private void actionEdit(){
        this.form.getBtnCancel().setEnabled(true);
        this.form.getBtnDelete().setEnabled(false);
        this.form.getBtnEdit().setEnabled(false);
        this.form.getBtnFind().setEnabled(true);
        this.form.getBtnOpen().setEnabled(false);
        this.form.getBtnLastAdded().setEnabled(false);
        this.form.getBtnNew().setEnabled(false);
        this.form.getBtnSave().setEnabled(true);
        this.form.getCmbBlock().setEnabled(true);
        this.form.getTxtTitle().setEditable(true);
        this.form.getTxtDescription().setEditable(true);
        this.form.getTxtAmount().setEditable(true);
    }
    
    private void actionFind(){
        this.form.getBtnCancel().setEnabled(true);
        this.form.getBtnDelete().setEnabled(true);
        this.form.getBtnEdit().setEnabled(true);
        this.form.getBtnFind().setEnabled(false);
        this.form.getBtnOpen().setEnabled(false);
        this.form.getBtnLastAdded().setEnabled(false);
        this.form.getBtnNew().setEnabled(false);
        this.form.getBtnSave().setEnabled(false);
        this.form.getCmbBlock().setEnabled(false);
        this.form.getTxtTitle().setEditable(false);
        this.form.getTxtDescription().setEditable(false);
        this.form.getTxtAmount().setEditable(false);
    }
    
    private void actionNew(){
        this.form.getBtnCancel().setEnabled(true);
        this.form.getBtnDelete().setEnabled(false);
        this.form.getBtnEdit().setEnabled(false);
        this.form.getBtnFind().setEnabled(true);
        this.form.getBtnOpen().setEnabled(false);
        this.form.getBtnLastAdded().setEnabled(false);
        this.form.getBtnNew().setEnabled(false);
        this.form.getBtnSave().setEnabled(true);
        this.form.getCmbBlock().setSelectedIndex(0);
        this.form.getCmbBlock().setEnabled(true);
        this.form.getTxtTitle().setText("");
        this.form.getTxtTitle().setEditable(true);
        this.form.getTxtDescription().setText("");
        this.form.getTxtDescription().setEditable(true);
        this.form.getTxtAmount().setText("0");
        this.form.getTxtAmount().setEditable(true);
        this.form.getTxtDisponibility().setText("0");
    }
    
    private void actionOpen(){
        this.form.getBtnCancel().setEnabled(true);
        this.form.getBtnDelete().setEnabled(false);
        this.form.getBtnEdit().setEnabled(false);
        this.form.getBtnFind().setEnabled(true);
        this.form.getBtnOpen().setEnabled(false);
        this.form.getBtnLastAdded().setEnabled(false);
        this.form.getBtnNew().setEnabled(false);
        this.form.getBtnSave().setEnabled(false);
        this.form.getCmbBlock().setSelectedIndex(0);
        this.form.getCmbBlock().setEnabled(false);
        this.form.getTxtTitle().setText("");
        this.form.getTxtTitle().setEditable(true);
        this.form.getTxtDescription().setText("");
        this.form.getTxtDescription().setEditable(false);
        this.form.getTxtAmount().setText("0");
        this.form.getTxtAmount().setEditable(false);
        this.form.getTxtDisponibility().setText("0");
    }
    
    private void actionSave(){
        this.actionInit();
    }
            
    
}
