/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.controladores.eventos;

import javax.swing.JOptionPane;
import ve.com.fsjv.devsicodetv.utilitarios.otros.Procesos;
import ve.com.fsjv.devsicodetv.vistas.BusquedaDetenidosDialog;

/**
 *
 * @author FAMILIA-SJ
 */
public class BusquedaDetenidosDialogMethods {
    private BusquedaDetenidosDialog formulario;
    private Procesos procesos;
    
    public BusquedaDetenidosDialogMethods(BusquedaDetenidosDialog formulario, Procesos procesos){
        this.formulario = formulario;
        this.procesos = procesos;
    }
    
    public void buscar(String valor){
        JOptionPane.showMessageDialog(this.formulario, "Valor: " + valor, "test", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
}
