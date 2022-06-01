package com.example.roomappbasic.database
import androidx.room.Query
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM $TABLE_USERS")
    fun getUsersFromDatabase(): List<UserEntity>

    @Query("SELECT*FROM $TABLE_USERS WHERE user_id = :uuid")
    fun getUserByUuid(uuid: String): UserEntity

    @Delete
    fun delete(user: UserEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(user:UserEntity)


}