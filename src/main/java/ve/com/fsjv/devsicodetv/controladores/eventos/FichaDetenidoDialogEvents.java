/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.controladores.eventos;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.exceptions.ExcepcionComponenteNulo;
import ve.com.fsjv.devsicodetv.utils.others.ConstantsApp;
import ve.com.fsjv.devsicodetv.utils.others.Utils;
import ve.com.fsjv.devsicodetv.views.FichaDetenidoDialog;

/**
 *
 * @author FAMILIA-SJ
 */
public class FichaDetenidoDialogEvents {
    private FichaDetenidoDialog formulario;
    private Utils procesos;
    
    public FichaDetenidoDialogEvents(FichaDetenidoDialog formulario, Utils procesos){
        this.formulario = formulario;
        this.procesos = procesos;
    }
    
    public void cargarDialogBlanco(){
        this.formulario.getTxtCodigoInterno().setText("");
        this.formulario.getTxtCedulaIdentidad().setText("");
        this.formulario.getTxtNombres().setText("");
        this.formulario.getTxtApellidos().setText("");
        this.formulario.getTxtAlias().setText("");
        this.formulario.getCmbSexo().setSelectedIndex(0);
        this.formulario.getTxtPasaporte().setText("");
        this.formulario.getCmbNacionalidad().setSelectedIndex(0);
        this.formulario.getTxtReligion().setText("");
        this.formulario.getCmbEstadoCivil().setSelectedIndex(0);
        this.formulario.getCmbAnio().setSelectedIndex(0);
        this.formulario.getCmbMes().setSelectedIndex(0);
        this.formulario.getCmbDia().setSelectedIndex(0);
        this.formulario.getTxtEdad().setText("");
        this.formulario.getTxtLugarNacimiento().setText("");
        this.formulario.getTxtDocumentoAnterior().setText("");
        this.formulario.getCmbReservista().setSelectedIndex(0);
        this.formulario.getCmbColorPiel().setSelectedIndex(0);
        this.formulario.getCmbColorCabello().setSelectedIndex(0);
        this.formulario.getCmbColorOjos().setSelectedIndex(0);
        this.formulario.getCmbTipoNariz().setSelectedIndex(0);
        this.formulario.getTxtEstatura().setText("");
        this.formulario.getCmbLentes().setSelectedIndex(0);
        this.formulario.getCmbContextura().setSelectedIndex(0);
        this.formulario.getTxtCicatriz().setText("");
        this.formulario.getTxtSeniasParticulares().setText("");
        this.formulario.getTxtDireccionActual().setText("");
        this.formulario.getTxtDireccionAnterior().setText("");
        this.formulario.getTxtDireccionEmergencia().setText("");
        this.formulario.getTxtTelefonoCelular().setText("");
        this.formulario.getTxtTelefonoEmergencia().setText("");
        this.formulario.getTxtTelefonoHabitacion().setText("");
        this.formulario.getCmbVivienda().setSelectedIndex(0);
        this.formulario.getCmbTipoVivienda().setSelectedIndex(0);
        this.formulario.getCmbGradoInstruccion().setSelectedIndex(0);
        this.formulario.getTxtProfesion().setText("");
    }
    
