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
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
        } else {
            if (e.getKeyCode() == e.VK_PRINTSCREEN) {
                Rectangle screenRectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                Robot mr = null;
                BufferedImage screenImage;
                try {
                    mr = new Robot();
                } catch (Exception excep) {
                    excep.printStackTrace();
                }
                screenImage = mr.createScreenCapture(screenRectangle);
                StringSelection stringSelection = new StringSelection("");
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            }
        }
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

    public JTextField validarTextField(JTextField componente1, int tipoValidacion)
            throws ExcepcionCampoVacio, ExcepcionComponenteNulo, ExcepcionMaxLength, ExcepcionMinLength,
            ExcepcionFecha, ExcepcionFechaCompleta, ExcepcionHora, ExcepcionNumeroInvalido {
        JTextField componente;
        java.util.Date jud = null;
        String mensaje = ConstantesApp.INICIALIZAR_STRING;
        if (componente1 != null) {
            componente = componente1;
            if (tipoValidacion == ConstantesApp.TIPO_VALIDACION_VACIO) {
                if (componente.getText().trim().isEmpty()) {
                    componente.setBorder(BorderFactory.createLineBorder(Color.RED));
                    componente.setBackground(new Color(ConstantesApp.BACKGROUND_ERROR_R, ConstantesApp.BACKGROUND_ERROR_G, ConstantesApp.BACKGROUND_ERROR_B));
                    mensaje = ConstantesApp.MENSAJE_CAMPO_VACIO + componente.getName();
                    componente.setText(componente.getText() + "|" + mensaje);
                    throw new ExcepcionCampoVacio(mensaje);
                }
            } else if (tipoValidacion == ConstantesApp.TIPO_VALIDACION_MAXLENGTH) {
                if (componente.getText().trim().length() <= ConstantesApp.MAXLENGTH) {
                    componente.setBorder(BorderFactory.createLineBorder(Color.RED));
                    componente.setBackground(new Color(ConstantesApp.BACKGROUND_ERROR_R, ConstantesApp.BACKGROUND_ERROR_G, ConstantesApp.BACKGROUND_ERROR_B));
                    mensaje = ConstantesApp.MENSAJE_CAMPO_EXCEDE_MAXLENGTH + componente.getName();
                    componente.setText(componente.getText() + "|" + mensaje);
                    throw new ExcepcionMaxLength(mensaje);
                }
            } else if (tipoValidacion == ConstantesApp.TIPO_VALIDACION_MINLENGTH) {
                if (componente.getText().trim().length() >= ConstantesApp.MINLENGTH) {
                    componente.setBorder(BorderFactory.createLineBorder(Color.RED));
                    componente.setBackground(new Color(ConstantesApp.BACKGROUND_ERROR_R, ConstantesApp.BACKGROUND_ERROR_G, ConstantesApp.BACKGROUND_ERROR_B));
                    mensaje = ConstantesApp.MENSAJE_CAMPO_MENOR_MINLENGTH + componente.getName();
                    componente.setText(componente.getText() + "|" + mensaje);
                    throw new ExcepcionMinLength(mensaje);
                }
            } else if (tipoValidacion == ConstantesApp.TIPO_VALIDACION_FECHA) {
                jud = this.convertirStringDateFecha(componente.getText().trim(), tipoValidacion);
                if (jud == null) {
                    componente.setBorder(BorderFactory.createLineBorder(Color.RED));
                    componente.setBackground(new Color(ConstantesApp.BACKGROUND_ERROR_R, ConstantesApp.BACKGROUND_ERROR_G, ConstantesApp.BACKGROUND_ERROR_B));
                    mensaje = ConstantesApp.MENSAJE_CAMPO_FECHA_INVALIDO + componente.getName();
                    componente.setText(componente.getText() + "|" + mensaje);
                    throw new ExcepcionFecha(mensaje);
                }
            } else if (tipoValidacion == ConstantesApp.TIPO_VALIDACION_FECHA_HORA) {
                jud = this.convertirStringDateFecha(componente.getText().trim(), tipoValidacion);
                if (jud == null) {
                    componente.setBorder(BorderFactory.createLineBorder(Color.RED));
                    componente.setBackground(new Color(ConstantesApp.BACKGROUND_ERROR_R, ConstantesApp.BACKGROUND_ERROR_G, ConstantesApp.BACKGROUND_ERROR_B));
                    mensaje = ConstantesApp.MENSAJE_CAMPO_FECHA_COMPLETA_INVALIDO + componente.getName();
                    componente.setText(componente.getText() + "|" + mensaje);
                    throw new ExcepcionFechaCompleta(mensaje);
                }
            } else if (tipoValidacion == ConstantesApp.TIPO_VALIDACION_HORA) {
                jud = this.convertirStringDateFecha(componente.getText().trim(), tipoValidacion);
                if (jud == null) {
                    componente.setBorder(BorderFactory.createLineBorder(Color.RED));
                    componente.setBackground(new Color(ConstantesApp.BACKGROUND_ERROR_R, ConstantesApp.BACKGROUND_ERROR_G, ConstantesApp.BACKGROUND_ERROR_B));
                    mensaje = ConstantesApp.MENSAJE_CAMPO_HORA_INVALIDO + componente.getName();
                    componente.setText(componente.getText() + "|" + mensaje);
                    throw new ExcepcionHora(mensaje);
                }
            } else if (tipoValidacion == ConstantesApp.TIPO_VALIDACION_NUMERICO) {
                try {
                    Integer.parseInt(componente.getText().trim());
                } catch (NumberFormatException excep) {
                    componente.setBorder(BorderFactory.createLineBorder(Color.RED));
                    componente.setBackground(new Color(ConstantesApp.BACKGROUND_ERROR_R, ConstantesApp.BACKGROUND_ERROR_G, ConstantesApp.BACKGROUND_ERROR_B));
                    mensaje = ConstantesApp.MENSAJE_CAMPO_NUMERICO_INVALIDO + componente.getName();
                    componente.setText(componente.getText() + "|" + mensaje);
                    throw new ExcepcionNumeroInvalido(mensaje);
                }
            }
        } else {
            throw new ExcepcionComponenteNulo(ConstantesApp.MENSAJE_COMPONENTE_NULO);
        }
        return componente;
    }

    public JComboBox validarComboBox(JComboBox componente1) throws ExcepcionComponenteNulo, ExcepcionCampoVacio {
        JComboBox componente;
        String mensaje = ConstantesApp.INICIALIZAR_STRING;
        if (componente1 == null) {
            throw new ExcepcionComponenteNulo(ConstantesApp.MENSAJE_COMPONENTE_NULO);
        } else {
            componente = componente1;
            if (componente.getSelectedItem().toString().trim().isEmpty()) {
                componente.setBorder(BorderFactory.createLineBorder(Color.RED));
                componente.setBackground(new Color(ConstantesApp.BACKGROUND_ERROR_R, ConstantesApp.BACKGROUND_ERROR_G, ConstantesApp.BACKGROUND_ERROR_B));
                mensaje = ConstantesApp.MENSAJE_CAMPO_VACIO + componente.getName();
                componente.setSelectedItem(componente.getSelectedItem() + "|" + mensaje);
                throw new ExcepcionCampoVacio(mensaje);
            }
        }
        return componente;
    }

    public JCheckBox validarCheckBox(JCheckBox componente1) throws ExcepcionComponenteNulo, ExcepcionCheckBoxNoSeleccionado {
        JCheckBox componente;
        String mensaje = ConstantesApp.INICIALIZAR_STRING;
        if (componente1 == null) {
            throw new ExcepcionComponenteNulo(ConstantesApp.MENSAJE_COMPONENTE_NULO);
        } else {
            componente = componente1;
            if (!componente.isSelected()) {
                componente.setBorder(BorderFactory.createLineBorder(Color.RED));
                componente.setBackground(new Color(ConstantesApp.BACKGROUND_ERROR_R, ConstantesApp.BACKGROUND_ERROR_G, ConstantesApp.BACKGROUND_ERROR_B));
                mensaje = ConstantesApp.MENSAJE_CHECKBOX_NO_SELECCIONADO + componente.getName();
                componente.setText(componente.getText() + "|" + mensaje);
                throw new ExcepcionCheckBoxNoSeleccionado(mensaje);
            }
        }
        return componente;
    }

    public JRadioButton validarRadioButton(JRadioButton componente1) throws ExcepcionComponenteNulo, ExcepcionCheckBoxNoSeleccionado {
        JRadioButton componente;
        String mensaje = ConstantesApp.INICIALIZAR_STRING;
        if (componente1 == null) {
            throw new ExcepcionComponenteNulo(ConstantesApp.MENSAJE_COMPONENTE_NULO);
        } else {
            componente = componente1;
            if (!componente.isSelected()) {
                componente.setBorder(BorderFactory.createLineBorder(Color.RED));
                componente.setBackground(new Color(ConstantesApp.BACKGROUND_ERROR_R, ConstantesApp.BACKGROUND_ERROR_G, ConstantesApp.BACKGROUND_ERROR_B));
                mensaje = ConstantesApp.MENSAJE_CHECKBOX_NO_SELECCIONADO + componente.getName();
                componente.setText(componente.getText() + "|" + mensaje);
                throw new ExcepcionCheckBoxNoSeleccionado(mensaje);
            }
        }
        return componente;
    }

    public JTextArea validarTextArea(JTextArea componente1) throws ExcepcionComponenteNulo, ExcepcionCampoVacio {
        JTextArea componente;
        String mensaje = ConstantesApp.INICIALIZAR_STRING;
        if (componente1 == null) {
            throw new ExcepcionComponenteNulo(ConstantesApp.MENSAJE_COMPONENTE_NULO);
        } else {
            componente = componente1;
            if (componente.getText().isEmpty()) {
                componente.setBorder(BorderFactory.createLineBorder(Color.RED));
                componente.setBackground(new Color(ConstantesApp.BACKGROUND_ERROR_R, ConstantesApp.BACKGROUND_ERROR_G, ConstantesApp.BACKGROUND_ERROR_B));
                mensaje = ConstantesApp.MENSAJE_CHECKBOX_NO_SELECCIONADO + componente.getName();
                componente.setText(componente.getText() + "|" + mensaje);
                throw new ExcepcionCampoVacio(mensaje);
            }
        }
        return componente;
    }

    public JPasswordField validarJPasswordField(JPasswordField componente1) throws ExcepcionComponenteNulo, ExcepcionCampoVacio {
        JPasswordField componente;
        String mensaje = ConstantesApp.INICIALIZAR_STRING;
        if (componente1 == null) {
            throw new ExcepcionComponenteNulo(ConstantesApp.MENSAJE_COMPONENTE_NULO);
        } else {
            componente = componente1;
            if (componente.getText().equals(null)) {
                componente.setBorder(BorderFactory.createLineBorder(Color.RED));
                componente.setBackground(new Color(ConstantesApp.BACKGROUND_ERROR_R, ConstantesApp.BACKGROUND_ERROR_G, ConstantesApp.BACKGROUND_ERROR_B));
                mensaje = ConstantesApp.MENSAJE_CAMPO_VACIO + componente.getName();
                componente.setText(componente.getText() + "|" + mensaje);
                throw new ExcepcionCampoVacio(mensaje);
            }
        }
        return componente;
    }

    public JPasswordField validarPasswordIguales(JPasswordField componente1, JPasswordField componente2) throws ExcepcionPasswordIguales {
        String bandera = String.valueOf(ConstantesApp.BANDERA_TRUE);
        String mensaje = ConstantesApp.INICIALIZAR_STRING;
        if (componente1.getText().toLowerCase().trim().equals(componente2.getText().toLowerCase().trim())) {
            bandera = String.valueOf(ConstantesApp.BANDERA_FALSE);
            mensaje = ConstantesApp.MENSAJE_PASSWORD_DIFERENTES;
            mensaje = bandera + "|" + mensaje;
            componente2.setBorder(BorderFactory.createLineBorder(Color.RED));
            componente2.setBackground(new Color(ConstantesApp.BACKGROUND_ERROR_R, ConstantesApp.BACKGROUND_ERROR_G, ConstantesApp.BACKGROUND_ERROR_B));
            throw new ExcepcionPasswordIguales(mensaje);
        }
        return componente2;
    }

    public java.util.Date convertirStringDateFecha(String fecha, int tipo) throws ExcepcionCampoVacio {
        java.util.Date jud = null;
        if (fecha.isEmpty()) {
            throw new ExcepcionCampoVacio(ConstantesApp.MENSAJE_CAMPO_VACIO);
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
            throw new ExcepcionCampoVacio(ConstantesApp.MENSAJE_CAMPO_VACIO);
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
            throw new ExcepcionCampoVacio(ConstantesApp.MENSAJE_CAMPO_VACIO);
        } else {
            jsd = new java.sql.Date(jud.getTime());
        }
        return jsd;
    }

    public java.util.Date convertirSQLDateUtilDateFecha(java.sql.Date jsd) throws ExcepcionCampoVacio {
        java.util.Date jud = null;
        if (jsd == null) {
            throw new ExcepcionCampoVacio(ConstantesApp.MENSAJE_CAMPO_VACIO);
        } else {
            jud = new java.util.Date(jsd.getTime());
        }
        return jud;
    }

    public java.util.Date convertirSQLDateUtilDateFecha(java.sql.Timestamp jst) throws ExcepcionCampoVacio {
        java.util.Date jud = null;
        if (jst == null) {
            throw new ExcepcionCampoVacio(ConstantesApp.MENSAJE_CAMPO_VACIO);
        } else {
            jud = new java.util.Date(jst.getTime());
        }
        return jud;
    }
}
