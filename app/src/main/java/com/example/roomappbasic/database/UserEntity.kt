package com.example.roomappbasic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TABLE_USERS)
data class UserEntity(
  @ColumnInfo(name = "user_id") @PrimaryKey val uuid: String,
  @ColumnInfo(name = "user_name") val name: String,
  val user_altura: Double,
  val user_peso: Double,
  val user_email: String,
  val user_password:String
)

fun UserEntity.toUser()= User(
  uuid,
  name,
  user_altura,
  user_peso,
  user_email,
  user_password
)
