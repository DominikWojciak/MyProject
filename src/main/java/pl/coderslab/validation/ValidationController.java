package pl.coderslab.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.owner.Owner;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ValidationController {

    @Autowired
    private Validator validator;

    @GetMapping("/validate")
    public String validate(Model model) {
        Owner owner = new Owner();
        Set<ConstraintViolation<Owner>> set = validator.validate(owner);

        List<TestError> errors = new ArrayList<>();

        if(!set.isEmpty()) {
            for (ConstraintViolation<Owner> constraint : set) {
                String path = constraint.getPropertyPath().toString();
                String message = constraint.getMessage();
                TestError error = new TestError(path, message);
                errors.add(error);
            }
        }

        model.addAttribute("errors", errors);
        return "errors";
    }
}
