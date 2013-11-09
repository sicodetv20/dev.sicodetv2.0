/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionCampoVacio;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionComponenteNulo;
import ve.com.fsjv.devsicodetv.utilitarios.otros.ConstantesApp;
import ve.com.fsjv.devsicodetv.utilitarios.otros.Eventos;
import ve.com.fsjv.devsicodetv.utilitarios.otros.Procesos;
import ve.com.fsjv.devsicodetv.vistas.CapturarFotoDialog;

/**
 *
 * @author Juan
 */
public class CapturarFotoManager implements ActionListener {

    private CapturarFotoDialog capturarFotoDialog;
    private final Procesos procesos;
    private final Eventos eventos;
    
    public CapturarFotoManager () throws ExcepcionComponenteNulo, ExcepcionCampoVacio {
        this.capturarFotoDialog = new CapturarFotoDialog(null, true);
        this.procesos = new Procesos();
        this.eventos = new Eventos();
        
        this.capturarFotoDialog.getBtnAceptar().addActionListener(this);
        this.capturarFotoDialog.getBtnCamara().addActionListener(this);
        this.capturarFotoDialog.getBtnCancelar().addActionListener(this);
        this.capturarFotoDialog.getBtnConfiguracion().addActionListener(this);
        this.capturarFotoDialog.getBtnRecapturar().addActionListener(this);
        this.capturarFotoDialog.getBtnZoomIn().addActionListener(this);
        this.capturarFotoDialog.getBtnZoomOut().addActionListener(this);
        
        this.capturarFotoDialog.setTitle(this.procesos.cargarMembreteBarraTitulo(ConstantesApp.ACRONIMO_MODULO_FICHA_DETENIDO, "Administrador", ConstantesApp.TITULO_COMPLETO));
        //this.capturarFotoDialog.setSize(1150, 740);
        this.capturarFotoDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.capturarFotoDialog.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource());
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String args[]) throws ExcepcionCampoVacio, ExcepcionComponenteNulo {
        new CapturarFotoManager();
    }
}
