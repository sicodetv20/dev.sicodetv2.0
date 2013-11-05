package ve.com.fsjv.devsicodetv.controladores;

import ve.com.fsjv.devsicodetv.vistas.vFichaDetenido;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author franklin
 */
public class cFichaDetenido implements ActionListener {
    private vFichaDetenido formulario;
    
    public cFichaDetenido(){
        this.formulario = new vFichaDetenido(new JFrame(), true);
        this.formulario.setSize(1150, 740);
        this.formulario.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.formulario.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
