package ve.com.fsjv.devsicodetv.controllers.block;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ve.com.fsjv.devsicodetv.controllers.listLastAdded.ListLastAddedDialogManager;
import ve.com.fsjv.devsicodetv.models.Block;
import ve.com.fsjv.devsicodetv.utils.others.ConstantsApp;
import ve.com.fsjv.devsicodetv.utils.others.Messages;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;
import ve.com.fsjv.devsicodetv.utils.others.Utils;
import ve.com.fsjv.devsicodetv.views.BlockDialog;

/**
 *
 * @author Tecnosoluciones-NS
 */
public class BlockDialogManager implements ActionListener {
    private BlockDialog form;
    private int optionMessage;
    private Block block;
    private Utils utils = new Utils();
    private int actionType;
    private BlockValidateManager validator;
    private BlockDAOManager dao;
    private int flaq;
    
    public BlockDialogManager(){
        this.form = new BlockDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.BLOCK_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setSize(445, 290);
        this.form.getBtnNew().addActionListener(this);
        this.form.getBtnOpen().addActionListener(this);
        this.form.getBtnSave().addActionListener(this);
        this.form.getBtnEdit().addActionListener(this);
        this.form.getBtnDelete().addActionListener(this);
        this.form.getBtnCancel().addActionListener(this);
        this.form.getBtnLastAdded().addActionListener(this);
        this.form.getBtnFind().addActionListener(this);
        this.actionInit();
        this.form.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.form.getBtnLastAdded()){
            this.actionList();
        }else if(e.getSource() == this.form.getBtnNew()){
            this.actionType = ConstantsApp.SAVE_TYPE_OPTION;
            this.actionNew();
        }else if(e.getSource() == this.form.getBtnCancel()){
            this.actionCancel();
        }else if(e.getSource() == this.form.getBtnOpen()){
            this.actionOpen();
        }else if(e.getSource() == this.form.getBtnFind()){
            this.actionFind();
        }else if(e.getSource() == this.form.getBtnSave()){
            this.actionSave(this.actionType);
        }else if(e.getSource() == this.form.getBtnEdit()){
            this.actionType = ConstantsApp.EDIT_TYPE_OPTION;
            this.actionEdit();
        }else if(e.getSource() == this.form.getBtnDelete()){
            this.actionDelete();
        }
        
    }
    
    private void actionInit(){
        this.form.getBtnSave().setEnabled(false);
        this.form.getBtnEdit().setEnabled(false);
        this.form.getBtnDelete().setEnabled(false);
        this.form.getBtnCancel().setEnabled(false);
        this.form.getBtnLastAdded().setEnabled(true);
        this.form.getBtnFind().setEnabled(false);
        this.form.getBtnNew().setEnabled(true);
        this.form.getBtnOpen().setEnabled(true);
        this.form.getTxtTitle().setEditable(false);
        this.form.getTxtDescription().setEditable(false);
        this.form.getChkHaveCells().setEnabled(false);
        this.form.getTxtTitle().setText("");
        this.form.getTxtDescription().setText("");
        this.form.getChkHaveCells().setSelected(false);
    }
    
    private void actionNew(){
        this.form.getBtnSave().setEnabled(true);
        this.form.getBtnEdit().setEnabled(false);
        this.form.getBtnDelete().setEnabled(false);
        this.form.getBtnCancel().setEnabled(true);
        this.form.getBtnLastAdded().setEnabled(false);
        this.form.getBtnFind().setEnabled(true);
        this.form.getBtnNew().setEnabled(false);
        this.form.getBtnOpen().setEnabled(false);
        this.form.getTxtTitle().setEditable(true);
        this.form.getTxtDescription().setEditable(true);
        this.form.getChkHaveCells().setEnabled(true);
        this.form.getTxtTitle().setText("");
        this.form.getTxtDescription().setText("");
        this.form.getChkHaveCells().setSelected(false);
        this.form.getTxtTitle().setFocusable(true);
    }
    
    private void actionOpen(){
        this.form.getBtnSave().setEnabled(false);
        this.form.getBtnEdit().setEnabled(false);
        this.form.getBtnDelete().setEnabled(false);
        this.form.getBtnCancel().setEnabled(true);
        this.form.getBtnLastAdded().setEnabled(false);
        this.form.getBtnFind().setEnabled(true);
        this.form.getBtnNew().setEnabled(false);
        this.form.getBtnOpen().setEnabled(false);
        this.form.getTxtTitle().setEditable(true);
        this.form.getTxtDescription().setEditable(false);
        this.form.getChkHaveCells().setEnabled(false);
        this.form.getTxtTitle().setText("");
        this.form.getTxtDescription().setText("");
        this.form.getChkHaveCells().setSelected(false);
        this.form.getTxtTitle().setFocusable(true);
    }
    
    private void actionEdit(){
        this.form.getBtnSave().setEnabled(true);
        this.form.getBtnEdit().setEnabled(false);
        this.form.getBtnDelete().setEnabled(false);
        this.form.getBtnCancel().setEnabled(true);
        this.form.getBtnLastAdded().setEnabled(false);
        this.form.getBtnFind().setEnabled(true);
        this.form.getBtnNew().setEnabled(false);
        this.form.getBtnOpen().setEnabled(false);
        this.form.getTxtTitle().setEditable(true);
        this.form.getTxtDescription().setEditable(true);
        this.form.getChkHaveCells().setEnabled(true);
        this.form.getTxtTitle().setFocusable(true);
    }
    
    private void actionSave(int actionType){
        if(actionType == ConstantsApp.SAVE_TYPE_OPTION){
            this.optionMessage = JOptionPane.showConfirmDialog(this.form, Messages.CONFIRM_SAVE_CHANGES, TitleApp.COFIRM_TITLE, this.optionMessage, JOptionPane.OK_CANCEL_OPTION);
            if(this.optionMessage == ConstantsApp.CONFIRM_OK_OPTION){
                this.block = new Block();
                this.block.setHaveCells(this.form.getChkHaveCells().isSelected());
                this.block.setTitle(this.form.getTxtTitle().getText().trim().toUpperCase());
                this.block.setDescription(this.form.getTxtDescription().getText().trim().toUpperCase());
                this.block.setCreateDate(Utils.getCurrentDate());
                this.block.setLastUpdated(Utils.getCurrentDate());
                this.block.setLastSelected(Utils.getCurrentDate());
                this.block.setStatus(ConstantsApp.ACTIVE_RECORD);
                this.validator = new BlockValidateManager(this.block);
                String message = this.validator.validator();
                if(message != null && !message.isEmpty())
                    JOptionPane.showMessageDialog(this.form, message, TitleApp.ALERT_TITLE, JOptionPane.ERROR_MESSAGE);
                else{
                    this.dao = new BlockDAOManager();
                    this.flaq = this.dao.insert(this.block);
                    if(this.flaq == ConstantsApp.OK_PROCESS){
                        JOptionPane.showMessageDialog(this.form, Messages.OK_PROCESS, TitleApp.INFO_TITLE, JOptionPane.INFORMATION_MESSAGE);
                        this.actionInit();
                    }else
                        JOptionPane.showMessageDialog(this.form, Messages.INTERNAL_ERROR_OCCURRED, TitleApp.ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
                }
            }
        }else if(actionType == ConstantsApp.EDIT_TYPE_OPTION){
            this.optionMessage = JOptionPane.showConfirmDialog(this.form, Messages.CONFIRM_SAVE_CHANGES, TitleApp.COFIRM_TITLE, this.optionMessage, JOptionPane.OK_CANCEL_OPTION);
            if(this.optionMessage == ConstantsApp.CONFIRM_OK_OPTION){
                this.block.setLastUpdated(Utils.getCurrentDate());
                this.block.setLastSelected(Utils.getCurrentDate());
                this.validator = new BlockValidateManager(this.block);
                String message = this.validator.validator();
                if(message != null && !message.isEmpty())
                    JOptionPane.showMessageDialog(this.form, message, TitleApp.ALERT_TITLE, JOptionPane.ERROR_MESSAGE);
                else{
                    this.dao = new BlockDAOManager();
                    this.flaq = this.dao.update(this.block);
                    if(this.flaq == ConstantsApp.OK_PROCESS){
                        JOptionPane.showMessageDialog(this.form, Messages.OK_PROCESS, TitleApp.INFO_TITLE, JOptionPane.INFORMATION_MESSAGE);
                        this.actionInit();
                    }else
                        JOptionPane.showMessageDialog(this.form, Messages.INTERNAL_ERROR_OCCURRED, TitleApp.ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }else if(actionType == ConstantsApp.DELETE_TYPE_OPTION){
            this.optionMessage = JOptionPane.showConfirmDialog(this.form, Messages.DELETE_ITEM_SELECTED, TitleApp.COFIRM_TITLE, this.optionMessage, JOptionPane.OK_CANCEL_OPTION);
            if(this.optionMessage == ConstantsApp.CONFIRM_OK_OPTION){
                this.block.setLastUpdated(Utils.getCurrentDate());
                this.block.setLastSelected(Utils.getCurrentDate());
                this.dao = new BlockDAOManager();
                this.flaq = this.dao.delete(this.block);
                if(this.flaq == ConstantsApp.OK_PROCESS){
                    JOptionPane.showMessageDialog(this.form, Messages.OK_PROCESS, TitleApp.INFO_TITLE, JOptionPane.INFORMATION_MESSAGE);
                    this.actionInit();
                }else
                    JOptionPane.showMessageDialog(this.form, Messages.INTERNAL_ERROR_OCCURRED, TitleApp.ERROR_TITLE, JOptionPane.ERROR_MESSAGE);                    
            }
        }
    }
    
    private void actionDelete(){
        this.actionSave(ConstantsApp.DELETE_TYPE_OPTION);
    }
    
    private void actionCancel(){
        this.actionInit();
    }
    
    private void actionList(){
        this.dao = new BlockDAOManager();
        this.dao.findAllLastAdded();
        DefaultTableModel aModel = new DefaultTableModel();
        Object[] columnNames = new Object[2];
        columnNames[0] = "ID";
        columnNames[1] = "Título";
        aModel.setColumnIdentifiers(columnNames);
        Object[] objects = new Object[2];
        ListIterator<Block> iList = this.dao.list.listIterator();
        while(iList.hasNext()){
            Block b = iList.next();
            objects[0] = b.getId();
            objects[1] = b.getTitle();
            aModel.addRow(objects);
        }
        ListLastAddedDialogManager dialog = new ListLastAddedDialogManager(TitleApp.LAST_BLOCK_ADDED_FORM_TITLE, aModel);
    }
    
    private void actionFind(){
        if(this.form.getTxtTitle() != null && !this.form.getTxtTitle().getText().isEmpty()){
            this.block = new Block();
            this.dao = new BlockDAOManager();
            this.block = this.dao.findByAttributes(this.form.getTxtTitle().getText().trim().toUpperCase());
            if(this.block != null){
                this.form.getTxtTitle().setText(this.block.getTitle());
                this.form.getTxtDescription().setText(this.block.getDescription());
                if(this.block.isHaveCells())
                    this.form.getChkHaveCells().setSelected(true);
                else
                    this.form.getChkHaveCells().setSelected(false);
                this.form.getBtnSave().setEnabled(false);
                this.form.getBtnEdit().setEnabled(true);
                this.form.getBtnDelete().setEnabled(true);
                this.form.getBtnCancel().setEnabled(true);
                this.form.getBtnLastAdded().setEnabled(false);
                this.form.getBtnFind().setEnabled(true);
                this.form.getBtnNew().setEnabled(false);
                this.form.getBtnOpen().setEnabled(false);
                this.form.getTxtTitle().setEditable(false);
                this.form.getTxtDescription().setEditable(false);
                this.form.getChkHaveCells().setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(this.form, Messages.SEARCH_RESULTS_NOT_FOUND, TitleApp.INFO_TITLE, JOptionPane.INFORMATION_MESSAGE);
                this.actionInit();
            }
        }else{
            JOptionPane.showMessageDialog(this.form, Messages.ERROR_SEARCH_VALUE_EMPTY, TitleApp.ALERT_TITLE, JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
