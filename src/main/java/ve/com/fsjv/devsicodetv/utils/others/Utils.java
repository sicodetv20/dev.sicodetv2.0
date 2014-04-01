/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.utils.others;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import ve.com.fsjv.devsicodetv.DAO.FichaDetenidoDAO;
import ve.com.fsjv.devsicodetv.models.FichaDetenido;
import ve.com.fsjv.devsicodetv.utils.exceptions.ExcepcionCampoVacio;
import ve.com.fsjv.devsicodetv.utils.exceptions.ExcepcionComponenteNulo;

/**
 *
 * @author franklin
 */
public class Utils {

    public Utils() {
    }
    
    public void permitirSoloNumeros(KeyEvent e){
        int tecla = (int)e.getKeyChar();
        if(tecla >= 97 && tecla <= 122 || tecla >= 65 && tecla <= 90)
            e.consume();
    }
    
    public void limpiarClipboard(){
        TimerTask timerTask = new TimerTask(){
            @Override
            public void run() {
                ve.com.fsjv.devsicodetv.utils.others.Clipboard clipboard = new ve.com.fsjv.devsicodetv.utils.others.Clipboard();
               clipboard.clear();
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }
    
    public String validarCampo(JTextField componente, int tipoValidacion, String nombreComponente, int tipoCampo){
        String mensaje = ConstantsApp.INICIALIZAR_STRING;
        if(componente == null){
        }else{
            if(tipoValidacion==ConstantsApp.TIPO_VALIDACION_VACIO){
                if(componente.getText().trim().equals("")){
                    componente.setBorder(BorderFactory.createLineBorder(Color.red));
                    componente.setBackground(new Color(ConstantsApp.BACKGROUND_ERROR_R, ConstantsApp.BACKGROUND_ERROR_G, ConstantsApp.BACKGROUND_ERROR_B));
                    mensaje = ConstantsApp.MENSAJE_CAMPO_VACIO + nombreComponente;
                }else{
                    if(tipoCampo == ConstantsApp.CAMPO_NORMAL){
                        componente.setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
                        componente.setBackground(Color.white);
                    }else if(tipoCampo == ConstantsApp.CAMPO_REQUERIDO){
                        componente.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                        componente.setBackground(new Color(ConstantsApp.REQUIRED_R, ConstantsApp.REQUIRED_G, ConstantsApp.REQUIRED_B));
                    }
                    mensaje = null;
                }
            }
        }
        return mensaje;
    }
    
    public String validarLengthCampo(JTextField componente, int tipoValidacion, String nombreComponente, int tipoCampo){
        String mensaje = ConstantsApp.INICIALIZAR_STRING;
        if(componente == null){
        }else{
            if(tipoValidacion == ConstantsApp.TIPO_VALIDACION_MAXLENGTH_CEDULA){
                if(componente.getText().trim().replaceAll(" ", "").length() > ConstantsApp.MAXLENGTH_CEDULA){
                    componente.setBorder(BorderFactory.createLineBorder(Color.red));
                    componente.setBackground(new Color(ConstantsApp.BACKGROUND_ERROR_R, ConstantsApp.BACKGROUND_ERROR_G, ConstantsApp.BACKGROUND_ERROR_B));
                    mensaje = ConstantsApp.MENSAJE_CAMPO_EXCEDE_MAXLENGTH_CEDULA + nombreComponente;
                }else{
                    if(tipoCampo == ConstantsApp.CAMPO_NORMAL){
                        componente.setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
                        componente.setBackground(Color.white);
                    }else if(tipoCampo == ConstantsApp.CAMPO_REQUERIDO){
                        componente.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                        componente.setBackground(new Color(ConstantsApp.REQUIRED_R, ConstantsApp.REQUIRED_G, ConstantsApp.REQUIRED_B));
                    }
                    mensaje = null;
                }
            }else if(tipoValidacion == ConstantsApp.TIPO_VALIDACION_MAXLENGTH_TITULO){
                if(componente.getText().trim().replaceAll(" ", "").length() > ConstantsApp.MAXLENGTH_TITULO){
                    componente.setBorder(BorderFactory.createLineBorder(Color.red));
                    componente.setBackground(new Color(ConstantsApp.BACKGROUND_ERROR_R, ConstantsApp.BACKGROUND_ERROR_G, ConstantsApp.BACKGROUND_ERROR_B));
                    mensaje = ConstantsApp.MENSAJE_CAMPO_EXCEDE_MAXLENGTH_TITULO + nombreComponente;
                }else{
                    if(tipoCampo == ConstantsApp.CAMPO_NORMAL){
                        componente.setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
                        componente.setBackground(Color.white);
                    }else if(tipoCampo == ConstantsApp.CAMPO_REQUERIDO){
                        componente.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                        componente.setBackground(new Color(ConstantsApp.REQUIRED_R, ConstantsApp.REQUIRED_G, ConstantsApp.REQUIRED_B));
                    }
                    mensaje = null;
                }
            }
        }
        return mensaje;
    }
    
    public String validarCampo(JComboBox componente, int tipoValidacion, String nombreComponente, int tipoCampo){
        String mensaje = ConstantsApp.INICIALIZAR_STRING;
        if(componente == null){
        }else{
            if(tipoValidacion==ConstantsApp.TIPO_VALIDACION_VACIO){
                if(componente.getSelectedIndex() == 0){
                    componente.setBorder(BorderFactory.createLineBorder(Color.red));
                    componente.setBackground(new Color(ConstantsApp.BACKGROUND_ERROR_R, ConstantsApp.BACKGROUND_ERROR_G, ConstantsApp.BACKGROUND_ERROR_B));
                    mensaje = ConstantsApp.MENSAJE_CAMPO_VACIO + nombreComponente;
                }else{
                    if(tipoCampo == ConstantsApp.CAMPO_NORMAL){
                        componente.setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
                        componente.setBackground(Color.white);
                    }else if(tipoCampo == ConstantsApp.CAMPO_REQUERIDO){
                        componente.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                        componente.setBackground(new Color(ConstantsApp.REQUIRED_R, ConstantsApp.REQUIRED_G, ConstantsApp.REQUIRED_B));
                    }
                    mensaje = null;
                }
            }
        }
        return mensaje;
    }
    
    public String validarCampo(JFormattedTextField componente, int tipoValidacion, String nombreComponente, int tipoCampo){
        String mensaje = ConstantsApp.INICIALIZAR_STRING;
        if(componente == null){
        }else{
            if(tipoValidacion == ConstantsApp.TIPO_VALIDACION_DECIMAL){
                if(componente.getText().trim().replaceAll(" ", "").length() <= 1){
                    componente.setBorder(BorderFactory.createLineBorder(Color.red));
                    componente.setBackground(new Color(ConstantsApp.BACKGROUND_ERROR_R, ConstantsApp.BACKGROUND_ERROR_G, ConstantsApp.BACKGROUND_ERROR_B));
                    mensaje = ConstantsApp.MENSAJE_CAMPO_VACIO + nombreComponente;
                }else{
                    if(tipoCampo == ConstantsApp.CAMPO_NORMAL){
                        componente.setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
                        componente.setBackground(Color.white);
                    }else if(tipoCampo == ConstantsApp.CAMPO_REQUERIDO){
                        componente.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                        componente.setBackground(new Color(ConstantsApp.REQUIRED_R, ConstantsApp.REQUIRED_G, ConstantsApp.REQUIRED_B));
                    }
                }
            }else if(tipoValidacion == ConstantsApp.TIPO_VALIDACION_TELEFONO){
                int bandera = ConstantsApp.BANDERA_FALSE;
                if(componente.getText().trim().replaceAll(" ", "").length() <= 3 && tipoCampo == ConstantsApp.CAMPO_REQUERIDO){
                    componente.setBorder(BorderFactory.createLineBorder(Color.red));
                    componente.setBackground(new Color(ConstantsApp.BACKGROUND_ERROR_R, ConstantsApp.BACKGROUND_ERROR_G, ConstantsApp.BACKGROUND_ERROR_B));
                    mensaje = ConstantsApp.MENSAJE_CAMPO_VACIO + nombreComponente;
                    bandera = ConstantsApp.BANDERA_TRUE;
                }
                if(componente.getText().trim().replaceAll(" ", "").length() > 3 && (componente.getText().trim().replaceAll(" ", "").length() < 14 || componente.getText().trim().replaceAll(" ", "").length() > 14)){
                    componente.setBorder(BorderFactory.createLineBorder(Color.red));
                    componente.setBackground(new Color(ConstantsApp.BACKGROUND_ERROR_R, ConstantsApp.BACKGROUND_ERROR_G, ConstantsApp.BACKGROUND_ERROR_B));
                    mensaje = ConstantsApp.MENSAJE_CAMPO_TELEFONO_ERRONEO + nombreComponente;
                    bandera = ConstantsApp.BANDERA_TRUE;
                }
                
                if(bandera == ConstantsApp.BANDERA_FALSE){
                    if(tipoCampo == ConstantsApp.CAMPO_NORMAL){
                        componente.setBorder(BorderFactory.createLineBorder(new Color(ConstantsApp.BORDER_COLOR_R, ConstantsApp.BORDER_COLOR_G, ConstantsApp.BORDER_COLOR_B)));
                        componente.setBackground(Color.white);
                    }else if(tipoCampo == ConstantsApp.CAMPO_REQUERIDO){
                        componente.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                        componente.setBackground(new Color(ConstantsApp.REQUIRED_R, ConstantsApp.REQUIRED_G, ConstantsApp.REQUIRED_B));
                    }
                }
            }
        }
        
        return mensaje;
    }
    
    
    public String cargarMembreteBarraTitulo(String acronimo, String usuario, int tipo) throws ExcepcionCampoVacio {
        if(acronimo == null || usuario == null || tipo < 0){
            throw new ExcepcionCampoVacio(ConstantsApp.MENSAJE_CAMPO_VACIO);
        }else{
            String titulo = ConstantsApp.INICIALIZAR_STRING;
            titulo = ConstantsApp.APLICACION;
            if(tipo==ConstantsApp.TITULO_DOBLE || tipo == ConstantsApp.TITULO_COMPLETO){
                if(acronimo.equals(ConstantsApp.ACRONIMO_MODULO_FICHA_DETENIDO)){
                    titulo = titulo + " - " + ConstantsApp.MODULO_FICHA_DETENIDO;
                }else if(acronimo.equals(ConstantsApp.ACRONIMO_MODULO_BUSQUEDA_DETENIDOS)){
                    titulo = titulo + " - " + ConstantsApp.MODULO_BUSQUEDAS_DETENIDOS;
                }
            }
            if(tipo==ConstantsApp.TITULO_COMPLETO){
                titulo = titulo + " - " + this.obtenerFechaActual(ConstantsApp.TIPO_VALIDACION_FECHA_HORA) + " - " + usuario;
            }
            return titulo;
        }
        
    }
    
    public String obtenerFechaActual(int tipo) {
        String fecha = ConstantsApp.INICIALIZAR_STRING;
        java.util.Date jud = new java.util.Date();
        fecha = this.convertirDateStringFecha(jud, tipo);
        return fecha;
    }

    public JTextField resaltarCampoRequerido(JTextField componente1) throws ExcepcionComponenteNulo {
        if (componente1 == null) {
            throw new ExcepcionComponenteNulo(ConstantsApp.MENSAJE_COMPONENTE_NULO);
        } else {
            componente1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            componente1.setBackground(new Color(ConstantsApp.REQUIRED_R, ConstantsApp.REQUIRED_G, ConstantsApp.REQUIRED_B));
            return componente1;
        }
    }

    public JFormattedTextField resaltarCampoRequerido(JFormattedTextField componente1) throws ExcepcionComponenteNulo {
        if (componente1 == null) {
            throw new ExcepcionComponenteNulo(ConstantsApp.MENSAJE_COMPONENTE_NULO);
        } else {
            componente1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            componente1.setBackground(new Color(ConstantsApp.REQUIRED_R, ConstantsApp.REQUIRED_G, ConstantsApp.REQUIRED_B));
            return componente1;
        }
    }

    public JComboBox resaltarCampoRequerido(JComboBox componente1) throws ExcepcionComponenteNulo {
        if (componente1 == null) {
            throw new ExcepcionComponenteNulo(ConstantsApp.MENSAJE_COMPONENTE_NULO);
        } else {
            componente1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            componente1.setBackground(new Color(ConstantsApp.REQUIRED_R, ConstantsApp.REQUIRED_G, ConstantsApp.REQUIRED_B));
            return componente1;
        }
    }

    public int generarCodigo(String acronimo, int indice, int bandera){
        int cantidad = 0;
        int codigo = 0;
        if(acronimo.equals(ConstantsApp.ACRONIMO_MODULO_FICHA_DETENIDO)){
            FichaDetenidoDAO fdDAO = new FichaDetenidoDAO();
            ArrayList<Serializable> list = new ArrayList<Serializable>();
            list = (ArrayList<Serializable>) fdDAO.list(FichaDetenido.class);
            cantidad = list.size();
            codigo = this.concatenarCodigo(indice, cantidad, bandera, 0);
            
            /*
            String condicion = " codigo_detenido = " + String.valueOf(codigo); 
            list = (ArrayList<Serializable>) fdDAO.list(FichaDetenido.class, condicion);
            cantidad = list.size();
            if(cantidad > 0){
                list = (ArrayList<Serializable>) fdDAO.list(FichaDetenido.class);
                cantidad = list.size();
                cantidad++;
                codigo = this.concatenarCodigo(indice, cantidad, bandera, 0);
            }*/
        }
        return codigo;
    }
    
    public Integer concatenarCodigo(int indice, int cantidad, int bandera, int cantidadId) {
        Integer identificador = 0;
        String concatenar = ConstantsApp.INICIALIZAR_STRING;
        cantidad++;
        concatenar = String.valueOf(indice) + String.valueOf(cantidad);
        if(bandera == ConstantsApp.BANDERA_CODIGO_INTERNO)
            identificador = Integer.parseInt(concatenar);
        else if(bandera==ConstantsApp.BANDERA_CODIGO_RELACIONAL){
            cantidadId++;
            String str = concatenar + cantidadId;
            identificador = Integer.parseInt(str);
        }
        return identificador;
    }

    public JPasswordField validarPasswordIguales(JPasswordField componente1, JPasswordField componente2) {
        String bandera = String.valueOf(ConstantsApp.BANDERA_TRUE);
        String mensaje = ConstantsApp.INICIALIZAR_STRING;
        if (componente1.getText().toLowerCase().trim().equals(componente2.getText().toLowerCase().trim())) {
            bandera = String.valueOf(ConstantsApp.BANDERA_FALSE);
            mensaje = ConstantsApp.MENSAJE_PASSWORD_DIFERENTES;
            mensaje = bandera + ConstantsApp.CONCATENADOR + mensaje;
            componente2.setBorder(BorderFactory.createLineBorder(Color.RED));
            componente2.setBackground(new Color(ConstantsApp.BACKGROUND_ERROR_R, ConstantsApp.BACKGROUND_ERROR_G, ConstantsApp.BACKGROUND_ERROR_B));
        }
        return componente2;
    }

    public java.util.Date convertirStringDateFecha(String fecha, int tipo){
        java.util.Date jud = null;
        if (fecha.isEmpty()) {
            //throw new ExcepcionCampoVacio(ConstantsApp.MENSAJE_CAMPO_VACIO);
        } else {
            SimpleDateFormat formatter = null;
            if (tipo == ConstantsApp.TIPO_VALIDACION_FECHA) {
                formatter = new SimpleDateFormat(ConstantsApp.FORMATO_FECHA);
            } else if (tipo == ConstantsApp.TIPO_VALIDACION_FECHA_HORA) {
                formatter = new SimpleDateFormat(ConstantsApp.FORMATO_FECHA_COMPLETA);
            } else if (tipo == ConstantsApp.TIPO_VALIDACION_HORA) {
                formatter = new SimpleDateFormat(ConstantsApp.FORMATO_HORA);
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

    public String convertirDateStringFecha(java.util.Date fecha, int tipo) {
        String strFecha = ConstantsApp.INICIALIZAR_STRING;
        if (fecha == null) {
            //throw new ExcepcionCampoVacio(ConstantsApp.MENSAJE_CAMPO_VACIO);
        } else {
            Format formato = null;
            if (tipo == ConstantsApp.TIPO_VALIDACION_FECHA) {
                formato = new SimpleDateFormat(ConstantsApp.FORMATO_FECHA);
            } else if (tipo == ConstantsApp.TIPO_VALIDACION_FECHA_HORA) {
                formato = new SimpleDateFormat(ConstantsApp.FORMATO_FECHA_COMPLETA);
            } else if (tipo == ConstantsApp.TIPO_VALIDACION_HORA) {
                formato = new SimpleDateFormat(ConstantsApp.FORMATO_HORA);
            }
            strFecha = formato.format(fecha);
        }
        return strFecha;
    }

    public java.sql.Date convertirUtilDateSQLDateFecha(java.util.Date jud){
        java.sql.Date jsd = null;
        if (jud == null) {
        } else {
            jsd = new java.sql.Date(jud.getTime());
        }
        return jsd;
    }

    public java.util.Date convertirSQLDateUtilDateFecha(java.sql.Date jsd){
        java.util.Date jud = null;
        if (jsd == null) {
        } else {
            jud = new java.util.Date(jsd.getTime());
        }
        return jud;
    }

    public java.util.Date convertirSQLDateUtilDateFecha(java.sql.Timestamp jst){
        java.util.Date jud = null;
        if (jst == null) {
        } else {
            jud = new java.util.Date(jst.getTime());
        }
        return jud;
    }
    
    public int obtenerAnioActual(){
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR);
    }
    
    public JComboBox llenarListaAnios(JComboBox componente){
        
        for(int i = ConstantsApp.ANIO_INICIAL; i <= this.obtenerAnioActual(); i++){
            componente.addItem(i);
        }
        return componente;
        
    }
    
    public JComboBox llenarListaMeses(JComboBox componente){
        for(int i = 1; i <= 12; i++)
            componente.addItem(i);
        return componente;
    }
    
    public int obtenerCantidadDias(int mes, int anio){
        int dias = 0;
        int bandera_bisiesto = ConstantsApp.BANDERA_FALSE;
        if(mes == 1){
            dias = 31;
        }else if(mes == 3){
            dias = 31;
        }else if(mes == 4){
            dias = 30;
        }else if(mes == 5){
            dias = 31;
        }else if(mes == 6){
            dias = 30;
        }else if(mes == 7){
            dias = 31;
        }else if(mes == 8){
            dias = 31;
        }else if(mes == 9){
            dias = 30;
        }else if(mes == 10){
            dias = 31;
        }else if(mes == 11){
            dias = 30;
        }else if(mes == 12){
            dias = 31;
        }else if(mes ==2){
            bandera_bisiesto = this.calcularAnioBisiesto(anio);
            if(bandera_bisiesto == ConstantsApp.BANDERA_TRUE)
                dias = 29;
            else
                dias = 28;
        }
        return dias;
        
    }
    
    public JComboBox llenarDias(JComboBox componente, int mes, int anio){
        for(int i = 1; i <= this.obtenerCantidadDias(mes, anio); i++)
            componente.addItem(i);
        return componente;
    }
    
    public int calcularAnioBisiesto(int anio){
        if((( anio % 4 == 0) && (anio % 100 != 0)) || (anio % 400 == 0))
            return ConstantsApp.BANDERA_TRUE;
        else
            return ConstantsApp.BANDERA_FALSE;
    }
    
    public int calcularTiempoAnios(String fechaFinal){
        String fechaInicio = this.obtenerFechaActual(ConstantsApp.TIPO_VALIDACION_FECHA);
        String[] fecha1 = fechaInicio.split("/");
        String[] fecha2 = fechaFinal.split("/");
        int anios = Integer.parseInt(fecha1[2])-Integer.parseInt(fecha2[2]);
        int mes = Integer.parseInt(fecha1[1])-Integer.parseInt(fecha2[1]);
        if(mes<0){
            anios = anios-1;
        }else if(mes==0){
            int dia = Integer.parseInt(fecha1[0])-Integer.parseInt(fecha2[0]);
            if(dia<0){
                anios = anios -1;
            }
        }
        return anios;
    }
    
    
}
