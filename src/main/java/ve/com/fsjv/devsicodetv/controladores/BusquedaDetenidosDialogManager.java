/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ve.com.fsjv.devsicodetv.controladores.eventos.BusquedaDetenidosDialogEvents;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionCampoVacio;
import ve.com.fsjv.devsicodetv.utilitarios.otros.Procesos;
import ve.com.fsjv.devsicodetv.vistas.BusquedaDetenidosDialog;
import ve.com.fsjv.devsicodetv.utilitarios.otros.ConstantesApp;

/**
 *
 * @author FAMILIA-SJ
 */
public class BusquedaDetenidosDialogManager implements ActionListener  {
    private BusquedaDetenidosDialog formulario;
    private Procesos procesos;
    private BusquedaDetenidosDialogEvents eventos;
    
    public BusquedaDetenidosDialogManager() throws ExcepcionCampoVacio {
        this.formulario = new BusquedaDetenidosDialog(new JFrame(), true);
        this.procesos = new Procesos();
        this.eventos = new BusquedaDetenidosDialogEvents(this.formulario, this.procesos);
        this.formulario.setSize(440, 440);
        this.formulario.setTitle(this.procesos.cargarMembreteBarraTitulo(ConstantesApp.ACRONIMO_MODULO_BUSQUEDA_DETENIDOS, "Administrador", ConstantesApp.TITULO_DOBLE));
        this.procesos.limpiarClipboard();
        this.formulario.setLocationRelativeTo(null);
        this.formulario.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.eventos.iniciarFormulario();
        
        this.formulario.getRadAlias().addActionListener(this);
        this.formulario.getRadApellidos().addActionListener(this);
        this.formulario.getRadCedulaIdentidad().addActionListener(this);
        this.formulario.getRadNombres().addActionListener(this);
        this.formulario.getRadNombresApellidos().addActionListener(this);
        this.formulario.getRadNroControl().addActionListener(this);
        this.formulario.getRadPasaporte().addActionListener(this);
        this.formulario.getRadRasgoFisico().addActionListener(this);
        this.formulario.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.formulario.getRadAlias() || e.getSource() == this.formulario.getRadApellidos() || e.getSource() == this.formulario.getRadCedulaIdentidad()
                || e.getSource() == this.formulario.getRadNombres() || e.getSource() == this.formulario.getRadNombresApellidos() || e.getSource() == this.formulario.getRadNroControl()
                || e.getSource() == this.formulario.getRadPasaporte() || e.getSource() == this.formulario.getRadRasgoFisico()){
            this.eventos.habilitarFormulario();
        }
    }
    
}
