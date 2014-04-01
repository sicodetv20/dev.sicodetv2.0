/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import ve.com.fsjv.devsicodetv.utils.exceptions.ExcepcionCampoVacio;
import ve.com.fsjv.devsicodetv.utils.others.ConstantsApp;
import ve.com.fsjv.devsicodetv.utils.others.Utils;
import ve.com.fsjv.devsicodetv.views.FichaDetenidoDialog;
import ve.com.fsjv.devsicodetv.views.GaleriaFotosDialog;

/**
 *
 * @author Juan
 */
public class GaleriaFotosManager implements ActionListener {
    private GaleriaFotosDialog formulario;
    private Utils procesos;
    private List<BufferedImage> imagenesGaleria;
    private int indice;
    
    public GaleriaFotosManager(List<BufferedImage> imagenes) throws ExcepcionCampoVacio{
        this.formulario = new GaleriaFotosDialog(null, true);
        this.procesos = new Utils();
        this.imagenesGaleria = imagenes;
        
        this.formulario.getBtnPrimero().addActionListener(this);
        this.formulario.getBtnAtras().addActionListener(this);
        this.formulario.getBtnSiguiente().addActionListener(this);
        this.formulario.getBtnUltima().addActionListener(this);
        this.formulario.setTitle(this.procesos.cargarMembreteBarraTitulo(ConstantsApp.ACRONIMO_MODULO_FICHA_DETENIDO, "Administrador", ConstantsApp.TITULO_COMPLETO));
        this.formulario.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.indice = 0;
        colocarImagen();
        this.formulario.setVisible(true);
    }

    private void colocarImagen(){
        System.out.println(indice);
        validarIndice();
        if(this.imagenesGaleria.get(indice)!=null){
            this.formulario.getFotoPanel().setIcon(new ImageIcon(this.imagenesGaleria.get(indice)));
        }
    }
    private void validarIndice(){
        this.formulario.getBtnPrimero().setEnabled(true);
        this.formulario.getBtnAtras().setEnabled(true);
        this.formulario.getBtnUltima().setEnabled(true);
        this.formulario.getBtnSiguiente().setEnabled(true);
        if(this.indice==0){
            this.formulario.getBtnPrimero().setEnabled(false);
            this.formulario.getBtnAtras().setEnabled(false);
        }
        if(this.indice==imagenesGaleria.size()-1){
            this.formulario.getBtnUltima().setEnabled(false);
            this.formulario.getBtnSiguiente().setEnabled(false);
        }
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.formulario.getBtnPrimero()){
            this.indice = 0;
            colocarImagen();
        }else if(e.getSource()==this.formulario.getBtnAtras()){
            this.indice--;
            colocarImagen();
        }else if(e.getSource()==this.formulario.getBtnSiguiente()){
            this.indice++;
            colocarImagen();
        }else if(e.getSource()==this.formulario.getBtnUltima()){
            this.indice = imagenesGaleria.size()-1;
            colocarImagen();
        }
    }
}
