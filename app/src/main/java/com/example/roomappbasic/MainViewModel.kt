package com.example.roomappbasic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomappbasic.database.DatabaseManager
import com.example.roomappbasic.database.MyCoroutines

import com.example.roomappbasic.database.User
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel: ViewModel(){
    fun saveUser(user: User){
       viewModelScope.launch {
           val userDao = DatabaseManager.instance.database.userDao()
           MyCoroutines(userDao).save(user)
       }
    }

    fun deleteUser(user: User){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            MyCoroutines(userDao).delete(user)
        }
    }

    val savedUsers= MutableLiveData<List<User>>()

    fun  getUsers(){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            savedUsers.value = MyCoroutines(userDao).getUsers().value
        }
    }
}