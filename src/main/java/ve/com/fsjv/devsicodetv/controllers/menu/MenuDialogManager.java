package ve.com.fsjv.devsicodetv.controllers.menu;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ve.com.fsjv.devsicodetv.views.MenuDialog;
import ve.com.fsjv.devsicodetv.utils.others.Messages;
import ve.com.fsjv.devsicodetv.utils.others.ConstantsApp;
import ve.com.fsjv.devsicodetv.controllers.record.RecordDialogManager;
import ve.com.fsjv.devsicodetv.controllers.output.OutputDialogManager;
import ve.com.fsjv.devsicodetv.controllers.transfer.TransferDialogManager;
import ve.com.fsjv.devsicodetv.controllers.foodDelivery.FoodDeliveryDialogManager;
import ve.com.fsjv.devsicodetv.controllers.visit.VisitDialogManager;
import ve.com.fsjv.devsicodetv.controllers.findRecord.SimpleSearchRecordDialogManager;
import ve.com.fsjv.devsicodetv.controllers.listLastAdded.ListLastAddedDialogManager;
import ve.com.fsjv.devsicodetv.controllers.listTransferByClose.ListTransferByCloseDialogManager;
import ve.com.fsjv.devsicodetv.controllers.listVisitByClose.ListVisitByCloseDialogManager;
import ve.com.fsjv.devsicodetv.controllers.crime.CrimeDialogManager;
import ve.com.fsjv.devsicodetv.controllers.outputType.OutputTypeDialogManager;
import ve.com.fsjv.devsicodetv.controllers.outputTopic.OutputTopicDialogManager;
import ve.com.fsjv.devsicodetv.controllers.transferType.TransferTypeDialogManager;
import ve.com.fsjv.devsicodetv.controllers.transferTopic.TransferTopicDialogManager;
import ve.com.fsjv.devsicodetv.controllers.organization.OrganizationDialogManager;
import ve.com.fsjv.devsicodetv.controllers.cell.CellDialogManager;
import ve.com.fsjv.devsicodetv.controllers.block.BlockDialogManager;
import ve.com.fsjv.devsicodetv.controllers.visitType.VisitTypeDialogManager;
import ve.com.fsjv.devsicodetv.controllers.updatePassword.UpdatePasswordDialogManager;
import ve.com.fsjv.devsicodetv.controllers.user.UserDialogManager;
import ve.com.fsjv.devsicodetv.controllers.role.RoleDialogManager;
import ve.com.fsjv.devsicodetv.controllers.permission.PermissionDialogManager;
import ve.com.fsjv.devsicodetv.controllers.login.LoginDialogManager;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;

/**
 *
 * @author Tecnosoluciones-NS
 */
