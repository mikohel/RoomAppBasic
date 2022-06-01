package com.example.roomappbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.roomappbasic.database.User

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* mainViewModel.saveUser(User(
           "Userid002",
        "name002",
        1.75,
        88.3,
        "user002@gmail.com",
        "pass12345",
        ))*/
mainViewModel.getUsers()
        mainViewModel.savedUsers.observe(this,{userList ->
            if (!userList.isNullOrEmpty()){
                for (user in userList){
                    Log.d("thesearetheusers", user.user_id)
                    Log.d("thesearetheusers", user.user_name)
                    Log.d("thesearetheusers", user.user_altura.toString())
                    Log.d("thesearetheusers", user.user_peso.toString())
                    Log.d("thesearetheusers", user.user_email)
                    Log.d("thesearetheusers", user.user_password)
                }
            }else{
                Log.d("thesearetheusers","null or empty")
            }
            
        })
    }
}