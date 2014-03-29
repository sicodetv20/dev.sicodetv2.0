/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.fsjv.devsicodetv.DAO;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import ve.com.fsjv.devsicodetv.modelos.Prueba;

/**
 *
 * @author Juan
 */
public class PruebaDao extends SicodetDAO {

    public static void main(String[] args) {
        Prueba pr = new Prueba();
        PruebaDao pruebaDao = new PruebaDao();
        List objetos = pruebaDao.list(Prueba.class, "where id=1");
        ValidatorFactory factory =
                Validation.buildDefaultValidatorFactory();

        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Prueba>> constraintViolations;
        for (int i = 0; i < objetos.size(); i++) {
            Prueba pr1 = (Prueba) objetos.get(i);
            pr1.setDescripcion("nueva");
            pruebaDao.insert(pr1);
            System.out.println(pr1.getDescripcion());
            constraintViolations = validator.validate(pr1);
        }

        constraintViolations = validator.validate(pr);

        System.out.println(constraintViolations.size());
        System.out.println(constraintViolations.iterator().next().getMessage());
        //pruebaDao.insert(pr);
    }
}
