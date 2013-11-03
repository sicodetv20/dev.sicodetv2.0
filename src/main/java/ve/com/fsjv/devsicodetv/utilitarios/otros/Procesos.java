/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.utilitarios.otros;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.border.*;

import ve.com.fsjv.devsicodetv.utilitarios.otros.ConstantesApp;

/**
 *
 * @author franklin
 */
public class Procesos {
    
    public Procesos(){
        
    }
    
    public String generarCodigo(String acronimo, String tabla, String indice){
        String identificador = null;
        String sql = "";
        int cantidad = this.obtenerCantidad(sql);
        identificador = this.concatenarCodigo(acronimo, indice, cantidad);
        int bandera = this.chequearCodigo(identificador);
        if(bandera > 0){
            cantidad++;
            identificador = this.concatenarCodigo(acronimo, indice, cantidad);
        }
        return identificador;
    }
    
    public String concatenarCodigo(String acronimo, String indice, int cantidad){
        String concatenar = null;
        if(indice == null){
            concatenar = acronimo + cantidad;
        }else{
            concatenar = acronimo + indice + cantidad;
        }
        return concatenar;
    }
    
    public int chequearCodigo(String identificador){
        int chequeado = 0;
        return chequeado;
    }
    
    public int obtenerCantidad(String sql){
        int cantidad = 0;
        cantidad++;
        return cantidad;
    }
    
    public JTextField validarTextField(JTextField componente1, int tipoValidacion){
        JTextField componente;
        componente = componente1;
        boolean bandera = true;
        if(tipoValidacion == ConstantesApp.TIPO_VALIDACION_VACIO){
            if(componente.getText().trim().isEmpty()){
            
            }
        }else if(tipoValidacion == ConstantesApp.TIPO_VALIDACION_MAXLENGTH){
            if(componente.getText().trim().length()<= ConstantesApp.MAXLENGTH){
                
            }
        }else if(tipoValidacion == ConstantesApp.TIPO_VALIDACION_MINLENGTH){
            if(componente.getText().trim().length() >= ConstantesApp.MINLENGTH){
            
            }
        }else if(tipoValidacion == ConstantesApp.TIPO_VALIDACION_FECHA){
            
        }else if(tipoValidacion == ConstantesApp.TIPO_VALIDACION_FECHA_HORA){
        
        }else if(tipoValidacion == ConstantesApp.TIPO_VALIDACION_HORA){
        
        }else if(tipoValidacion == ConstantesApp.TIPO_VALIDACION_NUMERICO){
            int value = Integer.parseInt(componente.getText().trim());
            if(value>=0){
                bandera = false;
            }
        }
        return componente;
    }
    
    public JComboBox validarComboBox(JComboBox componente1){
        JComboBox componente;
        componente = componente1;
        if(componente.getSelectedItem().toString().trim().isEmpty()){
        }
        return componente;
    }
    
    public JCheckBox validarCheckBox(JCheckBox componente1){
        JCheckBox componente;
        componente = componente1;
        if(!componente.isSelected()){
            
        }
        return componente;
    }
   
    public JRadioButton validarRadioButton(JRadioButton componente1){
        JRadioButton componente;
        componente = componente1;
        if(!componente.isSelected()){
            
        }
        return componente;
    }
    
    public JTextArea validarTextArea(JTextArea componente1){
        JTextArea componente;
        componente = componente1;
        if(componente.getText().isEmpty()){
        
        }
        return componente;
    }
    
    public JPasswordField validarJPasswordField(JPasswordField componente1){
        JPasswordField componente;
        componente = componente1;
        if(componente.getText().isEmpty()){
        
        }
        return componente;
    }
    
    public String validarPasswordIguales(JPasswordField componente1, JPasswordField componente2){
        String bandera = "1";
        String messageError = "";
        if(componente1.getText().toLowerCase().trim().equals(componente2.getText().toLowerCase().trim())){
            bandera = "0";
        }
        messageError = bandera + "|" + messageError;
        return messageError;
    }
    
    public java.util.Date convertirStringDateFecha(String fecha){
        java.util.Date jud = null;
        SimpleDateFormat formatter = new SimpleDateFormat(ConstantesApp.FORMATO_FECHA);
        try{
            jud = formatter.parse(fecha);
        }catch(ParseException dateExcep){
            //REGISTRA Logs
            return null;
        }
        return jud;
    }
    
    public String convertirDateStringFecha(java.util.Date fecha){
        String strFecha = null;
        Format formatter = new SimpleDateFormat(ConstantesApp.FORMATO_FECHA);
        strFecha = formatter.format(fecha);
        return strFecha;
    }
    
    
    public java.util.Date convertirStringDateFechaCompleta(String fecha){
        java.util.Date jud = null;
        SimpleDateFormat formatter = new SimpleDateFormat(ConstantesApp.FORMATO_FECHA_COMPLETA);
        try{
            jud = formatter.parse(fecha);
        }catch(ParseException dateExcep){
            //REGISTRA Logs
            return null;
        }
        return jud;
    }
    
    public String convertirDateStringFechaCompleta(java.util.Date fecha){
        String strFecha = null;
        Format formatter = new SimpleDateFormat(ConstantesApp.FORMATO_FECHA_COMPLETA);
        strFecha = formatter.format(fecha);
        return strFecha;
    }
    
    public java.util.Date convertirStringDateHora(String hora){
        java.util.Date jud = null;
        SimpleDateFormat formatter = new SimpleDateFormat(ConstantesApp.FORMATO_HORA);
        try{
            jud = formatter.parse(hora);
        }catch(ParseException dateExcep){
            //REGISTRA Logs
            return null;
        }
        return jud;
    }
    
    public String convertirDateStringHora(java.util.Date hora){
        String strHora = null;
        Format formatter = new SimpleDateFormat(ConstantesApp.FORMATO_HORA);
        strHora = formatter.format(hora);
        return strHora;
    }
    
    
    
    
}
