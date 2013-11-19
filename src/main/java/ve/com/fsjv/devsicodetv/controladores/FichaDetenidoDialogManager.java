package ve.com.fsjv.devsicodetv.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionCampoVacio;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionComponenteNulo;
import ve.com.fsjv.devsicodetv.utilitarios.otros.ConstantesApp;
import ve.com.fsjv.devsicodetv.utilitarios.otros.Procesos;
import ve.com.fsjv.devsicodetv.vistas.FichaDetenidoDialog;

/**
 *
 * @author franklin
 */
public class FichaDetenidoDialogManager implements ActionListener, KeyListener {
    private FichaDetenidoDialog formulario;
    private Procesos procesos;
    
    public FichaDetenidoDialogManager() throws ExcepcionComponenteNulo, ExcepcionCampoVacio, InterruptedException, InvocationTargetException {
        this.formulario = new FichaDetenidoDialog(new JFrame(), true);
        this.procesos = new Procesos();
        this.formulario.setCmbAnio(this.procesos.llenarListaAnios(this.formulario.getCmbAnio()));
        this.formulario.setCmbMes(this.procesos.llenarListaMeses(this.formulario.getCmbMes()));
        
        this.formulario.getTxtCedulaIdentidad().setText("DET1");
        
        this.iniciarBotones();
        
        this.formulario.getCmbReservista().addActionListener(this);
        this.formulario.getCmbAnio().addActionListener(this);
        this.formulario.getCmbMes().addActionListener(this);
        this.formulario.getCmbDia().addActionListener(this);
        this.formulario.getBtnGuardar().addActionListener(this);
        this.formulario.getTxtCedulaIdentidad().addKeyListener(this);
        this.formulario.getBtnNuevo().addActionListener(this);
        this.formulario.getBtnCancelar().addActionListener(this);
        this.formulario.getBtnBuscar().addActionListener(this);
        
        this.formulario.setTitle(this.procesos.cargarMembreteBarraTitulo(ConstantesApp.ACRONIMO_MODULO_FICHA_DETENIDO, "Administrador", ConstantesApp.TITULO_COMPLETO));
        this.formulario.setSize(1180, 740);
        this.formulario.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.procesos.limpiarClipboard();
        this.formulario.setVisible(true);
        
    }
    
    public void resaltarCampos() throws ExcepcionComponenteNulo{
        this.formulario.getTxtCodigoInterno().setText(String.valueOf(this.procesos.obtenerAnioActual()));
        this.formulario.setTxtCodigoInterno(this.procesos.resaltarCampoRequerido(this.formulario.getTxtCodigoInterno()));
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
        this.formulario.setCmbTipoNariz(this.procesos.resaltarCampoRequerido(this.formulario.getCmbTipoNariz()));
        this.formulario.setTxtEstatura(this.procesos.resaltarCampoRequerido(this.formulario.getTxtEstatura()));
    }
    
    public void iniciarBotones(){
        this.aplicarReadOnly(false, ConstantesApp.READONLY_DEFAULT);
        this.formulario.getBtnBuscar().setEnabled(true);
        this.formulario.getBtnNuevo().setEnabled(true);
        
        this.formulario.getBtnGuardar().setEnabled(false);
        this.formulario.getBtnEditar().setEnabled(false);
        this.formulario.getBtnBorrar().setEnabled(false);
        this.formulario.getBtnAgregarCausa().setEnabled(false);
        this.formulario.getBtnCelda().setEnabled(false);
        this.formulario.getBtnCancelar().setEnabled(false);
        this.formulario.getBtnImprimir().setEnabled(false);
        this.formulario.getBtnEvidencias().setEnabled(false);
        this.formulario.getBtnHuellas().setEnabled(false);
        
        this.formulario.getBtnCamara().setEnabled(false);
        this.formulario.getBtnVerFoto().setEnabled(false);
        this.formulario.getBtnVerHistoriales().setEnabled(false);
        this.formulario.getBtnVerUltimosAgregados().setEnabled(false);
        this.formulario.getBtnGaleria().setEnabled(false);
        
    }
    
