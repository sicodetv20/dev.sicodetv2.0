package ve.com.fsjv.devsicodetv.utilitarios.excepciones;
/**
 *
 * @author franklin
 */
public class ExcepcionHora extends Exception {
    /**
     * Creates a new instance of
     * <code>ExcepcionHora</code> without detail message.
     */
    public ExcepcionHora() {
    }
    /**
     * Constructs an instance of
     * <code>ExcepcionHora</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionHora(String msg) {
        super(msg);
    }
}
