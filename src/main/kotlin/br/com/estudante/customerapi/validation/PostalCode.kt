package br.com.estudante.customerapi.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PostalCodeValidator::class])
@MustBeDocumented

annotation class PostalCode(
    val message: String = "Informe um CEP válido",
    val onlyNumbers: Boolean = false,
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<out Payload>> = []
)
