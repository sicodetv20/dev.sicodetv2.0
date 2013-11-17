package ve.com.fsjv.devsicodetv.utilitarios.excepciones;
/**
 *
 * @author franklin
 */
public class ExcepcionCheckBoxNoSeleccionado extends Exception {
    /**
     * Creates a new instance of
     * <code>ExcepcionCheckBoxNoSeleccionado</code> without detail message.
     */
    public ExcepcionCheckBoxNoSeleccionado() {
    }
    /**
     * Constructs an instance of
     * <code>ExcepcionCheckBoxNoSeleccionado</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public ExcepcionCheckBoxNoSeleccionado(String msg) {
        super(msg);
    }
}
