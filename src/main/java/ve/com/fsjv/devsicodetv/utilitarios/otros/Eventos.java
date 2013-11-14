/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.utilitarios.otros;

import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionCampoVacio;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionComponenteNulo;
import ve.com.fsjv.devsicodetv.vistas.FichaDetenidoDialog;

/**
 *
 * @author franklin
 */
public class Eventos {
    
    private FichaDetenidoDialog formFichaDetenido;
    
    public Eventos(){}
    
    public JDialog cargarDialogBlanco(String acronimo) throws ExcepcionCampoVacio, ExcepcionComponenteNulo {
        if (acronimo == null) {
            throw new ExcepcionCampoVacio(ConstantesApp.MENSAJE_CAMPO_VACIO + ConstantesApp.MENSAJE_ACRONIMO_NULO);
        } else {
            if (acronimo.equals(ConstantesApp.ACRONIMO_MODULO_FICHA_DETENIDO)) {
                this.formFichaDetenido = new FichaDetenidoDialog(new JFrame(), true);
                this.formFichaDetenido.getTxtCedulaIdentidad().setText("");
                this.formFichaDetenido.getTxtNombres().setText("");
                this.formFichaDetenido.getTxtApellidos().setText("");
                this.formFichaDetenido.getTxtAlias().setText("");
                this.formFichaDetenido.getCmbSexo().setSelectedIndex(0);
                this.formFichaDetenido.getTxtPasaporte().setText("");
                this.formFichaDetenido.getCmbNacionalidad().setSelectedIndex(0);
                this.formFichaDetenido.getTxtReligion().setText("");
                this.formFichaDetenido.getCmbEstadoCivil().setSelectedIndex(0);
                this.formFichaDetenido.getCmbAnio().setSelectedIndex(0);
   
                
                this.formFichaDetenido.getCmbMes().setSelectedIndex(0);
                this.formFichaDetenido.getCmbDia().setSelectedIndex(0);
                this.formFichaDetenido.getTxtEdad().setText("");
                this.formFichaDetenido.getTxtLugarNacimiento().setText("");
                this.formFichaDetenido.getTxtDocumentoAnterior().setText("");
                this.formFichaDetenido.getCmbReservista().setSelectedIndex(0);
                this.formFichaDetenido.getCmbColorPiel().setSelectedIndex(0);
                this.formFichaDetenido.getCmbColorCabello().setSelectedIndex(0);
                this.formFichaDetenido.getCmbColorOjos().setSelectedIndex(0);
                this.formFichaDetenido.getCmbTipoNariz().setSelectedIndex(0);
                this.formFichaDetenido.getTxtEstatura().setText("");
                this.formFichaDetenido.getCmbLentes().setSelectedIndex(0);
                this.formFichaDetenido.getCmbContextura().setSelectedIndex(0);
                this.formFichaDetenido.getTxtCicatriz().setText("");
                this.formFichaDetenido.getTxtSeniasParticulares().setText("");
                this.formFichaDetenido.getTxtDireccionActual().setText("");
                this.formFichaDetenido.getTxtDireccionAnterior().setText("");
                this.formFichaDetenido.getTxtDireccionEmergencia().setText("");
                this.formFichaDetenido.getTxtTelefonoCelular().setText("");
                this.formFichaDetenido.getTxtTelefonoEmergencia().setText("");
                this.formFichaDetenido.getTxtTelefonoHabitacion().setText("");
                this.formFichaDetenido.getCmbVivienda().setSelectedIndex(0);
                this.formFichaDetenido.getCmbTipoVivienda().setSelectedIndex(0);
                this.formFichaDetenido.getCmbGradoInstruccion().setSelectedIndex(0);
                this.formFichaDetenido.getTxtProfesion().setText("");
                return this.formFichaDetenido;
            } else {
                throw new ExcepcionComponenteNulo(ConstantesApp.MENSAJE_COMPONENTE_NULO);
            }
        }

    }

    public JDialog aplicarReadOnly(String acronimo, boolean valor, int tipo) throws ExcepcionCampoVacio, ExcepcionComponenteNulo {
        if (acronimo == null) {
            throw new ExcepcionCampoVacio(ConstantesApp.MENSAJE_CAMPO_VACIO + ConstantesApp.MENSAJE_ACRONIMO_NULO);
        } else {
            if (acronimo.equals(ConstantesApp.ACRONIMO_MODULO_FICHA_DETENIDO)) {
                this.formFichaDetenido = new FichaDetenidoDialog(new JFrame(), true);
                if (tipo == ConstantesApp.READONLY_DEFAULT) {
                    this.formFichaDetenido = (FichaDetenidoDialog) this.cargarDialogBlanco(acronimo);
                }
                this.formFichaDetenido.getTxtCedulaIdentidad().setEditable(valor);
                this.formFichaDetenido.getTxtNombres().setEditable(valor);
                this.formFichaDetenido.getTxtApellidos().setEditable(valor);
                this.formFichaDetenido.getTxtAlias().setEditable(valor);
                this.formFichaDetenido.getCmbSexo().setEnabled(valor);
                this.formFichaDetenido.getCmbAnio().setEnabled(valor);
                this.formFichaDetenido.getCmbMes().setEnabled(valor);
                this.formFichaDetenido.getCmbDia().setEnabled(valor);
                this.formFichaDetenido.getTxtEdad().setEditable(valor);
                this.formFichaDetenido.getTxtPasaporte().setEditable(valor);
                this.formFichaDetenido.getCmbNacionalidad().setEnabled(valor);
                this.formFichaDetenido.getTxtReligion().setEditable(valor);
                this.formFichaDetenido.getCmbEstadoCivil().setEnabled(valor);
                this.formFichaDetenido.getTxtLugarNacimiento().setEditable(valor);
                this.formFichaDetenido.getTxtDocumentoAnterior().setEditable(valor);
                this.formFichaDetenido.getCmbReservista().setEnabled(valor);
                this.formFichaDetenido.getCmbColorPiel().setEnabled(valor);;
                this.formFichaDetenido.getCmbColorCabello().setEnabled(valor);
                this.formFichaDetenido.getCmbColorOjos().setEnabled(valor);
                this.formFichaDetenido.getCmbTipoNariz().setEnabled(valor);
                this.formFichaDetenido.getTxtEstatura().setEditable(valor);
                this.formFichaDetenido.getCmbLentes().setEnabled(valor);
                this.formFichaDetenido.getCmbContextura().setEnabled(valor);
                this.formFichaDetenido.getTxtCicatriz().setEditable(valor);
                this.formFichaDetenido.getTxtSeniasParticulares().setEditable(valor);
                this.formFichaDetenido.getTxtDireccionActual().setEditable(valor);
                this.formFichaDetenido.getTxtDireccionAnterior().setEditable(valor);
                this.formFichaDetenido.getTxtDireccionEmergencia().setEditable(valor);;
                this.formFichaDetenido.getTxtTelefonoCelular().setEditable(valor);
                this.formFichaDetenido.getTxtTelefonoEmergencia().setEditable(valor);
                this.formFichaDetenido.getTxtTelefonoHabitacion().setEditable(valor);
                this.formFichaDetenido.getCmbVivienda().setEnabled(valor);
                this.formFichaDetenido.getCmbTipoVivienda().setEnabled(valor);
                this.formFichaDetenido.getCmbGradoInstruccion().setEnabled(valor);
                this.formFichaDetenido.getTxtProfesion().setEditable(valor);
                return this.formFichaDetenido;
            } else {
                throw new ExcepcionComponenteNulo(ConstantesApp.MENSAJE_COMPONENTE_NULO);
            }
        }


    }
    
}
