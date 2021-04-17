package br.com.estudante.customerapi.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [NotEmptyWithoutNullValidator::class])
@MustBeDocumented

annotation class NotEmptyWithoutNull(
    val message: String = "cannbot be empty",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<out Payload>> = []
)