    public void aplicarReadOnly(boolean valor, int tipo) {
        if (tipo == ConstantsApp.READONLY_DEFAULT) {
            this.cargarDialogBlanco();
        }
        this.formulario.getTxtCedulaIdentidad().setEditable(valor);
        this.formulario.getTxtNombres().setEditable(valor);
        this.formulario.getTxtApellidos().setEditable(valor);
        this.formulario.getTxtAlias().setEditable(valor);
        this.formulario.getCmbSexo().setEnabled(valor);
        this.formulario.getCmbAnio().setEnabled(valor);
        this.formulario.getCmbMes().setEnabled(valor);
        this.formulario.getCmbDia().setEnabled(valor);
        this.formulario.getTxtPasaporte().setEditable(valor);
        this.formulario.getCmbNacionalidad().setEnabled(valor);
        this.formulario.getTxtReligion().setEditable(valor);
        this.formulario.getCmbEstadoCivil().setEnabled(valor);
        this.formulario.getTxtLugarNacimiento().setEditable(valor);
        this.formulario.getTxtDocumentoAnterior().setEditable(valor);
        this.formulario.getCmbReservista().setEnabled(valor);
        this.formulario.getCmbColorPiel().setEnabled(valor);;
        this.formulario.getCmbColorCabello().setEnabled(valor);
        this.formulario.getCmbColorOjos().setEnabled(valor);
        this.formulario.getCmbTipoNariz().setEnabled(valor);
        this.formulario.getTxtEstatura().setEditable(valor);
        this.formulario.getCmbLentes().setEnabled(valor);
        this.formulario.getCmbContextura().setEnabled(valor);
        this.formulario.getTxtCicatriz().setEditable(valor);
        this.formulario.getTxtSeniasParticulares().setEditable(valor);
        this.formulario.getTxtDireccionActual().setEditable(valor);
        this.formulario.getTxtDireccionAnterior().setEditable(valor);
        this.formulario.getTxtDireccionEmergencia().setEditable(valor);;
        this.formulario.getTxtTelefonoCelular().setEditable(valor);
        this.formulario.getTxtTelefonoEmergencia().setEditable(valor);
        this.formulario.getTxtTelefonoHabitacion().setEditable(valor);
        this.formulario.getCmbVivienda().setEnabled(valor);
        this.formulario.getCmbTipoVivienda().setEnabled(valor);
        this.formulario.getCmbGradoInstruccion().setEnabled(valor);
        this.formulario.getTxtProfesion().setEditable(valor);
    }
    
    public void iniciarCampos(){
        this.cargarDialogBlanco();
        this.formulario.getTxtCodigoInterno().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtCedulaIdentidad().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtNombres().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtApellidos().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtAlias().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtPasaporte().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtReligion().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtCodigoInterno().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getCmbSexo().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getCmbNacionalidad().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getCmbEstadoCivil().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getCmbAnio().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getCmbMes().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getCmbDia().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getCmbColorCabello().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getCmbColorPiel().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getCmbTipoNariz().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getCmbLentes().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getCmbColorOjos().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getCmbContextura().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getCmbVivienda().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getCmbTipoVivienda().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getCmbGradoInstruccion().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtEdad().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtAnio().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtCicatriz().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtSeniasParticulares().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtLugarNacimiento().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtDocumentoAnterior().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtTelefonoCelular().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtTelefonoHabitacion().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtTelefonoEmergencia().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtEstatura().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtProfesion().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtDireccionAnterior().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtDireccionActual().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        this.formulario.getTxtDireccionEmergencia().setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
        
        this.formulario.getTxtCodigoInterno().setBackground(Color.white);
        this.formulario.getTxtCedulaIdentidad().setBackground(Color.white);
        this.formulario.getTxtNombres().setBackground(Color.white);
        this.formulario.getTxtApellidos().setBackground(Color.white);
        this.formulario.getTxtAlias().setBackground(Color.white);
        this.formulario.getTxtPasaporte().setBackground(Color.white);
        this.formulario.getTxtReligion().setBackground(Color.white);
        this.formulario.getTxtCodigoInterno().setBackground(Color.white);
        this.formulario.getCmbSexo().setBackground(Color.white);
        this.formulario.getCmbNacionalidad().setBackground(Color.white);
        this.formulario.getCmbEstadoCivil().setBackground(Color.white);
        this.formulario.getCmbAnio().setBackground(Color.white);
        this.formulario.getCmbMes().setBackground(Color.white);
        this.formulario.getCmbDia().setBackground(Color.white);
        this.formulario.getCmbColorCabello().setBackground(Color.white);
        this.formulario.getCmbColorPiel().setBackground(Color.white);
        this.formulario.getCmbTipoNariz().setBackground(Color.white);
        this.formulario.getCmbLentes().setBackground(Color.white);
        this.formulario.getCmbColorOjos().setBackground(Color.white);
        this.formulario.getCmbContextura().setBackground(Color.white);
        this.formulario.getCmbVivienda().setBackground(Color.white);
        this.formulario.getCmbTipoVivienda().setBackground(Color.white);
        this.formulario.getCmbGradoInstruccion().setBackground(Color.white);
        this.formulario.getTxtEdad().setBackground(Color.white);
        this.formulario.getTxtAnio().setBackground(Color.white);
        this.formulario.getTxtCicatriz().setBackground(Color.white);
        this.formulario.getTxtSeniasParticulares().setBackground(Color.white);
        this.formulario.getTxtLugarNacimiento().setBackground(Color.white);
        this.formulario.getTxtDocumentoAnterior().setBackground(Color.white);
        this.formulario.getTxtTelefonoCelular().setBackground(Color.white);
        this.formulario.getTxtTelefonoHabitacion().setBackground(Color.white);
        this.formulario.getTxtTelefonoEmergencia().setBackground(Color.white);
        this.formulario.getTxtEstatura().setBackground(Color.white);
        this.formulario.getTxtProfesion().setBackground(Color.white);
        this.formulario.getTxtDireccionAnterior().setBackground(Color.white);
        this.formulario.getTxtDireccionActual().setBackground(Color.white);
        this.formulario.getTxtDireccionEmergencia().setBackground(Color.white);
    }
    
