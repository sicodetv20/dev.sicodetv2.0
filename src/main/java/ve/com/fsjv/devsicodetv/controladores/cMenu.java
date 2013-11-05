package ve.com.fsjv.devsicodetv.controladores;

import javax.swing.JDialog;
import ve.com.fsjv.devsicodetv.vistas.vMenu;
import ve.com.fsjv.devsicodetv.controladores.cFichaDetenido;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author franklin
 */
public class cMenu implements ActionListener {
    private vMenu formulario;
    
    public cMenu(){
        this.formulario = new vMenu();
        this.formulario.setVisible(true);
        this.formulario.btnFichaDetenido.addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==this.formulario.btnFichaDetenido){
                cFichaDetenido form = new cFichaDetenido();
            }
        }catch(Exception error){
        
        }
    }
    
}
