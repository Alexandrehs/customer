package br.com.estudante.customerapi.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PostalCodeValidation::class])
@MustBeDocumented

annotation class PostalCode (
  val message : String = "Por favor, insira um CEP válido, vindo da annotation custom",

  val groups : Array<KClass<Any>> = [],

  val payload : Array<KClass<Payload>> = []
)