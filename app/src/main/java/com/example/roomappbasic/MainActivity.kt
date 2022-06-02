package com.example.roomappbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.roomappbasic.database.User
import com.example.roomappbasic.databinding.ActivityMainBinding
import java.util.*
private lateinit var  binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAdd.setOnClickListener{
            mainViewModel.saveUser(User(user_id = binding.etAddUser.text.toString()))
            mainViewModel.getUsers()
        }

mainViewModel.getUsers()
        mainViewModel.savedUsers.observe(this){userList ->
            if (!userList.isNullOrEmpty()){


                for (user in userList){
                    Log.d("thesearetheusers", user.user_id)
                    binding.rwUserList.adapter = MainAdapter(userList)
                }
                Toast.makeText(this, "add succes", Toast.LENGTH_SHORT).show()
                }

            else{
                Log.d("thesearetheusers","null or empty")
            }

        }
    }


}