    public void resaltarCampos() throws ExcepcionComponenteNulo{
        this.formulario.setTxtCodigoInterno(this.procesos.resaltarCampoRequerido(this.formulario.getTxtCodigoInterno()));
        this.formulario.setTxtNombres(this.procesos.resaltarCampoRequerido(this.formulario.getTxtNombres()));
        this.formulario.setTxtApellidos(this.procesos.resaltarCampoRequerido(this.formulario.getTxtApellidos()));
        this.formulario.setTxtLugarNacimiento(this.procesos.resaltarCampoRequerido(this.formulario.getTxtLugarNacimiento()));
        this.formulario.setCmbSexo(this.procesos.resaltarCampoRequerido(this.formulario.getCmbSexo()));
        this.formulario.setCmbAnio(this.procesos.resaltarCampoRequerido(this.formulario.getCmbAnio()));
        this.formulario.setCmbMes(this.procesos.resaltarCampoRequerido(this.formulario.getCmbMes()));
        this.formulario.setCmbDia(this.procesos.resaltarCampoRequerido(this.formulario.getCmbDia()));
        this.formulario.setTxtEdad(this.procesos.resaltarCampoRequerido(this.formulario.getTxtEdad()));
        this.formulario.setCmbNacionalidad(this.procesos.resaltarCampoRequerido(this.formulario.getCmbNacionalidad()));
        this.formulario.setCmbColorCabello(this.procesos.resaltarCampoRequerido(this.formulario.getCmbColorCabello()));
        this.formulario.setCmbColorOjos(this.procesos.resaltarCampoRequerido(this.formulario.getCmbColorOjos()));
        this.formulario.setCmbColorPiel(this.procesos.resaltarCampoRequerido(this.formulario.getCmbColorPiel()));
        this.formulario.setCmbContextura(this.procesos.resaltarCampoRequerido(this.formulario.getCmbContextura()));
        this.formulario.setCmbTipoNariz(this.procesos.resaltarCampoRequerido(this.formulario.getCmbTipoNariz()));
        this.formulario.setTxtEstatura(this.procesos.resaltarCampoRequerido(this.formulario.getTxtEstatura()));
        this.formulario.setCmbEstadoCivil(this.procesos.resaltarCampoRequerido(this.formulario.getCmbEstadoCivil()));
    }
    
