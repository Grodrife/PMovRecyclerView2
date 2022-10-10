package com.boletin.misviajes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.boletin.misviajes.databinding.ViewViajeItemBinding
import com.bumptech.glide.Glide

class ViajesAdapter(val viajes: List<Viaje>, val listener: (Viaje) -> Unit): RecyclerView.Adapter<ViajesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_viaje_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(viajes[position])
        holder.itemView.setOnClickListener {
            listener(viajes[position])
        }
    }

    override fun getItemCount(): Int = viajes.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = ViewViajeItemBinding.bind(view)

        fun bind(viaje: Viaje){
            Glide.with(binding.imagen)
                .load(viaje.imagen)
                .into(binding.imagen)

            binding.name.text = viaje.name
        }
    }
}