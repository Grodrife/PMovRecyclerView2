package com.boletin.misviajes

import android.location.Location
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Viaje(val imagen : String, val name : String, val location: String): Parcelable{
}