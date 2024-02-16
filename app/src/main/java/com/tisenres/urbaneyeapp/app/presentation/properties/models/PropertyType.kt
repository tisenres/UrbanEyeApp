package com.tisenres.urbaneyeapp.app.presentation.properties.models

import androidx.annotation.DrawableRes
import com.tisenres.urbaneyeapp.R

sealed class PropertyType(
    var name: String,
    var description: String,
    @DrawableRes var picRes: Int
) {
    object Fire: PropertyType(
        name = "Fire recognition",
        description = "Fire fire",
        picRes = R.drawable.fireimage
    )
    
    object Smoke: PropertyType(
        name = "Fog",
        description = "Fog fog",
        picRes = R.drawable.fog
    )
    
    object Violence: PropertyType(
        name = "Fog",
        description = "Fog fog",
        picRes = R.drawable.fog
    )
    
    companion object {
        fun from(code: Int): PropertyType {
            return when(code) {
                0 -> Fire
                1 -> Smoke
                2 -> Violence
                else -> Fire
            }
        }
    }
}