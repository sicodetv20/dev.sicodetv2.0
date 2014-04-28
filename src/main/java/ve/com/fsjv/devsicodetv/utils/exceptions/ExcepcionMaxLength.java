package ve.com.fsjv.devsicodetv.utils.exceptions;

/**
 *
 * @author franklin
 */
public class ExcepcionMaxLength extends Exception {

    /**
     * Creates a new instance of
     * <code>ExcepcionMaxLength</code> without detail message.
     */
    public ExcepcionMaxLength() {
    }
    /**
     * Constructs an instance of
     * <code>ExcepcionMaxLength</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionMaxLength(String msg) {
        super(msg);
    }
}
