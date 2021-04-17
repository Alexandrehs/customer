package br.com.estudante.customerapi.validation

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class PostalCodeValidator : ConstraintValidator<PostalCode, String> {

    private var onlyNumbers = false

    override fun initialize(constraintAnnotation: PostalCode?) {
        this.onlyNumbers = constraintAnnotation!!.onlyNumbers
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        val postalCodeRegex = Regex(if (onlyNumbers) "(\\d{8})" else "(\\d{8}|\\d{2}\\.\\d{3}-\\d{3})")
        return null == value || postalCodeRegex.matches(value)
    }
}
