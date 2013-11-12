/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.utilitarios.otros;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionCampoVacio;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionCheckBoxNoSeleccionado;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionComponenteNulo;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionFecha;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionFechaCompleta;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionHora;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionMaxLength;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionMinLength;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionNumeroInvalido;
import ve.com.fsjv.devsicodetv.utilitarios.excepciones.ExcepcionPasswordIguales;

/**
 *
 * @author franklin
 */
public class Procesos {

    public Procesos() {
    }
    
    public void permitirSoloNumeros(KeyEvent e){
        int tecla = (int)e.getKeyChar();
        if(tecla >= 97 && tecla <= 122 || tecla >= 65 && tecla <= 90)
            e.consume();
    }
    
    public String validarCampo(JTextField componente, int tipoValidacion, String valor, String nombreComponente, int tipoCampo) throws ExcepcionComponenteNulo {
        String mensaje = ConstantesApp.INICIALIZAR_STRING;
        if(componente == null){
            throw new ExcepcionComponenteNulo(ConstantesApp.MENSAJE_COMPONENTE_NULO);
        }else{
            if(tipoValidacion==ConstantesApp.TIPO_VALIDACION_VACIO){
                if(componente.getText().trim().equals("")){
                    componente.setBorder(BorderFactory.createLineBorder(Color.red));
                    componente.setBackground(new Color(ConstantesApp.BACKGROUND_ERROR_R, ConstantesApp.BACKGROUND_ERROR_G, ConstantesApp.BACKGROUND_ERROR_B));
                    mensaje = ConstantesApp.MENSAJE_CAMPO_VACIO + nombreComponente;
                }else{
                    if(tipoCampo == ConstantesApp.CAMPO_NORMAL){
                        componente.setBorder(BorderFactory.createLineBorder(new Color(ConstantesApp.BORDER_COLOR_R, ConstantesApp.BORDER_COLOR_G, ConstantesApp.BORDER_COLOR_B)));
                        componente.setBackground(Color.white);
                    }else if(tipoCampo == ConstantesApp.CAMPO_REQUERIDO){
                        componente.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                        componente.setBackground(new Color(ConstantesApp.REQUIRED_R, ConstantesApp.REQUIRED_G, ConstantesApp.REQUIRED_B));
                    }
                    mensaje = null;
                }
            }
        }
        return mensaje;
    }
    
    public String validarCampo(JFormattedTextField componente, int tipoValidacion, String valor, String nombreComponente, int tipoCampo) throws ExcepcionComponenteNulo{
        String mensaje = ConstantesApp.INICIALIZAR_STRING;
        if(componente == null){
            throw new ExcepcionComponenteNulo(ConstantesApp.MENSAJE_COMPONENTE_NULO);
        }else{
            if(tipoValidacion == ConstantesApp.TIPO_VALIDACION_DECIMAL){
                if(componente.getText().trim().replaceAll(" ", "").length() <= 1){
                    componente.setBorder(BorderFactory.createLineBorder(Color.red));
                    componente.setBackground(new Color(ConstantesApp.BACKGROUND_ERROR_R, ConstantesApp.BACKGROUND_ERROR_G, ConstantesApp.BACKGROUND_ERROR_B));
                    mensaje = ConstantesApp.MENSAJE_CAMPO_VACIO + nombreComponente;
                }else{
                    if(tipoCampo == ConstantesApp.CAMPO_NORMAL){
                        componente.setBorder(BorderFactory.createLineBorder(new Color(ConstantesApp.BORDER_COLOR_R, ConstantesApp.BORDER_COLOR_G, ConstantesApp.BORDER_COLOR_B)));
                        componente.setBackground(Color.white);
                    }else if(tipoCampo == ConstantesApp.CAMPO_REQUERIDO){
                        componente.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                        componente.setBackground(new Color(ConstantesApp.REQUIRED_R, ConstantesApp.REQUIRED_G, ConstantesApp.REQUIRED_B));
                    }
                }
            }else if(tipoValidacion == ConstantesApp.TIPO_VALIDACION_TELEFONO){
                if(componente.getText().trim().replaceAll(" ", "").length() <= 3){
                    componente.setBorder(BorderFactory.createLineBorder(Color.red));
                    componente.setBackground(new Color(ConstantesApp.BACKGROUND_ERROR_R, ConstantesApp.BACKGROUND_ERROR_G, ConstantesApp.BACKGROUND_ERROR_B));
                    mensaje = ConstantesApp.MENSAJE_CAMPO_VACIO + nombreComponente;
                }else{
                    if(tipoCampo == ConstantesApp.CAMPO_NORMAL){
                        componente.setBorder(BorderFactory.createLineBorder(new Color(ConstantesApp.BORDER_COLOR_R, ConstantesApp.BORDER_COLOR_G, ConstantesApp.BORDER_COLOR_B)));
                        componente.setBackground(Color.white);
                    }else if(tipoCampo == ConstantesApp.CAMPO_REQUERIDO){
                        componente.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                        componente.setBackground(new Color(ConstantesApp.REQUIRED_R, ConstantesApp.REQUIRED_G, ConstantesApp.REQUIRED_B));
                    }
                }
            }
        }
        
        return mensaje;
    }
    
    
    public String cargarMembreteBarraTitulo(String acronimo, String usuario, int tipo) throws ExcepcionCampoVacio {
        if(acronimo == null || usuario == null || tipo < 0){
            throw new ExcepcionCampoVacio(ConstantesApp.MENSAJE_CAMPO_VACIO);
        }else{
            String titulo = ConstantesApp.INICIALIZAR_STRING;
            titulo = ConstantesApp.APLICACION;
            if(tipo==ConstantesApp.TITULO_DOBLE || tipo == ConstantesApp.TITULO_COMPLETO){
                if(acronimo.equals(ConstantesApp.ACRONIMO_MODULO_FICHA_DETENIDO)){
                    titulo = titulo + " - " + ConstantesApp.MODULO_FICHA_DETENIDO;
                }
            }
            if(tipo==ConstantesApp.TITULO_COMPLETO){
                titulo = titulo + " - " + this.obtenerFechaActual(ConstantesApp.TIPO_VALIDACION_FECHA_HORA) + " - " + usuario;
            }
            return titulo;
        }
        
    }
    
