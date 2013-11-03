package ve.com.fsjv.devsicodetv.utilitarios.excepciones;
/**
 *
 * @author franklin
 */
public class ExcepcionFecha extends Exception {
    /**
     * Creates a new instance of
     * <code>ExcepcionFecha</code> without detail message.
     */
    public ExcepcionFecha() {
    }
    /**
     * Constructs an instance of
     * <code>ExcepcionFecha</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionFecha(String msg) {
        super(msg);
    }
}
