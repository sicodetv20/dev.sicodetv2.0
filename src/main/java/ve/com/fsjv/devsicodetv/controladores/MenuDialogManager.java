package ve.com.fsjv.devsicodetv.controladores;

import javax.swing.JDialog;
import ve.com.fsjv.devsicodetv.vistas.MenuDialog;
import ve.com.fsjv.devsicodetv.controladores.FichaDetenidoDialogManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author franklin
 */
public class MenuDialogManager implements ActionListener {
    private MenuDialog formulario;
    
    public MenuDialogManager(){
        this.formulario = new MenuDialog();
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
