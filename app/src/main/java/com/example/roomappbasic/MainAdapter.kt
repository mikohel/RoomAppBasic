package com.example.roomappbasic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomappbasic.database.User
import com.example.roomappbasic.databinding.ItemUserBinding


class MainAdapter(private val usuarios: List<User>): RecyclerView.Adapter<MainAdapter.MainHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val binding= ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.render(usuarios[position])

    }

    override fun getItemCount(): Int = usuarios.size

    class MainHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root){

        fun render (usuario : User){
            binding.Name.setText(usuario.user_id)
        }
}
}