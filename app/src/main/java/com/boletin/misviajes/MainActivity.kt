package com.boletin.misviajes

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.boletin.misviajes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)

            recycler.adapter = ViajesAdapter(viajes) { viaje ->

                val gmmIntentUri = Uri.parse("geo:${viaje.location.toString()}")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
            }
        }
    }
}

private val viajes = (1..100).map {
    Viaje(
        "https://loremflickr.com/240/320/city?lock=$it",
        "Nombre $it",
        "1${it}.414382,1${it}.013988"
    )
}