public class MenuDialogManager implements ActionListener {
    private MenuDialog form;
    public MenuDialogManager(){
        this.form = new MenuDialog();
        this.form.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.form.dispose();
        this.form.setUndecorated(true);
        LoginDialogManager dialog = new LoginDialogManager();
        if(dialog.login() == ConstantsApp.USER_NO_LOGGED)
            dialog.initForm();
        else
            this.form.setVisible(true);
        this.form.getItemExit().addActionListener(this);
        this.form.getItemRecord().addActionListener(this);
        this.form.getItemOutput().addActionListener(this);
        this.form.getItemTransfer().addActionListener(this);
        this.form.getItemFoodDelivery().addActionListener(this);
        this.form.getItemVisit().addActionListener(this);
        this.form.getItemFindByPhoto().addActionListener(this);
        this.form.getItemSimpleSearch().addActionListener(this);
        this.form.getItemAdvancedSearch().addActionListener(this);
        this.form.getItemLastRecordSelected().addActionListener(this);
        this.form.getItemLastTransferAdded().addActionListener(this);
        this.form.getItemLastVisitAdded().addActionListener(this);
        this.form.getItemLastFoodDeliveryAdded().addActionListener(this);
        this.form.getItemLastOutputAdded().addActionListener(this);
        this.form.getItemTrasferPending().addActionListener(this);
        this.form.getItemVisitActives().addActionListener(this);
        this.form.getItemTransferPendingMonitor().addActionListener(this);
        this.form.getItemVisitActiveMonitor().addActionListener(this);
        this.form.getItemPersonArrestedMonitor().addActionListener(this);
        this.form.getItemCrimeType().addActionListener(this);
        this.form.getItemOutputType().addActionListener(this);
        this.form.getItemOutputTopic().addActionListener(this);
        this.form.getItemTransferType().addActionListener(this);
        this.form.getItemTransferTopic().addActionListener(this);
        this.form.getItemOrganization().addActionListener(this);
        this.form.getItemBlock().addActionListener(this);
        this.form.getItemCell().addActionListener(this);
        this.form.getItemVisitType().addActionListener(this);
        this.form.getItemUpdatePassword().addActionListener(this);
        this.form.getItemEditProfile().addActionListener(this);
        this.form.getItemUser().addActionListener(this);
        this.form.getItemRole().addActionListener(this);
        this.form.getItemPermission().addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.form.getItemExit()){
            int option = ConstantsApp.OK_EXIT_APP;
            option = JOptionPane.showConfirmDialog(this.form, Messages.EXIT_APPLICATION, TitleApp.MESSAGE_CONFIRMATION_TITLE, option, JOptionPane.OK_CANCEL_OPTION);
            if(option == ConstantsApp.OK_EXIT_APP){
                System.exit(ConstantsApp.OK_EXIT_APP);
            }
        }else if(e.getSource() == this.form.getItemRecord()){
            RecordDialogManager dialog = new RecordDialogManager();
        }else if(e.getSource() == this.form.getItemOutput()){
            OutputDialogManager dialog = new OutputDialogManager();
        }else if(e.getSource() == this.form.getItemTransfer()){
            TransferDialogManager dialog = new TransferDialogManager();
        }else if(e.getSource() == this.form.getItemFoodDelivery()){
            FoodDeliveryDialogManager dialog = new FoodDeliveryDialogManager();
        }else if(e.getSource() == this.form.getItemVisit()){
            VisitDialogManager dialog = new VisitDialogManager();
        }else if(e.getSource() == this.form.getItemFindByPhoto()){
            JOptionPane.showMessageDialog(this.form, Messages.FORM_BY_DEVELOP, TitleApp.MESSAGE_CONFIRMATION_TITLE, JOptionPane.ERROR_MESSAGE);
        }else if(e.getSource() == this.form.getItemSimpleSearch()){
            SimpleSearchRecordDialogManager dialog = new SimpleSearchRecordDialogManager();
        }else if(e.getSource() == this.form.getItemAdvancedSearch()){
            JOptionPane.showMessageDialog(this.form, Messages.FORM_BY_DEVELOP, TitleApp.MESSAGE_CONFIRMATION_TITLE, JOptionPane.ERROR_MESSAGE);
        }else if(e.getSource() == this.form.getItemLastRecordSelected()){
            ListLastAddedDialogManager dialog = new ListLastAddedDialogManager(TitleApp.LAST_RECORD_SELECTED_FORM_TITLE, null);
        }else if(e.getSource() == this.form.getItemLastTransferAdded()){
            ListLastAddedDialogManager dialog = new ListLastAddedDialogManager(TitleApp.LAST_TRANSFER_ADDED_FORM_TITLE, null);
        }else if(e.getSource() == this.form.getItemLastVisitAdded()){
            ListLastAddedDialogManager dialog = new ListLastAddedDialogManager(TitleApp.LAST_VISIT_ADDED_FORM_TITLE, null);
        }else if(e.getSource() == this.form.getItemLastFoodDeliveryAdded()){
            ListLastAddedDialogManager dialog = new ListLastAddedDialogManager(TitleApp.LAST_FOOD_DELIVERY_ADDED_FORM_TITLE, null);
        }else if(e.getSource() == this.form.getItemLastOutputAdded()){
            ListLastAddedDialogManager dialog = new ListLastAddedDialogManager(TitleApp.LAST_OUTPUT_ADDED_FORM_TITLE, null);
        }else if(e.getSource() == this.form.getItemTrasferPending()){
            ListTransferByCloseDialogManager dialog = new ListTransferByCloseDialogManager();
        }else if(e.getSource() == this.form.getItemVisitActives()){
            ListVisitByCloseDialogManager dialog = new ListVisitByCloseDialogManager();
        }else if(e.getSource() == this.form.getItemTransferPendingMonitor()){
            JOptionPane.showMessageDialog(this.form, Messages.FORM_BY_DEVELOP, TitleApp.MESSAGE_CONFIRMATION_TITLE, JOptionPane.ERROR_MESSAGE);
        }else if(e.getSource() == this.form.getItemVisitActiveMonitor()){
            JOptionPane.showMessageDialog(this.form, Messages.FORM_BY_DEVELOP, TitleApp.MESSAGE_CONFIRMATION_TITLE, JOptionPane.ERROR_MESSAGE);
        }else if(e.getSource() == this.form.getItemPersonArrestedMonitor()){
            JOptionPane.showMessageDialog(this.form, Messages.FORM_BY_DEVELOP, TitleApp.MESSAGE_CONFIRMATION_TITLE, JOptionPane.ERROR_MESSAGE);
        }else if(e.getSource() == this.form.getItemCrimeType()){
            CrimeDialogManager dialog = new CrimeDialogManager();
        }else if(e.getSource() == this.form.getItemOutputType()){
            OutputTypeDialogManager dialog = new OutputTypeDialogManager();
        }else if(e.getSource() == this.form.getItemOutputTopic()){
            OutputTopicDialogManager dialog = new OutputTopicDialogManager();
        }else if(e.getSource() == this.form.getItemTransferType()){
            TransferTypeDialogManager dialog = new TransferTypeDialogManager();
        }else if(e.getSource() == this.form.getItemTransferTopic()){
            TransferTopicDialogManager dialog = new TransferTopicDialogManager();
        }else if(e.getSource() == this.form.getItemOrganization()){
            OrganizationDialogManager dialog = new OrganizationDialogManager();
        }else if(e.getSource() == this.form.getItemBlock()){
            BlockDialogManager dialog = new BlockDialogManager();
        }else if(e.getSource() == this.form.getItemCell()){
            CellDialogManager dialog = new CellDialogManager();
        }else if(e.getSource() == this.form.getItemVisitType()){
            VisitTypeDialogManager dialog = new VisitTypeDialogManager();
        }else if(e.getSource() == this.form.getItemUpdatePassword()){
            UpdatePasswordDialogManager dialog = new UpdatePasswordDialogManager();
        }else if(e.getSource() == this.form.getItemEditProfile()){
            JOptionPane.showMessageDialog(this.form, Messages.FORM_BY_DEVELOP, TitleApp.MESSAGE_CONFIRMATION_TITLE, JOptionPane.ERROR_MESSAGE);
        }else if(e.getSource() == this.form.getItemUser()){
            UserDialogManager dialog = new UserDialogManager();
        }else if(e.getSource() == this.form.getItemRole()){
            RoleDialogManager dialog = new RoleDialogManager();
        }else if(e.getSource() == this.form.getItemPermission()){
            PermissionDialogManager dialog = new PermissionDialogManager();
        }
    }
}
