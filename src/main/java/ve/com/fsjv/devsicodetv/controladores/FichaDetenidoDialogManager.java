package ve.com.fsjv.devsicodetv.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        this.formulario.getBtnGuardar().addActionListener(this);
        
        //this.formulario.getTxtCedulaIdentidad().setText("1");
        //this.formulario.getTxtCodigoInterno().setText("DEV5");
        //this.formulario.getTxtNombres().setText("1");
        
        //this.formulario.txtCedulaIdentidad.addKeyListener(this);
        //this.formulario.cmbNacionalidad.addKeyListener(this);
        this.formulario.setTitle(this.procesos.cargarMembreteBarraTitulo(ConstantesApp.ACRONIMO_MODULO_FICHA_DETENIDO, "Administrador", ConstantesApp.TITULO_COMPLETO));
        this.formulario.setSize(1150, 740);
        this.formulario.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.formulario.setVisible(true);
        
        
    }
    
    public ArrayList<String> validarCampos() 
            throws ExcepcionCampoVacio, ExcepcionComponenteNulo, ExcepcionMaxLength, 
            ExcepcionMinLength, ExcepcionFecha, ExcepcionFechaCompleta, ExcepcionHora, ExcepcionNumeroInvalido{
        ArrayList<String> listaErrores = new ArrayList<String>();
        //arreglo de resultado de la validacion
        String[] arvJTextField;
        if(this.formulario.getTxtCodigoInterno().getText().isEmpty()){
            this.formulario.setTxtCodigoInterno(this.procesos.validarCampo(this.formulario.getTxtCodigoInterno(), ConstantesApp.TIPO_VALIDACION_VACIO, "txtCodigoInterno", this.formulario.getTxtCodigoInterno().getText().trim()));
            if(this.formulario.getTxtCodigoInterno().getText() != null){
                listaErrores.add(this.formulario.getTxtCodigoInterno().getText());
                this.formulario.getTxtCodigoInterno().setText("");
            }
        }
        if(this.formulario.getTxtCedulaIdentidad().getText().isEmpty()){
            this.formulario.setTxtCedulaIdentidad(this.procesos.validarCampo(this.formulario.getTxtCedulaIdentidad(), ConstantesApp.TIPO_VALIDACION_VACIO, "txtCedulaIdentidad", this.formulario.getTxtCedulaIdentidad().getText().trim()));
            if(this.formulario.getTxtCedulaIdentidad().getText() != null){
                listaErrores.add(this.formulario.getTxtCedulaIdentidad().getText());
                this.formulario.getTxtCedulaIdentidad().setText("");
            }
        }else{
            this.formulario.setTxtCedulaIdentidad(this.procesos.validarCampo(this.formulario.getTxtCedulaIdentidad(), ConstantesApp.TIPO_VALIDACION_MINLENGTH, "txtCedulaIdentidad", this.formulario.getTxtCedulaIdentidad().getText().trim()));
            arvJTextField = this.formulario.getTxtCedulaIdentidad().getText().split(ConstantesApp.CONCATENADOR);
            if(arvJTextField.length > 1){
                if(arvJTextField[1] != null || !arvJTextField[1].isEmpty()){
                   this.formulario.getTxtCedulaIdentidad().setText(arvJTextField[0]);
                    listaErrores.add(arvJTextField[1]);
                }else{
                    this.formulario.getTxtCedulaIdentidad().setText(arvJTextField[0]);
                }
            }
        }
        if(this.formulario.getTxtNombres().getText().isEmpty()){
            this.formulario.setTxtNombres(this.procesos.validarCampo(this.formulario.getTxtNombres(), ConstantesApp.TIPO_VALIDACION_VACIO, "txtNombres", this.formulario.getTxtNombres().getText().trim()));
            if(!this.formulario.getTxtNombres().getText().isEmpty()){
                listaErrores.add(this.formulario.getTxtNombres().getText());
                this.formulario.getTxtNombres().setText("");
            }
        }else{
            
            this.formulario.setTxtNombres(this.procesos.validarCampo(this.formulario.getTxtNombres(), ConstantesApp.TIPO_VALIDACION_MINLENGTH, "txtNombres", this.formulario.getTxtNombres().getText().trim()));
            arvJTextField = this.formulario.getTxtNombres().getText().split(ConstantesApp.CONCATENADOR);
            if(arvJTextField.length > 1){
                if(arvJTextField[1] != null || !arvJTextField[1].isEmpty()){
                   this.formulario.getTxtNombres().setText(arvJTextField[0]);
                    listaErrores.add(arvJTextField[1]);
                }else{
                    this.formulario.getTxtNombres().setText(arvJTextField[0]);
                }
            }
            
            this.formulario.setTxtNombres(this.procesos.validarCampo(this.formulario.getTxtNombres(), ConstantesApp.TIPO_VALIDACION_MAXLENGTH, "txtNombres", this.formulario.getTxtNombres().getText().trim()));
            arvJTextField = this.formulario.getTxtNombres().getText().split(ConstantesApp.CONCATENADOR);
            if(arvJTextField.length > 1){
                if(arvJTextField[1] != null || !arvJTextField[1].isEmpty()){
                   this.formulario.getTxtNombres().setText(arvJTextField[0]);
                    listaErrores.add(arvJTextField[1]);
                }else{
                    this.formulario.getTxtNombres().setText(arvJTextField[0]);
                }
            }
        
        }
        
        
        
        
        
        
        
        //arvCedula = this.formulario.getTxtCedulaIdentidad().getText().split("|");
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
