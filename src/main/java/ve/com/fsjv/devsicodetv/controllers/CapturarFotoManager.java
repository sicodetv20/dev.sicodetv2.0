/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.controllers;

import com.github.sarxos.webcam.WebcamResolution;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import ve.com.fsjv.devsicodetv.controladores.eventos.CapturarFotoMethods;
import ve.com.fsjv.devsicodetv.models.FichaDetenido;
import ve.com.fsjv.devsicodetv.utils.exceptions.ExcepcionCampoVacio;
import ve.com.fsjv.devsicodetv.utils.exceptions.ExcepcionComponenteNulo;
import ve.com.fsjv.devsicodetv.utils.others.CamaraThread;
import ve.com.fsjv.devsicodetv.utils.others.ConstantsApp;
import ve.com.fsjv.devsicodetv.utils.others.Utils;
import ve.com.fsjv.devsicodetv.views.CapturarFotoDialog;

/**
 *
 * @author Juan
 */
public class CapturarFotoManager implements ActionListener {

    private CapturarFotoDialog capturarFotoDialog;
    private final Utils procesos;
    private CamaraThread camaraThread;
    private List<BufferedImage> listaImagenes;
    private int detenido;
    private FichaDetenido fichaDetenido;
    private CapturarFotoMethods eventos;
    
    public CapturarFotoManager (FichaDetenido detenido) throws ExcepcionComponenteNulo, ExcepcionCampoVacio {
        this.fichaDetenido = fichaDetenido;
        this.capturarFotoDialog = new CapturarFotoDialog(null, true);
        this.procesos = new Utils();
        this.eventos = new CapturarFotoMethods(this.capturarFotoDialog, this.procesos);
        
        //this.detenido = detenido;
        JOptionPane.showMessageDialog(this.capturarFotoDialog, "id del detenido: " + detenido);
        
        this.capturarFotoDialog.getBtnAceptar().addActionListener(this);
        this.capturarFotoDialog.getBtnCamara().addActionListener(this);
        this.capturarFotoDialog.getBtnCancelar().addActionListener(this);
        this.capturarFotoDialog.getBtnConfiguracion().addActionListener(this);
        this.capturarFotoDialog.getBtnRecapturar().addActionListener(this);
        this.capturarFotoDialog.getBtnZoomIn().addActionListener(this);
        this.capturarFotoDialog.getBtnZoomOut().addActionListener(this);
        
        this.capturarFotoDialog.setTitle(this.procesos.cargarMembreteBarraTitulo(ConstantsApp.ACRONIMO_MODULO_FICHA_DETENIDO, "Administrador", ConstantsApp.TITULO_COMPLETO));
        //this.capturarFotoDialog.setSize(1150, 740);
        this.capturarFotoDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        this.camaraThread = new CamaraThread(capturarFotoDialog, 0, WebcamResolution.VGA.getSize());
        camaraThread.start();
        this.listaImagenes = new ArrayList<BufferedImage>();
        //this.capturarFotoDialog.getBtnCancelar().setVisible(false);
        activarTomarFoto();
        System.out.println("pasa por aqui");
        this.capturarFotoDialog.setVisible(true);
        
    }
    
    private void activarTomarFoto(){
        this.capturarFotoDialog.getBtnCamara().setEnabled(true);
        this.capturarFotoDialog.getBtnAceptar().setEnabled(false);
        this.capturarFotoDialog.getBtnCancelar().setEnabled(true);
        this.capturarFotoDialog.getBtnConfiguracion().setEnabled(true);
        this.capturarFotoDialog.getBtnRecapturar().setEnabled(false);
        this.capturarFotoDialog.getBtnZoomIn().setEnabled(true);
        this.capturarFotoDialog.getBtnZoomOut().setEnabled(true);
    }
    
    private void desactivarTomarFoto(){
        this.capturarFotoDialog.getBtnCamara().setEnabled(false);
        this.capturarFotoDialog.getBtnAceptar().setEnabled(true);
        this.capturarFotoDialog.getBtnCancelar().setEnabled(false);
        this.capturarFotoDialog.getBtnConfiguracion().setEnabled(true);
        this.capturarFotoDialog.getBtnRecapturar().setEnabled(true);
        this.capturarFotoDialog.getBtnZoomIn().setEnabled(false);
        this.capturarFotoDialog.getBtnZoomOut().setEnabled(false);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== this.capturarFotoDialog.getBtnConfiguracion()){
            
        }else if(e.getSource()== this.capturarFotoDialog.getBtnAceptar()){
            this.listaImagenes.add(this.camaraThread.getImagenCamara());
            this.camaraThread.seguirImagen();
            activarTomarFoto();
        }else if(e.getSource()== this.capturarFotoDialog.getBtnCamara()){
            this.camaraThread.detenerImagen();
            desactivarTomarFoto();
        }else if(e.getSource()== this.capturarFotoDialog.getBtnCancelar()){
            try {
                this.camaraThread.detenerImagen();
                new ListaFotosManager(listaImagenes);
                //new GaleriaFotosManager(listaImagenes);
                this.camaraThread.seguirImagen();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource()== this.capturarFotoDialog.getBtnRecapturar()){
            this.camaraThread.seguirImagen();
            activarTomarFoto();
        }else if(e.getSource()== this.capturarFotoDialog.getBtnZoomIn()){
            this.camaraThread.zoomIn();
        }else if(e.getSource()== this.capturarFotoDialog.getBtnZoomOut()){
            this.camaraThread.zoomOut();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
