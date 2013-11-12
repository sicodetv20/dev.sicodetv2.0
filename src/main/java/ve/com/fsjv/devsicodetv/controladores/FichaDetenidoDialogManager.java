package ve.com.fsjv.devsicodetv.controladores;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionCampoVacio;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionComponenteNulo;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionFecha;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionFechaCompleta;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionHora;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionMaxLength;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionMinLength;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionNumeroInvalido;
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
        //this.formulario = (FichaDetenidoDialog) this.eventos.aplicarReadOnly(ConstantesApp.ACRONIMO_MODULO_FICHA_DETENIDO, false, ConstantesApp.READONLY_DEFAULT);
        
        this.formulario.setTxtCodigoInterno(this.procesos.resaltarCampoRequerido(this.formulario.getTxtCodigoInterno()));
        this.formulario.setTxtCedulaIdentidad(this.procesos.resaltarCampoRequerido(this.formulario.getTxtCedulaIdentidad()));
        this.formulario.setTxtNombres(this.procesos.resaltarCampoRequerido(this.formulario.getTxtNombres()));
        this.formulario.setTxtApellidos(this.procesos.resaltarCampoRequerido(this.formulario.getTxtApellidos()));
        this.formulario.setTxtLugarNacimiento(this.procesos.resaltarCampoRequerido(this.formulario.getTxtLugarNacimiento()));
        this.formulario.setCmbSexo(this.procesos.resaltarCampoRequerido(this.formulario.getCmbSexo()));
        this.formulario.setCmbAnio(this.procesos.resaltarCampoRequerido(this.formulario.getCmbAnio()));
        this.formulario.setCmbMes(this.procesos.resaltarCampoRequerido(this.formulario.getCmbMes()));
        this.formulario.setCmbDia(this.procesos.resaltarCampoRequerido(this.formulario.getCmbDia()));
        this.formulario.setTxtEdad(this.procesos.resaltarCampoRequerido(this.formulario.getTxtEdad()));
        this.formulario.setCmbNacionalidad(this.procesos.resaltarCampoRequerido(this.formulario.getCmbNacionalidad()));
        this.formulario.setCmbColorCabello(this.procesos.resaltarCampoRequerido(this.formulario.getCmbColorCabello()));
        this.formulario.setCmbColorOjos(this.procesos.resaltarCampoRequerido(this.formulario.getCmbColorOjos()));
        this.formulario.setCmbColorPiel(this.procesos.resaltarCampoRequerido(this.formulario.getCmbColorPiel()));
        this.formulario.setCmbContextura(this.procesos.resaltarCampoRequerido(this.formulario.getCmbContextura()));
        this.formulario.setTxtEstatura(this.procesos.resaltarCampoRequerido(this.formulario.getTxtEstatura()));
        
        this.formulario.getBtnGuardar().addActionListener(this);
        this.formulario.getTxtCedulaIdentidad().addKeyListener(this);
        this.formulario.setTitle(this.procesos.cargarMembreteBarraTitulo(ConstantesApp.ACRONIMO_MODULO_FICHA_DETENIDO, "Administrador", ConstantesApp.TITULO_COMPLETO));
        this.formulario.setSize(1180, 740);
        this.formulario.addKeyListener(this);
        this.formulario.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        
        this.formulario.setVisible(true);
        
        
    }
    
    public ArrayList<String> validarCampos() 
            throws ExcepcionCampoVacio, ExcepcionComponenteNulo, ExcepcionMaxLength, 
            ExcepcionMinLength, ExcepcionFecha, ExcepcionFechaCompleta, ExcepcionHora, ExcepcionNumeroInvalido{
        ArrayList<String> listaErrores = new ArrayList<String>();
        //arreglo de resultado de la validacion
        String[] arv;
        String resultado = ConstantesApp.INICIALIZAR_STRING;
        resultado = this.procesos.validarCampo(this.formulario.getTxtCodigoInterno(), ConstantesApp.TIPO_VALIDACION_VACIO, this.formulario.getTxtCodigoInterno().getText(), "Codigo Interno", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        resultado = this.procesos.validarCampo(this.formulario.getTxtCedulaIdentidad(), ConstantesApp.TIPO_VALIDACION_VACIO, this.formulario.getTxtCedulaIdentidad().getText(), "Cedula de Identidad", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        resultado = this.procesos.validarCampo(this.formulario.getTxtNombres(), ConstantesApp.TIPO_VALIDACION_VACIO, this.formulario.getTxtNombres().getText(), "Nombres", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        resultado = this.procesos.validarCampo(this.formulario.getTxtApellidos(), ConstantesApp.TIPO_VALIDACION_VACIO, this.formulario.getTxtApellidos().getText(), "Apellidos", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        resultado = this.procesos.validarCampo(this.formulario.getTxtLugarNacimiento(), ConstantesApp.TIPO_VALIDACION_VACIO, this.formulario.getTxtLugarNacimiento().getText(), "Lugar de Nacimiento", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        resultado = this.procesos.validarCampo(this.formulario.getTxtEdad(), ConstantesApp.TIPO_VALIDACION_VACIO, this.formulario.getTxtEdad().getText(), "Edad", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        resultado = this.procesos.validarCampo(this.formulario.getTxtEstatura(), ConstantesApp.TIPO_VALIDACION_DECIMAL, this.formulario.getTxtEstatura().getText(), "Estatura", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        return listaErrores;
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.formulario.getBtnGuardar()){
            try {
                ArrayList<String> listaErrores = this.validarCampos();
                String mensaje = ConstantesApp.VALIDACION_EXITOSA;
                String tituloMensaje = ConstantesApp.TITULO_VALIDACION;
                int iconoMensaje = JOptionPane.INFORMATION_MESSAGE;
                if(listaErrores.size() > 0){
                    iconoMensaje = JOptionPane.ERROR_MESSAGE;
                    mensaje = ConstantesApp.VALIDACION_ERROR + "\n";
                    for(int i = 0; i < listaErrores.size(); i ++){
                        mensaje = mensaje + "     -" + listaErrores.get(i) + "\n";
                    }
                }
                JOptionPane.showMessageDialog(this.formulario, mensaje, tituloMensaje, iconoMensaje);
                //JOptionPane.showMessageDialog(this.formulario, "Hi");
            } catch (ExcepcionCampoVacio ex) {
                Logger.getLogger(FichaDetenidoDialogManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExcepcionComponenteNulo ex) {
                Logger.getLogger(FichaDetenidoDialogManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExcepcionMaxLength ex) {
                Logger.getLogger(FichaDetenidoDialogManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExcepcionMinLength ex) {
                Logger.getLogger(FichaDetenidoDialogManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExcepcionFecha ex) {
                Logger.getLogger(FichaDetenidoDialogManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExcepcionFechaCompleta ex) {
                Logger.getLogger(FichaDetenidoDialogManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExcepcionHora ex) {
                Logger.getLogger(FichaDetenidoDialogManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExcepcionNumeroInvalido ex) {
                Logger.getLogger(FichaDetenidoDialogManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void keyTyped(KeyEvent e) {
        if(e.getSource() == this.formulario.getTxtCedulaIdentidad()){
            this.procesos.permitirSoloNumeros(e);
        }
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
