package ve.com.fsjv.devsicodetv.controllers.foodDelivery;

import ve.com.fsjv.devsicodetv.views.FoodDeliveryDialog;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class DialogManager {
    private FoodDeliveryDialog form;
    public DialogManager(){
        this.form = new FoodDeliveryDialog(new JFrame(), true);
        this.form.setTitle("Entrega de Comidas");
        this.form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.form.setVisible(true);
    }
}
