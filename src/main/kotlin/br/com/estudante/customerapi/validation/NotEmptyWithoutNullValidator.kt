package br.com.estudante.customerapi.validation

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class NotEmptyWithoutNullValidator : ConstraintValidator<NotEmptyWithoutNull, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return value == null || value.isNotEmpty()
    }
}
