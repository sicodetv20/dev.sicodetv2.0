package ve.com.fsjv.devsicodetv.utilitarios.excepciones;
/**
 *
 * @author franklin
 */
public class ExcepcionNumeroInvalido extends Exception {
    /**
     * Creates a new instance of
     * <code>ExcepcionNumeroInvalido</code> without detail message.
     */
    public ExcepcionNumeroInvalido() {
    }
    /**
     * Constructs an instance of
     * <code>ExcepcionNumeroInvalido</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionNumeroInvalido(String msg) {
        super(msg);
    }
}
