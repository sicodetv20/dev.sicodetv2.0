package ve.com.fsjv.devsicodetv.controllers.block;

import java.util.Set;
import javax.swing.JOptionPane;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import ve.com.fsjv.devsicodetv.models.Block;
import ve.com.fsjv.devsicodetv.utils.others.Utils;

/**
 *
 * @author TecnoSoluciones-NS
 */
public class BlockValidateManager {
    private Block block;
    private Utils utils = new Utils();
    
    public BlockValidateManager(Block block){
        this.block = block;
    }
    
    public String validator(){
        String message = null;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Block>> constraintViolations;
        constraintViolations = validator.validate(this.block);
        for(ConstraintViolation<Block> contraintViolation : constraintViolations){
            message = contraintViolation.getPropertyPath() + ": " + contraintViolation.getMessage() + "\n";
        }
        return message;
    }
}
