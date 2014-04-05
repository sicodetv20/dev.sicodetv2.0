package ve.com.fsjv.devsicodetv.controllers.foodDelivery;

import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.others.TitleApp;
import ve.com.fsjv.devsicodetv.views.FoodDeliveryDialog;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class FoodDeliveryDialogManager {
    private FoodDeliveryDialog form;
    public FoodDeliveryDialogManager(){
        this.form = new FoodDeliveryDialog(new JFrame(), true);
        this.form.setTitle(TitleApp.FOOD_DELIVERY_FORM_TITLE);
        this.form.setLocationRelativeTo(null);
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
