/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.utilitarios.excepciones;
/**
 *
 * @author franklin
 */
public class ExcepcionFechaCompleta extends Exception {
    /**
     * Creates a new instance of
     * <code>ExcepcionFechaCompleta</code> without detail message.
     */
    public ExcepcionFechaCompleta() {
    }
    /**
     * Constructs an instance of
     * <code>ExcepcionFechaCompleta</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionFechaCompleta(String msg) {
        super(msg);
    }
}
