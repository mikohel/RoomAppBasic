package com.example.roomappbasic.database

class User(
    user_id: String,
    user_name: String,
    user_altura: Double,
    user_peso: Double,
    user_email: String,
    user_password: String

) {
    val user_id: String = user_id
    val user_name: String = user_name
  val user_altura: Double = user_altura
  val user_peso: Double = user_peso
  val user_email: String = user_email
  val user_password:String = user_password

}

fun User.toEntity()= UserEntity(
    user_id,
    user_name,
    user_altura,
    user_peso,
    user_email,
    user_password
)