package ve.com.fsjv.devsicodetv.utils.exceptions;
/**
 *
 * @author franklin
 */
public class ExcepcionMinLength extends Exception {
    /**
     * Creates a new instance of
     * <code>ExcepcionMinLength</code> without detail message.
     */
    public ExcepcionMinLength() {
    }
    /**
     * Constructs an instance of
     * <code>ExcepcionMinLength</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionMinLength(String msg) {
        super(msg);
    }
}
