package com.example.roomappbasic.database

import android.content.Context
import androidx.room.Room
import java.security.AccessControlContext

class DatabaseManager {

    lateinit var database: AppDatabase

    fun initializeDb(context: Context){
        createDb(context)
    }

    private fun createDb(context:Context){
        database = Room.databaseBuilder(context,AppDatabase::class.java, DATABASE_NAME).build()
    }

    companion object{
        val instance = DatabaseManager()
    }
}