    public ArrayList<String> validarCampos(){
        ArrayList<String> listaErrores = new ArrayList<String>();
        //arreglo de resultado de la validacion
        String[] arv;
        String resultado = ConstantesApp.INICIALIZAR_STRING;
        resultado = this.procesos.validarCampo(this.formulario.getTxtCodigoInterno(), ConstantesApp.TIPO_VALIDACION_VACIO, "Codigo Interno", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        resultado = this.procesos.validarCampo(this.formulario.getTxtCedulaIdentidad(), ConstantesApp.TIPO_VALIDACION_VACIO, "Cedula de Identidad", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        if(!this.formulario.getTxtCedulaIdentidad().getText().trim().equals("")){
            resultado = this.procesos.validarLengthCampo(this.formulario.getTxtCedulaIdentidad(), ConstantesApp.TIPO_VALIDACION_MAXLENGTH_CEDULA, "Cedula de Identidad", ConstantesApp.CAMPO_REQUERIDO);
            if(resultado != null){
                listaErrores.add(resultado);
            }
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getTxtNombres(), ConstantesApp.TIPO_VALIDACION_VACIO, "Nombres", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        if(!this.formulario.getTxtNombres().getText().trim().equals("")){
            resultado = this.procesos.validarLengthCampo(this.formulario.getTxtNombres(), ConstantesApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Nombres", ConstantesApp.CAMPO_REQUERIDO);
            if(resultado != null){
                listaErrores.add(resultado);
            }
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getTxtApellidos(), ConstantesApp.TIPO_VALIDACION_VACIO, "Apellidos", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        if(!this.formulario.getTxtApellidos().getText().trim().equals("")){
            resultado = this.procesos.validarLengthCampo(this.formulario.getTxtApellidos(), ConstantesApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Apellidos", ConstantesApp.CAMPO_REQUERIDO);
            if(resultado != null){
                listaErrores.add(resultado);
            }
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getTxtLugarNacimiento(), ConstantesApp.TIPO_VALIDACION_VACIO, "Lugar de Nacimiento", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        if(!this.formulario.getTxtLugarNacimiento().getText().trim().equals("")){
            resultado = this.procesos.validarLengthCampo(this.formulario.getTxtLugarNacimiento(), ConstantesApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Lugar Nacimiento", ConstantesApp.CAMPO_REQUERIDO);
            if(resultado != null){
                listaErrores.add(resultado);
            }
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getTxtEdad(), ConstantesApp.TIPO_VALIDACION_VACIO, "Edad", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        resultado = this.procesos.validarCampo(this.formulario.getTxtEstatura(), ConstantesApp.TIPO_VALIDACION_DECIMAL, "Estatura", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbSexo(), ConstantesApp.TIPO_VALIDACION_VACIO, "Sexo", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbNacionalidad(), ConstantesApp.TIPO_VALIDACION_VACIO, "Nacionalidad", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbEstadoCivil(), ConstantesApp.TIPO_VALIDACION_VACIO, "Estado Civil", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbColorOjos(), ConstantesApp.TIPO_VALIDACION_VACIO, "Color de Ojos", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbColorPiel(), ConstantesApp.TIPO_VALIDACION_VACIO, "Color de Piel", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbColorCabello(), ConstantesApp.TIPO_VALIDACION_VACIO, "Color de Cabello", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbTipoNariz(), ConstantesApp.TIPO_VALIDACION_VACIO, "Tipo de Nariz", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbContextura(), ConstantesApp.TIPO_VALIDACION_VACIO, "Contextura", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbAnio(), ConstantesApp.TIPO_VALIDACION_VACIO, "Año (Fecha de Nacimiento)", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbMes(), ConstantesApp.TIPO_VALIDACION_VACIO, "Mes (Fecha de Nacimiento)", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getCmbDia(), ConstantesApp.TIPO_VALIDACION_VACIO, "Dia (Fecha de Nacimiento)", ConstantesApp.CAMPO_REQUERIDO);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarLengthCampo(this.formulario.getTxtAlias(), ConstantesApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Alias", ConstantesApp.CAMPO_NORMAL);
            if(resultado != null){
                listaErrores.add(resultado);
            }
        
        resultado = this.procesos.validarLengthCampo(this.formulario.getTxtPasaporte(), ConstantesApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Pasaporte", ConstantesApp.CAMPO_NORMAL);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarLengthCampo(this.formulario.getTxtReligion(), ConstantesApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Religion", ConstantesApp.CAMPO_NORMAL);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        
        resultado = this.procesos.validarLengthCampo(this.formulario.getTxtDocumentoAnterior(), ConstantesApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Docu. Anterior", ConstantesApp.CAMPO_NORMAL);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarLengthCampo(this.formulario.getTxtCicatriz(), ConstantesApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Cicatriz", ConstantesApp.CAMPO_NORMAL);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarLengthCampo(this.formulario.getTxtSeniasParticulares(), ConstantesApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Señas Part.", ConstantesApp.CAMPO_NORMAL);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarLengthCampo(this.formulario.getTxtProfesion(), ConstantesApp.TIPO_VALIDACION_MAXLENGTH_TITULO, "Profesion", ConstantesApp.CAMPO_NORMAL);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getTxtTelefonoCelular(), ConstantesApp.TIPO_VALIDACION_TELEFONO, "Telefono Celular", ConstantesApp.CAMPO_NORMAL);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getTxtTelefonoEmergencia(), ConstantesApp.TIPO_VALIDACION_TELEFONO, "Telefono de Emergencia", ConstantesApp.CAMPO_NORMAL);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        resultado = this.procesos.validarCampo(this.formulario.getTxtTelefonoHabitacion(), ConstantesApp.TIPO_VALIDACION_TELEFONO, "Telefono de Habitacion", ConstantesApp.CAMPO_NORMAL);
        if(resultado != null){
            listaErrores.add(resultado);
        }
        
        return listaErrores;
    }
    
    public void cargarDialogBlanco(){
        this.formulario.getTxtCedulaIdentidad().setText("");
        this.formulario.getTxtNombres().setText("");
        this.formulario.getTxtApellidos().setText("");
        this.formulario.getTxtAlias().setText("");
        this.formulario.getCmbSexo().setSelectedIndex(0);
        this.formulario.getTxtPasaporte().setText("");
        this.formulario.getCmbNacionalidad().setSelectedIndex(0);
        this.formulario.getTxtReligion().setText("");
        this.formulario.getCmbEstadoCivil().setSelectedIndex(0);
        this.formulario.getCmbAnio().setSelectedIndex(0);
        this.formulario.getCmbMes().setSelectedIndex(0);
        this.formulario.getCmbDia().setSelectedIndex(0);
        this.formulario.getTxtEdad().setText("");
        this.formulario.getTxtLugarNacimiento().setText("");
        this.formulario.getTxtDocumentoAnterior().setText("");
        this.formulario.getCmbReservista().setSelectedIndex(0);
        this.formulario.getCmbColorPiel().setSelectedIndex(0);
        this.formulario.getCmbColorCabello().setSelectedIndex(0);
        this.formulario.getCmbColorOjos().setSelectedIndex(0);
        this.formulario.getCmbTipoNariz().setSelectedIndex(0);
        this.formulario.getTxtEstatura().setText("");
        this.formulario.getCmbLentes().setSelectedIndex(0);
        this.formulario.getCmbContextura().setSelectedIndex(0);
        this.formulario.getTxtCicatriz().setText("");
        this.formulario.getTxtSeniasParticulares().setText("");
        this.formulario.getTxtDireccionActual().setText("");
        this.formulario.getTxtDireccionAnterior().setText("");
        this.formulario.getTxtDireccionEmergencia().setText("");
        this.formulario.getTxtTelefonoCelular().setText("");
        this.formulario.getTxtTelefonoEmergencia().setText("");
        this.formulario.getTxtTelefonoHabitacion().setText("");
        this.formulario.getCmbVivienda().setSelectedIndex(0);
        this.formulario.getCmbTipoVivienda().setSelectedIndex(0);
        this.formulario.getCmbGradoInstruccion().setSelectedIndex(0);
        this.formulario.getTxtProfesion().setText("");
    }
    
    public void aplicarReadOnly(boolean valor, int tipo) {
        if (tipo == ConstantesApp.READONLY_DEFAULT) {
            this.cargarDialogBlanco();
        }
        this.formulario.getTxtCedulaIdentidad().setEditable(valor);
        this.formulario.getTxtNombres().setEditable(valor);
        this.formulario.getTxtApellidos().setEditable(valor);
        this.formulario.getTxtAlias().setEditable(valor);
        this.formulario.getCmbSexo().setEnabled(valor);
        this.formulario.getCmbAnio().setEnabled(valor);
        this.formulario.getCmbMes().setEnabled(valor);
        this.formulario.getCmbDia().setEnabled(valor);
        this.formulario.getTxtPasaporte().setEditable(valor);
        this.formulario.getCmbNacionalidad().setEnabled(valor);
        this.formulario.getTxtReligion().setEditable(valor);
        this.formulario.getCmbEstadoCivil().setEnabled(valor);
        this.formulario.getTxtLugarNacimiento().setEditable(valor);
        this.formulario.getTxtDocumentoAnterior().setEditable(valor);
        this.formulario.getCmbReservista().setEnabled(valor);
        this.formulario.getCmbColorPiel().setEnabled(valor);;
        this.formulario.getCmbColorCabello().setEnabled(valor);
        this.formulario.getCmbColorOjos().setEnabled(valor);
        this.formulario.getCmbTipoNariz().setEnabled(valor);
        this.formulario.getTxtEstatura().setEditable(valor);
        this.formulario.getCmbLentes().setEnabled(valor);
        this.formulario.getCmbContextura().setEnabled(valor);
        this.formulario.getTxtCicatriz().setEditable(valor);
        this.formulario.getTxtSeniasParticulares().setEditable(valor);
        this.formulario.getTxtDireccionActual().setEditable(valor);
        this.formulario.getTxtDireccionAnterior().setEditable(valor);
        this.formulario.getTxtDireccionEmergencia().setEditable(valor);;
        this.formulario.getTxtTelefonoCelular().setEditable(valor);
        this.formulario.getTxtTelefonoEmergencia().setEditable(valor);
        this.formulario.getTxtTelefonoHabitacion().setEditable(valor);
        this.formulario.getCmbVivienda().setEnabled(valor);
        this.formulario.getCmbTipoVivienda().setEnabled(valor);
        this.formulario.getCmbGradoInstruccion().setEnabled(valor);
        this.formulario.getTxtProfesion().setEditable(valor);
    }
    
    public void nuevoRegistro() throws ExcepcionComponenteNulo{
        this.resaltarCampos();
        this.aplicarReadOnly(true, ConstantesApp.READONLY_DEFAULT);
        this.formulario.getBtnBuscar().setEnabled(false);
        this.formulario.getBtnNuevo().setEnabled(false);
        
        this.formulario.getBtnGuardar().setEnabled(true);
        this.formulario.getBtnEditar().setEnabled(false);
        this.formulario.getBtnBorrar().setEnabled(false);
        this.formulario.getBtnAgregarCausa().setEnabled(false);
        this.formulario.getBtnCelda().setEnabled(false);
        this.formulario.getBtnCancelar().setEnabled(true);
        this.formulario.getBtnImprimir().setEnabled(false);
        this.formulario.getBtnEvidencias().setEnabled(false);
        this.formulario.getBtnHuellas().setEnabled(false);
        
        this.formulario.getBtnCamara().setEnabled(false);
        this.formulario.getBtnVerFoto().setEnabled(false);
        this.formulario.getBtnVerHistoriales().setEnabled(false);
        this.formulario.getBtnVerUltimosAgregados().setEnabled(false);
        this.formulario.getBtnGaleria().setEnabled(false);
    }
    
    public void eventoCancelar(){
        this.iniciarBotones();
    }
    
    public void eventoBuscar() throws ExcepcionComponenteNulo{
        this.resaltarCampos();
        this.aplicarReadOnly(true, ConstantesApp.READONLY_DATA);
        this.formulario.getBtnBuscar().setEnabled(false);
        this.formulario.getBtnNuevo().setEnabled(false);
        
        this.formulario.getBtnGuardar().setEnabled(false);
        this.formulario.getBtnEditar().setEnabled(true);
        this.formulario.getBtnBorrar().setEnabled(true);
        this.formulario.getBtnAgregarCausa().setEnabled(true);
        this.formulario.getBtnCelda().setEnabled(false);
        this.formulario.getBtnCancelar().setEnabled(true);
        this.formulario.getBtnImprimir().setEnabled(true);
        this.formulario.getBtnEvidencias().setEnabled(true);
        this.formulario.getBtnHuellas().setEnabled(false);
        
        this.formulario.getBtnCamara().setEnabled(true);
        this.formulario.getBtnVerFoto().setEnabled(true);
        this.formulario.getBtnVerHistoriales().setEnabled(true);
        this.formulario.getBtnVerUltimosAgregados().setEnabled(true);
        this.formulario.getBtnGaleria().setEnabled(true);
    
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.formulario.getBtnNuevo()){
            try {
                this.nuevoRegistro();
            } catch (ExcepcionComponenteNulo ex) {
            }
        }else if(e.getSource()== this.formulario.getBtnCancelar()){
            this.eventoCancelar();
        }else if(e.getSource()==this.formulario.getBtnBuscar()){
            try {
                this.eventoBuscar();
            } catch (ExcepcionComponenteNulo ex) {
            }
        }else if(e.getSource() == this.formulario.getBtnGuardar()){
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
                if(iconoMensaje==JOptionPane.INFORMATION_MESSAGE){
                    FichaDetenidoDAO fdDAO = new FichaDetenidoDAO();
                    int cantidad = fdDAO.count(ConstantesApp.TABLA_FICHA_DETENIDO);
                    JOptionPane.showMessageDialog(this.formulario, cantidad);//aqui es donde tengo el problema no me muestra la cantidad
                }
            
        }else if(e.getSource() == this.formulario.getCmbReservista()){
            if(this.formulario.getCmbReservista().getSelectedItem().toString().toLowerCase().equals("si")){
                this.formulario.getTxtAnio().setEditable(ConstantesApp.EDITABLE);
            }else{
                this.formulario.getTxtAnio().setText(ConstantesApp.INICIALIZAR_STRING);
                this.formulario.getTxtAnio().setEditable(ConstantesApp.NO_EDITABLE);
            }
        }else if(e.getSource() == this.formulario.getCmbAnio()){
            if(this.formulario.getCmbAnio().getSelectedIndex() > 0){
                this.formulario.getTxtEdad().setText(ConstantesApp.INICIALIZAR_STRING);
                this.formulario.getCmbMes().setSelectedIndex(0);
                this.formulario.getCmbMes().setEnabled(ConstantesApp.EDITABLE);
                this.formulario.getCmbDia().setSelectedIndex(0);
                this.formulario.getCmbDia().setEnabled(ConstantesApp.NO_EDITABLE);
            }else{
                this.formulario.getTxtEdad().setText(ConstantesApp.INICIALIZAR_STRING);
                this.formulario.getCmbMes().setSelectedIndex(0);
                this.formulario.getCmbMes().setEnabled(ConstantesApp.NO_EDITABLE);
                this.formulario.getCmbDia().setSelectedIndex(0);
                this.formulario.getCmbDia().setEnabled(ConstantesApp.NO_EDITABLE);
            }
        }else if(e.getSource() == this.formulario.getCmbMes()){
            if(this.formulario.getCmbMes().getSelectedIndex() > 0){
                this.formulario.getTxtEdad().setText(ConstantesApp.INICIALIZAR_STRING);
                this.formulario.getCmbDia().removeAllItems();
                this.formulario.getCmbDia().addItem("Dia");
                this.formulario.setCmbDia(this.procesos.llenarDias(
                        this.formulario.getCmbDia(), 
                        Integer.parseInt(this.formulario.getCmbMes().getSelectedItem().toString()), 
                        Integer.parseInt(this.formulario.getCmbAnio().getSelectedItem().toString())));
                this.formulario.getCmbDia().setSelectedIndex(0);
                this.formulario.getCmbDia().setEnabled(ConstantesApp.EDITABLE);
            }else{
                this.formulario.getTxtEdad().setText(ConstantesApp.INICIALIZAR_STRING);
                this.formulario.getCmbDia().setSelectedIndex(0);
                this.formulario.getCmbDia().setEnabled(ConstantesApp.NO_EDITABLE);
            }
        }else if(e.getSource() == this.formulario.getCmbDia()){
            if(this.formulario.getCmbDia().getSelectedIndex() > 0){
                String fecha = this.formulario.getCmbDia().getSelectedItem().toString() + "/" + this.formulario.getCmbMes().getSelectedItem().toString() + "/" + this.formulario.getCmbAnio().getSelectedItem().toString();
                int edad = this.procesos.calcularTiempoAnios(fecha);
                this.formulario.getTxtEdad().setText(String.valueOf(edad));
            }else{
                this.formulario.getTxtEdad().setText(ConstantesApp.INICIALIZAR_STRING);
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
    }
    
}
