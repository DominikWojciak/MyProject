package pl.coderslab.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

    private int min;

    @Override
    public void initialize(Age age) {
        this.min = age.min();
    }

    @Override
    public boolean isValid(Integer yearOfBirth, ConstraintValidatorContext constraintValidatorContext) {
        if (yearOfBirth == null) {
            return false;
        }
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int age = currentYear - yearOfBirth;
        return age >= min;
    }
}