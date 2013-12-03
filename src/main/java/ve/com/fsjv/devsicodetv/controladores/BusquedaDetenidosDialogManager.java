/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ve.com.fsjv.devsicodetv.controladores.eventos.BusquedaDetenidosDialogEvents;
import ve.com.fsjv.devsicodetv.controladores.eventos.BusquedaDetenidosDialogMethods;
import ve.com.fsjv.devsicodetv.controladores.eventos.BusquedaDetenidosDialogValidates;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionCampoVacio;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionComponenteNulo;
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
    private BusquedaDetenidosDialogValidates validaciones;
    private BusquedaDetenidosDialogMethods metodos;
    
    public BusquedaDetenidosDialogManager() throws ExcepcionCampoVacio {
        this.formulario = new BusquedaDetenidosDialog(new JFrame(), true);
        this.procesos = new Procesos();
        this.eventos = new BusquedaDetenidosDialogEvents(this.formulario, this.procesos);
        this.validaciones = new BusquedaDetenidosDialogValidates(this.formulario, this.procesos);
        this.metodos = new BusquedaDetenidosDialogMethods(this.formulario, this.procesos);
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
        this.formulario.getBtnReiniciar().addActionListener(this);
        this.formulario.getBtnBuscar().addActionListener(this);
        this.formulario.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.formulario.getRadAlias() || e.getSource() == this.formulario.getRadApellidos() || e.getSource() == this.formulario.getRadCedulaIdentidad()
                || e.getSource() == this.formulario.getRadNombres() || e.getSource() == this.formulario.getRadNombresApellidos() || e.getSource() == this.formulario.getRadNroControl()
                || e.getSource() == this.formulario.getRadPasaporte() || e.getSource() == this.formulario.getRadRasgoFisico()){
            try {
                this.eventos.habilitarFormulario();
            } catch (ExcepcionComponenteNulo ex) {
            }
        }else if(e.getSource() == this.formulario.getBtnReiniciar()){
            this.eventos.iniciarFormulario();
        }else if(e.getSource() == this.formulario.getBtnBuscar()){
            ArrayList<String> listaErrores = this.validaciones.validarCampos();
            String mensaje = ConstantesApp.VALIDACION_EXITOSA;
            String tituloMensaje = ConstantesApp.TITULO_VALIDACION;
            int iconoMensaje = JOptionPane.INFORMATION_MESSAGE;
            if(listaErrores.size() > 0){
                iconoMensaje = JOptionPane.ERROR_MESSAGE;
                mensaje = ConstantesApp.VALIDACION_ERROR + "\n";
                for(int i = 0; i < listaErrores.size(); i++){
                    mensaje = mensaje + "     - " + listaErrores.get(i) + "\n";
                }
                JOptionPane.showMessageDialog(this.formulario, mensaje, tituloMensaje, iconoMensaje);
            }else{
                JOptionPane.showMessageDialog(this.formulario, mensaje, tituloMensaje, iconoMensaje);
                int respuesta = JOptionPane.showConfirmDialog(this.formulario, "Desea Iniciar la busqueda?", tituloMensaje, iconoMensaje);
                if(respuesta == JOptionPane.YES_OPTION){
                    //this.metodos.buscar(this.formulario.getTxtvalor().getText().trim());
                }else if(respuesta == JOptionPane.CANCEL_OPTION)
                    this.eventos.iniciarFormulario();
            }
        }
    }
    
}
