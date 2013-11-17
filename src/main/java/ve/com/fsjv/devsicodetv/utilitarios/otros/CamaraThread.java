/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.utilitarios.otros;

import com.github.sarxos.webcam.Webcam;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import ve.com.fsjv.devsicodetv.vistas.CapturarFotoDialog;

/**
 *
 * @author Juan
 */
public class CamaraThread extends Thread{
    
    private boolean detenerCamara = false;
    private CapturarFotoDialog capturarFotoDialog;
    private Webcam webcam;
    private int zoom = 1;
    private BufferedImage imagenCamara;
    
    public CamaraThread(CapturarFotoDialog capturaFoto, int camaraSeleccionar, Dimension resolucion){
        capturarFotoDialog = capturaFoto;
        webcam = Webcam.getWebcams().get(camaraSeleccionar);
        webcam.setViewSize(resolucion);
        webcam.open();
        /*capturarFotoDialog.getFotoPanel().setSize(resolucion);
        capturarFotoDialog.repaint();*/
        System.out.println(capturarFotoDialog.getFotoPanel().getSize());
    }
    
    public void detenerCam(){
        detenerCamara = true;
    }
    
    public void zoomIn(){
        zoom++;
        if(zoom>1){
            capturarFotoDialog.getBtnZoomOut().setEnabled(true);
        }
    }
    
    public void zoomOut(){
        zoom--;
        if(zoom==1){
            capturarFotoDialog.getBtnZoomOut().setEnabled(false);
        }
    }
    
    @Override
    public void run(){
        while(!detenerCamara){
            try {
                imagenCamara = ImagenUtils.imagenZoomRecortada(webcam.getImage(), zoom);
                System.out.println(imagenCamara);
                //capturarFotoDialog.getFotoPanel().setIcon(new ImageIcon(ImagenUtils.redimensionarImagen(imagenCamara,capturarFotoDialog.getFotoPanel().getWidth(),capturarFotoDialog.getFotoPanel().getHeight())));
                capturarFotoDialog.getFotoPanel().setIcon(new ImageIcon(imagenCamara));
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
                Logger.getLogger(CamaraThread.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
