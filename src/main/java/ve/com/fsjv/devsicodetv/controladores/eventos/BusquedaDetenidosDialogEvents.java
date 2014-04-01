/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.controladores.eventos;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
import ve.com.fsjv.devsicodetv.utils.exceptions.ExcepcionComponenteNulo;
import ve.com.fsjv.devsicodetv.utils.others.ConstantsApp;
import ve.com.fsjv.devsicodetv.utils.others.Utils;
import ve.com.fsjv.devsicodetv.views.BusquedaDetenidosDialog;

/**
 *
 * @author FAMILIA-SJ
 */
    public class BusquedaDetenidosDialogEvents {
    private Utils procesos;
    private BusquedaDetenidosDialog formulario;
    
    public BusquedaDetenidosDialogEvents(BusquedaDetenidosDialog formulario, Utils procesos){
        this.formulario = formulario;
        this.procesos = procesos;
    }
    
    public void iniciarCampos(){
        this.formulario.getTxtvalor().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtvalor().setBackground(Color.white);
    }
    
    public void resaltarCampos() throws ExcepcionComponenteNulo{
        this.formulario.setTxtvalor(this.procesos.resaltarCampoRequerido(this.formulario.getTxtvalor()));
    }
    
    public void iniciarFormulario(){
        this.limpiarFormulario();
        this.limpiarJTable();
        this.iniciarCampos();
        this.formulario.getRadAlias().setSelected(ConstantsApp.NO_EDITABLE);
        this.formulario.getRadApellidos().setSelected(ConstantsApp.NO_EDITABLE);
        this.formulario.getRadCedulaIdentidad().setSelected(ConstantsApp.NO_EDITABLE);
        this.formulario.getRadNombres().setSelected(ConstantsApp.NO_EDITABLE);
        this.formulario.getRadNombresApellidos().setSelected(ConstantsApp.NO_EDITABLE);
        this.formulario.getRadNroControl().setSelected(ConstantsApp.NO_EDITABLE);
        this.formulario.getRadPasaporte().setSelected(ConstantsApp.NO_EDITABLE);
        this.formulario.getRadRasgoFisico().setSelected(ConstantsApp.NO_EDITABLE);
        this.formulario.getTxtvalor().setEditable(ConstantsApp.NO_EDITABLE);
        this.formulario.getBtnBuscar().setEnabled(ConstantsApp.NO_EDITABLE);
        this.formulario.getBtnReiniciar().setEnabled(ConstantsApp.NO_EDITABLE);
        this.formulario.getTabResultados().setEnabled(ConstantsApp.NO_EDITABLE);
    }
    
    public void habilitarFormulario() throws ExcepcionComponenteNulo{
        this.limpiarFormulario();
        this.limpiarJTable();
        this.resaltarCampos();
        this.formulario.getTxtvalor().setEditable(ConstantsApp.EDITABLE);
        this.formulario.getTxtvalor().setEnabled(ConstantsApp.EDITABLE);
        this.formulario.getBtnBuscar().setEnabled(ConstantsApp.EDITABLE);
        this.formulario.getBtnReiniciar().setEnabled(ConstantsApp.EDITABLE);
        this.formulario.getTabResultados().setEnabled(ConstantsApp.EDITABLE);
    }
    
    public void limpiarFormulario(){
        this.formulario.getTxtvalor().setText(ConstantsApp.INICIALIZAR_STRING);
    }
    
    public void limpiarJTable(){
        this.formulario.getTabResultados().setModel(new DefaultTableModel());
    }
    
}