    public String obtenerFechaActual(int tipo) throws ExcepcionCampoVacio {
        if(tipo <= 0){
            throw new ExcepcionCampoVacio(ConstantesApp.MENSAJE_CAMPO_VACIO);
        }else{
            String fecha = ConstantesApp.INICIALIZAR_STRING;
            java.util.Date jud = new java.util.Date();
            fecha = this.convertirDateStringFecha(jud, tipo);
            return fecha;
        }
    }

    public JTextField resaltarCampoRequerido(JTextField componente1) throws ExcepcionComponenteNulo {
        if (componente1 == null) {
            throw new ExcepcionComponenteNulo(ConstantesApp.MENSAJE_COMPONENTE_NULO);
        } else {
            componente1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            componente1.setBackground(new Color(ConstantesApp.REQUIRED_R, ConstantesApp.REQUIRED_G, ConstantesApp.REQUIRED_B));
            return componente1;
        }
    }

    public JFormattedTextField resaltarCampoRequerido(JFormattedTextField componente1) throws ExcepcionComponenteNulo {
        if (componente1 == null) {
            throw new ExcepcionComponenteNulo(ConstantesApp.MENSAJE_COMPONENTE_NULO);
        } else {
            componente1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            componente1.setBackground(new Color(ConstantesApp.REQUIRED_R, ConstantesApp.REQUIRED_G, ConstantesApp.REQUIRED_B));
            return componente1;
        }
    }

    public JComboBox resaltarCampoRequerido(JComboBox componente1) throws ExcepcionComponenteNulo {
        if (componente1 == null) {
            throw new ExcepcionComponenteNulo(ConstantesApp.MENSAJE_COMPONENTE_NULO);
        } else {
            componente1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            componente1.setBackground(new Color(ConstantesApp.REQUIRED_R, ConstantesApp.REQUIRED_G, ConstantesApp.REQUIRED_B));
            return componente1;
        }
    }

    public void deshabilitarTeclas(KeyEvent e) {
        if ((e.getKeyCode() >= e.VK_F1 && e.getKeyCode() <= e.VK_F12) || e.getKeyCode() == e.VK_INSERT || e.getKeyCode() == e.VK_SCROLL_LOCK || e.getKeyCode() == e.VK_PAUSE) {
            e.consume();
        } 
    }
    
    public void limpiarClipboar(){
        
    }

    public String generarCodigo(String acronimo, String tabla, String indice) {
        String identificador = ConstantesApp.INICIALIZAR_STRING;
        String sql = ConstantesApp.INICIALIZAR_STRING;
        int cantidad = this.obtenerCantidad(sql);
        identificador = this.concatenarCodigo(acronimo, indice, cantidad);
        int bandera = this.chequearCodigo(identificador);
        if (bandera > 0) {
            cantidad++;
            identificador = this.concatenarCodigo(acronimo, indice, cantidad);
        }
        return identificador;
    }

    public String concatenarCodigo(String acronimo, String indice, int cantidad) {
        String concatenar = ConstantesApp.INICIALIZAR_STRING;
        if (indice == null) {
            concatenar = acronimo + cantidad;
        } else {
            concatenar = acronimo + indice + cantidad;
        }
        return concatenar;
    }

