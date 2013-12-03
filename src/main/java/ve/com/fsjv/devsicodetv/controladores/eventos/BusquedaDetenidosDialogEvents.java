/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.controladores.eventos;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionComponenteNulo;
import ve.com.fsjv.devsicodetv.utilitarios.otros.ConstantesApp;
import ve.com.fsjv.devsicodetv.utilitarios.otros.Procesos;
import ve.com.fsjv.devsicodetv.vistas.BusquedaDetenidosDialog;

/**
 *
 * @author FAMILIA-SJ
 */
    public class BusquedaDetenidosDialogEvents {
    private Procesos procesos;
    private BusquedaDetenidosDialog formulario;
    
    public BusquedaDetenidosDialogEvents(BusquedaDetenidosDialog formulario, Procesos procesos){
        this.formulario = formulario;
        this.procesos = procesos;
    }
    
    public void iniciarCampos(){
        this.formulario.getTxtvalor().setBorder(BorderFactory.createLineBorder(new Color(ConstantesApp.BORDER_COLOR_R, ConstantesApp.BORDER_COLOR_G, ConstantesApp.BORDER_COLOR_B)));
        this.formulario.getTxtvalor().setBackground(Color.white);
    }
    
    public void resaltarCampos() throws ExcepcionComponenteNulo{
        this.formulario.setTxtvalor(this.procesos.resaltarCampoRequerido(this.formulario.getTxtvalor()));
    }
    
    public void iniciarFormulario(){
        this.limpiarFormulario();
        this.limpiarJTable();
        this.iniciarCampos();
        this.formulario.getRadAlias().setSelected(ConstantesApp.NO_EDITABLE);
        this.formulario.getRadApellidos().setSelected(ConstantesApp.NO_EDITABLE);
        this.formulario.getRadCedulaIdentidad().setSelected(ConstantesApp.NO_EDITABLE);
        this.formulario.getRadNombres().setSelected(ConstantesApp.NO_EDITABLE);
        this.formulario.getRadNombresApellidos().setSelected(ConstantesApp.NO_EDITABLE);
        this.formulario.getRadNroControl().setSelected(ConstantesApp.NO_EDITABLE);
        this.formulario.getRadPasaporte().setSelected(ConstantesApp.NO_EDITABLE);
        this.formulario.getRadRasgoFisico().setSelected(ConstantesApp.NO_EDITABLE);
        this.formulario.getTxtvalor().setEditable(ConstantesApp.NO_EDITABLE);
        this.formulario.getBtnBuscar().setEnabled(ConstantesApp.NO_EDITABLE);
        this.formulario.getBtnReiniciar().setEnabled(ConstantesApp.NO_EDITABLE);
        this.formulario.getTabResultados().setEnabled(ConstantesApp.NO_EDITABLE);
    }
    
    public void habilitarFormulario() throws ExcepcionComponenteNulo{
        this.limpiarFormulario();
        this.limpiarJTable();
        this.resaltarCampos();
        this.formulario.getTxtvalor().setEditable(ConstantesApp.EDITABLE);
        this.formulario.getTxtvalor().setEnabled(ConstantesApp.EDITABLE);
        this.formulario.getBtnBuscar().setEnabled(ConstantesApp.EDITABLE);
        this.formulario.getBtnReiniciar().setEnabled(ConstantesApp.EDITABLE);
        this.formulario.getTabResultados().setEnabled(ConstantesApp.EDITABLE);
    }
    
    public void limpiarFormulario(){
        this.formulario.getTxtvalor().setText(ConstantesApp.INICIALIZAR_STRING);
    }
    
    public void limpiarJTable(){
        this.formulario.getTabResultados().setModel(new DefaultTableModel());
    }
    
}
