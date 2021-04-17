package br.com.estudante.customerapi.validation

import java.util.*
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

private var POSTAL_CODE_IS_VALID = false
private const val DIGITS = 8
private val DIGITS_VALID = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")

class PostalCodeValidation : ConstraintValidator<PostalCode, String> {
  override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
    if (value != null) {
      if (value.length == DIGITS) {
        val valueInArray = value.toCharArray()
        for (item in valueInArray) {
          println(item)
          if(Arrays.stream(DIGITS_VALID).anyMatch { i -> i == item.toString() }) {
            println("tem - " + item)
            POSTAL_CODE_IS_VALID = true
          } else {
            println("nao tem - "+ item)
            return false
          }
        }
      }
    }

    return POSTAL_CODE_IS_VALID
  }
}