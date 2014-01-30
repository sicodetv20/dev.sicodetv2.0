/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.controladores.eventos;

import java.awt.image.BufferedImage;
import java.util.List;
import ve.com.fsjv.devsicodetv.modelos.FichaDetenido;
import ve.com.fsjv.devsicodetv.utilitarios.otros.Procesos;
import ve.com.fsjv.devsicodetv.vistas.CapturarFotoDialog;

/**
 *
 * @author Juan
 */
public class CapturarFotoMethods {

    private CapturarFotoDialog capturarFotoDialog;
    private Procesos procesos;
    
    public CapturarFotoMethods(CapturarFotoDialog dialog, Procesos procesos) {
        this.capturarFotoDialog = dialog;
        this.procesos = procesos;
    }
    
    public void guardar(List<BufferedImage> imagenes, FichaDetenido ficha){
        
    }
}
