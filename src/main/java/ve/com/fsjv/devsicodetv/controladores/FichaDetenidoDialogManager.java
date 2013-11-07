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
import ve.com.fsjv.devsicodetv.utilitarios.otros.Eventos;
import ve.com.fsjv.devsicodetv.utilitarios.otros.Procesos;
import ve.com.fsjv.devsicodetv.vistas.FichaDetenidoDialog;

/**
 *
 * @author franklin
 */
public class FichaDetenidoDialogManager implements ActionListener, KeyListener {
    private FichaDetenidoDialog formulario;
    private Procesos procesos;
    private Eventos eventos;
    
    public FichaDetenidoDialogManager() throws ExcepcionComponenteNulo, ExcepcionCampoVacio {
        this.formulario = new FichaDetenidoDialog(new JFrame(), true);
        this.procesos = new Procesos();
        this.eventos = new Eventos();
        this.formulario = (FichaDetenidoDialog) this.eventos.aplicarReadOnly(ConstantesApp.ACRONIMO_MODULO_FICHA_DETENIDO, false, ConstantesApp.READONLY_DEFAULT);
        this.formulario.setTxtCedulaIdentidad(this.procesos.resaltarCampoRequerido(this.formulario.getTxtCedulaIdentidad()));
        this.formulario.setTxtNombres(this.procesos.resaltarCampoRequerido(this.formulario.getTxtNombres()));
        this.formulario.setTxtApellidos(this.procesos.resaltarCampoRequerido(this.formulario.getTxtApellidos()));
        this.formulario.setTxtFechaNacimiento(this.procesos.resaltarCampoRequerido(this.formulario.getTxtFechaNacimiento()));
        this.formulario.setTxtLugarNacimiento(this.procesos.resaltarCampoRequerido(this.formulario.getTxtLugarNacimiento()));
        this.formulario.setCmbSexo(this.procesos.resaltarCampoRequerido(this.formulario.getCmbSexo()));
        this.formulario.setCmbNacionalidad(this.procesos.resaltarCampoRequerido(this.formulario.getCmbNacionalidad()));
        this.formulario.setCmbColorCabello(this.procesos.resaltarCampoRequerido(this.formulario.getCmbColorCabello()));
        this.formulario.setCmbColorOjos(this.procesos.resaltarCampoRequerido(this.formulario.getCmbColorOjos()));
        this.formulario.setCmbColorPiel(this.procesos.resaltarCampoRequerido(this.formulario.getCmbColorPiel()));
        this.formulario.setCmbContextura(this.procesos.resaltarCampoRequerido(this.formulario.getCmbContextura()));
        this.formulario.setTxtEstatura(this.procesos.resaltarCampoRequerido(this.formulario.getTxtEstatura()));
        this.formulario.getTxtFechaNacimiento().setText(this.procesos.obtenerFechaActual(ConstantesApp.TIPO_VALIDACION_FECHA));
        
        //this.formulario.txtCedulaIdentidad.addKeyListener(this);
        //this.formulario.cmbNacionalidad.addKeyListener(this);
        this.formulario.setTitle(this.procesos.cargarMembreteBarraTitulo(ConstantesApp.ACRONIMO_MODULO_FICHA_DETENIDO, "Administrador", ConstantesApp.TITULO_COMPLETO));
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
                Logger.getLogger(FichaDetenidoDialogManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
