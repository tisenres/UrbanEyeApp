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
        description = "Fire description",
        picRes = R.drawable.fire
    )
    
    object Smoke: PropertyType(
        name = "Smoke",
        description = "Smoke description",
        picRes = R.drawable.smoke
    )
    
    object Violence: PropertyType(
        name = "Violence",
        description = "Fog description",
        picRes = R.drawable.violence
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