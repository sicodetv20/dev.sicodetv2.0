package ve.com.fsjv.devsicodetv.controllers;

import javax.swing.JDialog;
import ve.com.fsjv.devsicodetv.views.Menu2Dialog;
import ve.com.fsjv.devsicodetv.controllers.FichaDetenidoDialogManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author franklin
 */
public class MenuDialogManager implements ActionListener {
    private Menu2Dialog formulario;
    
    public MenuDialogManager(){
        this.formulario = new Menu2Dialog();
        this.formulario.setVisible(true);
        this.formulario.btnFichaDetenido.addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==this.formulario.btnFichaDetenido){
                FichaDetenidoDialogManager form = new FichaDetenidoDialogManager();
            }
        }catch(Exception error){
        
        }
    }
    
}
