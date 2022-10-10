package com.boletin.misviajes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.boletin.misviajes.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_VIAJE = "DetailActivity:Viaje"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viaje = intent?.getParcelableExtra<Viaje>(EXTRA_VIAJE) ?: throw IllegalStateException()

        supportActionBar?.title = viaje.name

        binding.name.text = viaje.name

        Glide.with(binding.imagen)
            .load(viaje.imagen)
            .into(binding.imagen)
    }
}