package ve.com.fsjv.devsicodetv.utils.exceptions;
/**
 *
 * @author franklin
 */
public class ExcepcionPasswordIguales extends Exception {
    /**
     * Creates a new instance of
     * <code>ExcepcionPasswordIguales</code> without detail message.
     */
    public ExcepcionPasswordIguales() {
    }
    /**
     * Constructs an instance of
     * <code>ExcepcionPasswordIguales</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionPasswordIguales(String msg) {
        super(msg);
    }
}
