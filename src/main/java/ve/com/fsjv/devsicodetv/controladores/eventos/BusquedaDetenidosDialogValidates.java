/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.controladores.eventos;

import java.util.ArrayList;
import ve.com.fsjv.devsicodetv.utils.others.ConstantsApp;
import ve.com.fsjv.devsicodetv.utils.others.Utils;
import ve.com.fsjv.devsicodetv.views.BusquedaDetenidosDialog;

/**
 *
 * @author FAMILIA-SJ
 */
public class BusquedaDetenidosDialogValidates {
    private BusquedaDetenidosDialog formulario;
    private Utils procesos;
    
    public BusquedaDetenidosDialogValidates(BusquedaDetenidosDialog formulario, Utils procesos){
        this.formulario = formulario;
        this.procesos = procesos;
    }
    
    public ArrayList<String> validarCampos(){
        ArrayList<String> listaErrores = new ArrayList<String>();
        //arreglo de resultado de la validacion
        String[] arv;
        String resultado = ConstantsApp.INICIALIZAR_STRING;
        resultado = this.procesos.validarCampo(this.formulario.getTxtvalor(), ConstantsApp.TIPO_VALIDACION_VACIO, "Valor de Busqueda", ConstantsApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        return listaErrores;
    }
    
}