    public void iniciarBotones(){
        this.aplicarReadOnly(false, ConstantsApp.READONLY_DEFAULT);
        this.formulario.getBtnBuscar().setEnabled(true);
        this.formulario.getBtnNuevo().setEnabled(true);
        
        this.formulario.getBtnGuardar().setEnabled(false);
        this.formulario.getBtnEditar().setEnabled(false);
        this.formulario.getBtnBorrar().setEnabled(false);
        this.formulario.getBtnAgregarCausa().setEnabled(false);
        this.formulario.getBtnCelda().setEnabled(false);
        this.formulario.getBtnCancelar().setEnabled(false);
        this.formulario.getBtnImprimir().setEnabled(false);
        this.formulario.getBtnEvidencias().setEnabled(false);
        this.formulario.getBtnHuellas().setEnabled(false);
        
        this.formulario.getBtnCamara().setEnabled(false);
        this.formulario.getBtnVerFoto().setEnabled(false);
        this.formulario.getBtnVerHistoriales().setEnabled(false);
        this.formulario.getBtnVerUltimosAgregados().setEnabled(false);
        this.formulario.getBtnGaleria().setEnabled(false);
        
    }
    
    public void eventoGuardar(int tipo) throws ExcepcionComponenteNulo{
        this.resaltarCampos();
        this.aplicarReadOnly(true, tipo);
        this.formulario.getBtnBuscar().setEnabled(false);
        this.formulario.getBtnNuevo().setEnabled(false);
        
        this.formulario.getBtnGuardar().setEnabled(true);
        this.formulario.getBtnEditar().setEnabled(false);
        this.formulario.getBtnBorrar().setEnabled(false);
        this.formulario.getBtnAgregarCausa().setEnabled(false);
        this.formulario.getBtnCelda().setEnabled(false);
        this.formulario.getBtnCancelar().setEnabled(true);
        this.formulario.getBtnImprimir().setEnabled(false);
        this.formulario.getBtnEvidencias().setEnabled(false);
        this.formulario.getBtnHuellas().setEnabled(false);
        
        this.formulario.getBtnCamara().setEnabled(false);
        this.formulario.getBtnVerFoto().setEnabled(false);
        this.formulario.getBtnVerHistoriales().setEnabled(false);
        this.formulario.getBtnVerUltimosAgregados().setEnabled(false);
        this.formulario.getBtnGaleria().setEnabled(false);
    }
    
    public void eventoCancelar(){
        this.iniciarCampos();
        this.iniciarBotones();
    }
    
    public void eventoBuscar() throws ExcepcionComponenteNulo{
        this.resaltarCampos();
        this.aplicarReadOnly(true, ConstantsApp.READONLY_DATA);
        this.formulario.getBtnBuscar().setEnabled(false);
        this.formulario.getBtnNuevo().setEnabled(false);
        
        this.formulario.getBtnGuardar().setEnabled(false);
        this.formulario.getBtnEditar().setEnabled(true);
        this.formulario.getBtnBorrar().setEnabled(true);
        this.formulario.getBtnAgregarCausa().setEnabled(false);
        this.formulario.getBtnCelda().setEnabled(false);
        this.formulario.getBtnCancelar().setEnabled(true);
        this.formulario.getBtnImprimir().setEnabled(true);
        this.formulario.getBtnEvidencias().setEnabled(false);
        this.formulario.getBtnHuellas().setEnabled(false);
        
        this.formulario.getBtnCamara().setEnabled(true);
        this.formulario.getBtnVerFoto().setEnabled(true);
        this.formulario.getBtnVerHistoriales().setEnabled(true);
        this.formulario.getBtnVerUltimosAgregados().setEnabled(true);
        this.formulario.getBtnGaleria().setEnabled(true);
    
    }
    
    
}
