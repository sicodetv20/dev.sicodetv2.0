/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.controladores.eventos;

import java.awt.image.BufferedImage;
import java.util.List;
import ve.com.fsjv.devsicodetv.models.FichaDetenido;
import ve.com.fsjv.devsicodetv.utils.others.Utils;
import ve.com.fsjv.devsicodetv.views.CapturarFotoDialog;

/**
 *
 * @author Juan
 */
public class CapturarFotoMethods {

    private CapturarFotoDialog capturarFotoDialog;
    private Utils procesos;
    
    public CapturarFotoMethods(CapturarFotoDialog dialog, Utils procesos) {
        this.capturarFotoDialog = dialog;
        this.procesos = procesos;
    }
    
    public void guardar(List<BufferedImage> imagenes, FichaDetenido ficha){
        
    }
}