    public int chequearCodigo(String identificador) {
        int chequeado = ConstantesApp.BANDERA_FALSE;
        return chequeado;
    }

    public int obtenerCantidad(String sql) {
        int cantidad = ConstantesApp.BANDERA_FALSE;
        cantidad++;
        return cantidad;
    }

    

    public JPasswordField validarPasswordIguales(JPasswordField componente1, JPasswordField componente2) throws ExcepcionPasswordIguales {
        String bandera = String.valueOf(ConstantesApp.BANDERA_TRUE);
        String mensaje = ConstantesApp.INICIALIZAR_STRING;
        if (componente1.getText().toLowerCase().trim().equals(componente2.getText().toLowerCase().trim())) {
            bandera = String.valueOf(ConstantesApp.BANDERA_FALSE);
            mensaje = ConstantesApp.MENSAJE_PASSWORD_DIFERENTES;
            mensaje = bandera + ConstantesApp.CONCATENADOR + mensaje;
            componente2.setBorder(BorderFactory.createLineBorder(Color.RED));
            componente2.setBackground(new Color(ConstantesApp.BACKGROUND_ERROR_R, ConstantesApp.BACKGROUND_ERROR_G, ConstantesApp.BACKGROUND_ERROR_B));
            throw new ExcepcionPasswordIguales(mensaje);
        }
        return componente2;
    }

    public java.util.Date convertirStringDateFecha(String fecha, int tipo) throws ExcepcionCampoVacio {
        java.util.Date jud = null;
        if (fecha.isEmpty()) {
            //throw new ExcepcionCampoVacio(ConstantesApp.MENSAJE_CAMPO_VACIO);
        } else {
            SimpleDateFormat formatter = null;
            if (tipo == ConstantesApp.TIPO_VALIDACION_FECHA) {
                formatter = new SimpleDateFormat(ConstantesApp.FORMATO_FECHA);
            } else if (tipo == ConstantesApp.TIPO_VALIDACION_FECHA_HORA) {
                formatter = new SimpleDateFormat(ConstantesApp.FORMATO_FECHA_COMPLETA);
            } else if (tipo == ConstantesApp.TIPO_VALIDACION_HORA) {
                formatter = new SimpleDateFormat(ConstantesApp.FORMATO_HORA);
            }
            try {
                jud = formatter.parse(fecha);
            } catch (ParseException dateExcep) {
                //REGISTRA Logs
                return null;
            }
        }
        return jud;
    }

    public String convertirDateStringFecha(java.util.Date fecha, int tipo) throws ExcepcionCampoVacio {
        String strFecha = ConstantesApp.INICIALIZAR_STRING;
        if (fecha == null) {
            //throw new ExcepcionCampoVacio(ConstantesApp.MENSAJE_CAMPO_VACIO);
        } else {
            Format formato = null;
            if (tipo == ConstantesApp.TIPO_VALIDACION_FECHA) {
                formato = new SimpleDateFormat(ConstantesApp.FORMATO_FECHA);
            } else if (tipo == ConstantesApp.TIPO_VALIDACION_FECHA_HORA) {
                formato = new SimpleDateFormat(ConstantesApp.FORMATO_FECHA_COMPLETA);
            } else if (tipo == ConstantesApp.TIPO_VALIDACION_HORA) {
                formato = new SimpleDateFormat(ConstantesApp.FORMATO_HORA);
            }
            strFecha = formato.format(fecha);
        }
        return strFecha;
    }

    public java.sql.Date convertirUtilDateSQLDateFecha(java.util.Date jud) throws ExcepcionCampoVacio {
        java.sql.Date jsd = null;
        if (jud == null) {
            //throw new ExcepcionCampoVacio(ConstantesApp.MENSAJE_CAMPO_VACIO);
        } else {
            jsd = new java.sql.Date(jud.getTime());
        }
        return jsd;
    }

    public java.util.Date convertirSQLDateUtilDateFecha(java.sql.Date jsd) throws ExcepcionCampoVacio {
        java.util.Date jud = null;
        if (jsd == null) {
            //throw new ExcepcionCampoVacio(ConstantesApp.MENSAJE_CAMPO_VACIO);
        } else {
            jud = new java.util.Date(jsd.getTime());
        }
        return jud;
    }

    public java.util.Date convertirSQLDateUtilDateFecha(java.sql.Timestamp jst) throws ExcepcionCampoVacio {
        java.util.Date jud = null;
        if (jst == null) {
            //throw new ExcepcionCampoVacio(ConstantesApp.MENSAJE_CAMPO_VACIO);
        } else {
            jud = new java.util.Date(jst.getTime());
        }
        return jud;
    }
}
