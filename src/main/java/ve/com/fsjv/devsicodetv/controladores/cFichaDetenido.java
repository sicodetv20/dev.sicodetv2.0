package ve.com.fsjv.devsicodetv.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionCampoVacio;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionComponenteNulo;
import ve.com.fsjv.devsicodetv.utilitarios.otros.ConstantesApp;
import ve.com.fsjv.devsicodetv.utilitarios.otros.Procesos;
import ve.com.fsjv.devsicodetv.vistas.vFichaDetenido;

/**
 *
 * @author franklin
 */
public class cFichaDetenido implements ActionListener, KeyListener {
    private vFichaDetenido formulario;
    private Procesos procesos;
    
    public cFichaDetenido() throws ExcepcionComponenteNulo, ExcepcionCampoVacio {
        this.formulario = new vFichaDetenido(new JFrame(), true);
        this.procesos = new Procesos();
        this.formulario = (vFichaDetenido) this.procesos.aplicarReadOnly(ConstantesApp.ACRONIMO_MODULO_FICHA_DETENIDO, false, ConstantesApp.READONLY_DEFAULT);
        this.formulario.txtCedulaIdentidad = this.procesos.resaltarCampoRequerido(this.formulario.txtCedulaIdentidad);
        this.formulario.txtNombres = this.procesos.resaltarCampoRequerido(this.formulario.txtNombres);
        this.formulario.txtApellidos = this.procesos.resaltarCampoRequerido(this.formulario.txtApellidos);
        this.formulario.txtFechaNacimiento = this.procesos.resaltarCampoRequerido(this.formulario.txtFechaNacimiento);
        this.formulario.txtFechaNacimiento = this.procesos.resaltarCampoRequerido(this.formulario.txtFechaNacimiento);
        this.formulario.txtLugarNacimiento = this.procesos.resaltarCampoRequerido(this.formulario.txtLugarNacimiento);
        this.formulario.cmbSexo = this.procesos.resaltarCampoRequerido(this.formulario.cmbSexo);
        this.formulario.cmbNacionalidad = this.procesos.resaltarCampoRequerido(this.formulario.cmbNacionalidad);
        this.formulario.cmbColorCabello = this.procesos.resaltarCampoRequerido(this.formulario.cmbColorCabello);
        this.formulario.cmbColorOjos = this.procesos.resaltarCampoRequerido(this.formulario.cmbColorOjos);
        this.formulario.cmbColorPiel = this.procesos.resaltarCampoRequerido(this.formulario.cmbColorPiel);
        this.formulario.cmbContextura = this.procesos.resaltarCampoRequerido(this.formulario.cmbContextura);
        this.formulario.txtEstatura = this.procesos.resaltarCampoRequerido(this.formulario.txtEstatura);
        
        
        
        //this.formulario.txtCedulaIdentidad.addKeyListener(this);
        //this.formulario.cmbNacionalidad.addKeyListener(this);
        this.formulario.setSize(1150, 740);
        this.formulario.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.formulario.setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent e) {
        
    }

    public void keyTyped(KeyEvent e) {
        
    }

    public void keyPressed(KeyEvent e) {
        
    }
    
    public void keyReleased(KeyEvent e) {
        if(this.procesos != null){
            this.procesos.deshabilitarTeclas(e);
        }else{
            try {
                throw new ExcepcionComponenteNulo(ConstantesApp.MENSAJE_CLASE_PROCESOS_NULA);
            } catch (ExcepcionComponenteNulo ex) {
                Logger.getLogger(cFichaDetenido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
