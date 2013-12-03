/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.controladores.eventos;

import java.util.ArrayList;
import ve.com.fsjv.devsicodetv.utilitarios.otros.ConstantesApp;
import ve.com.fsjv.devsicodetv.utilitarios.otros.Procesos;
import ve.com.fsjv.devsicodetv.vistas.BusquedaDetenidosDialog;

/**
 *
 * @author FAMILIA-SJ
 */
public class BusquedaDetenidosDialogValidates {
    private BusquedaDetenidosDialog formulario;
    private Procesos procesos;
    
    public BusquedaDetenidosDialogValidates(BusquedaDetenidosDialog formulario, Procesos procesos){
        this.formulario = formulario;
        this.procesos = procesos;
    }
    
    public ArrayList<String> validarCampos(){
        ArrayList<String> listaErrores = new ArrayList<String>();
        //arreglo de resultado de la validacion
        String[] arv;
        String resultado = ConstantesApp.INICIALIZAR_STRING;
        resultado = this.procesos.validarCampo(this.formulario.getTxtvalor(), ConstantesApp.TIPO_VALIDACION_VACIO, "Valor de Busqueda", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        return listaErrores;
    }
    
}
