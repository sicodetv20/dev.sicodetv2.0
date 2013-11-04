/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.utilitarios.excepciones;

/**
 *
 * @author franklin
 */
public class ExcepcionCampoVacio extends Exception {
    /**
     * Creates a new instance of
     * <code>ExcepcionCampoVacio</code> without detail message.
     */
    public ExcepcionCampoVacio() {
    }
    /**
     * Constructs an instance of
     * <code>ExcepcionCampoVacio</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionCampoVacio(String msg) {
        super(msg);
    }
}
