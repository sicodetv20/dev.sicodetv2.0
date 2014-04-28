/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.controladores.eventos;

import java.util.ArrayList;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utils.others.ConstantsApp;
import ve.com.fsjv.devsicodetv.utils.others.Utils;
import ve.com.fsjv.devsicodetv.views.FichaDetenidoDialog;

/**
 *
 * @author FAMILIA-SJ
 */
public class FichaDetenidoDialogValidates {
    private FichaDetenidoDialog formulario;
    private Utils procesos;
    
    public FichaDetenidoDialogValidates(FichaDetenidoDialog formulario, Utils procesos){
        this.formulario = formulario;
        this.procesos = procesos;
    }
    
    public ArrayList<String> validarCampos(){
        ArrayList<String> listaErrores = new ArrayList<String>();
        //arreglo de resultado de la validacion
        String[] arv;
        String resultado = ConstantsApp.INICIALIZAR_STRING;
        resultado = this.procesos.validarCampo(this.formulario.getTxtCodigoInterno(), ConstantsApp.TIPO_VALIDACION_VACIO, "Codigo Interno", ConstantsApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        if(!this.formulario.getTxtCedulaIdentidad().getText().trim().equals("")){
            resultado = this.procesos.validarLengthCampo(this.formulario.getTxtCedulaIdentidad(), ConstantsApp.TIPO_VALIDACION_MAXLENGTH_CEDULA, "Cedula de Identidad", ConstantsApp.CAMPO_NORMAL);
            if(resultado != null){
                listaErrores.add(resultado);
            }
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getTxtNombres(), ConstantsApp.TIPO_VALIDACION_VACIO, "Nombres", ConstantsApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        if(!this.formulario.getTxtNombres().getText().trim().equals("")){
            resultado = this.procesos.validarLengthCampo(this.formulario.getTxtNombres(), ConstantsApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Nombres", ConstantsApp.CAMPO_REQUERIDO);
            if(resultado != null){
                listaErrores.add(resultado);
            }
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getTxtApellidos(), ConstantsApp.TIPO_VALIDACION_VACIO, "Apellidos", ConstantsApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        if(!this.formulario.getTxtApellidos().getText().trim().equals("")){
            resultado = this.procesos.validarLengthCampo(this.formulario.getTxtApellidos(), ConstantsApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Apellidos", ConstantsApp.CAMPO_REQUERIDO);
            if(resultado != null){
                listaErrores.add(resultado);
            }
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getTxtLugarNacimiento(), ConstantsApp.TIPO_VALIDACION_VACIO, "Lugar de Nacimiento", ConstantsApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        if(!this.formulario.getTxtLugarNacimiento().getText().trim().equals("")){
            resultado = this.procesos.validarLengthCampo(this.formulario.getTxtLugarNacimiento(), ConstantsApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Lugar Nacimiento", ConstantsApp.CAMPO_REQUERIDO);
            if(resultado != null){
                listaErrores.add(resultado);
            }
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getTxtEdad(), ConstantsApp.TIPO_VALIDACION_VACIO, "Edad", ConstantsApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        resultado = this.procesos.validarCampo(this.formulario.getTxtEstatura(), ConstantsApp.TIPO_VALIDACION_DECIMAL, "Estatura", ConstantsApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbSexo(), ConstantsApp.TIPO_VALIDACION_VACIO, "Sexo", ConstantsApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbNacionalidad(), ConstantsApp.TIPO_VALIDACION_VACIO, "Nacionalidad", ConstantsApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbEstadoCivil(), ConstantsApp.TIPO_VALIDACION_VACIO, "Estado Civil", ConstantsApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbColorOjos(), ConstantsApp.TIPO_VALIDACION_VACIO, "Color de Ojos", ConstantsApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbColorPiel(), ConstantsApp.TIPO_VALIDACION_VACIO, "Color de Piel", ConstantsApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbColorCabello(), ConstantsApp.TIPO_VALIDACION_VACIO, "Color de Cabello", ConstantsApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbTipoNariz(), ConstantsApp.TIPO_VALIDACION_VACIO, "Tipo de Nariz", ConstantsApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbContextura(), ConstantsApp.TIPO_VALIDACION_VACIO, "Contextura", ConstantsApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbAnio(), ConstantsApp.TIPO_VALIDACION_VACIO, "Año (Fecha de Nacimiento)", ConstantsApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbMes(), ConstantsApp.TIPO_VALIDACION_VACIO, "Mes (Fecha de Nacimiento)", ConstantsApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbDia(), ConstantsApp.TIPO_VALIDACION_VACIO, "Dia (Fecha de Nacimiento)", ConstantsApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarLengthCampo(this.formulario.getTxtAlias(), ConstantsApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Alias", ConstantsApp.CAMPO_NORMAL);
            if(resultado != null){
                listaErrores.add(resultado);
            }
        
        resultado = this.procesos.validarLengthCampo(this.formulario.getTxtPasaporte(), ConstantsApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Pasaporte", ConstantsApp.CAMPO_NORMAL);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarLengthCampo(this.formulario.getTxtReligion(), ConstantsApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Religion", ConstantsApp.CAMPO_NORMAL);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        
        resultado = this.procesos.validarLengthCampo(this.formulario.getTxtDocumentoAnterior(), ConstantsApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Docu. Anterior", ConstantsApp.CAMPO_NORMAL);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarLengthCampo(this.formulario.getTxtCicatriz(), ConstantsApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Cicatriz", ConstantsApp.CAMPO_NORMAL);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarLengthCampo(this.formulario.getTxtSeniasParticulares(), ConstantsApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Señas Part.", ConstantsApp.CAMPO_NORMAL);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarLengthCampo(this.formulario.getTxtProfesion(), ConstantsApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Profesion", ConstantsApp.CAMPO_NORMAL);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getTxtTelefonoCelular(), ConstantsApp.TIPO_VALIDACION_TELEFONO, "Telefono Celular", ConstantsApp.CAMPO_NORMAL);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getTxtTelefonoEmergencia(), ConstantsApp.TIPO_VALIDACION_TELEFONO, "Telefono de Emergencia", ConstantsApp.CAMPO_NORMAL);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getTxtTelefonoHabitacion(), ConstantsApp.TIPO_VALIDACION_TELEFONO, "Telefono de Habitacion", ConstantsApp.CAMPO_NORMAL);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        return listaErrores;
    }
    
}
