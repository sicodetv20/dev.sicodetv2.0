/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.controladores;

import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionCampoVacio;
import ve.com.fsjv.devsicodetv.utilitarios.otros.Procesos;
import ve.com.fsjv.devsicodetv.vistas.BusquedaDetenidosDialog;
import ve.com.fsjv.devsicodetv.utilitarios.otros.ConstantesApp;

/**
 *
 * @author FAMILIA-SJ
 */
public class BusquedaDetenidosDialogManager {
    private BusquedaDetenidosDialog formulario;
    private Procesos procesos;
    
    public BusquedaDetenidosDialogManager() throws ExcepcionCampoVacio {
        this.formulario = new BusquedaDetenidosDialog(new JFrame(), true);
        this.procesos = new Procesos();
        this.formulario.setSize(440, 440);
        this.formulario.setTitle(this.procesos.cargarMembreteBarraTitulo(ConstantesApp.ACRONIMO_MODULO_BUSQUEDA_DETENIDOS, "Administrador", ConstantesApp.TITULO_DOBLE));
        this.procesos.limpiarClipboard();
        this.formulario.setLocationRelativeTo(null);
        this.formulario.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.formulario.setVisible(true);
    }
    
}
