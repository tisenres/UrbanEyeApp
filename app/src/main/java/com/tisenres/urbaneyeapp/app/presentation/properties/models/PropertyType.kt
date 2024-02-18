package com.tisenres.urbaneyeapp.app.presentation.properties.models

import androidx.annotation.DrawableRes
import com.tisenres.urbaneyeapp.R

sealed class PropertyType(
    var name: String,
    var description: String,
    @DrawableRes var picRes: Int
) {
    object Property0: PropertyType(
        name = "Home 2nd floor",
        description = "11:04PM",
        picRes = R.drawable.house2
    )

    object Property1: PropertyType(
        name = "Garage",
        description = "11:04PM",
        picRes = R.drawable.garage
    )
    
    object Property2: PropertyType(
        name = "Qiyot, 61",
        description = "11:04PM",
        picRes = R.drawable.qiout
    )

    object Property3: PropertyType(
        name = "Azimov street, 37",
        description = "11:03PM",
        picRes = R.drawable.azimov
    )
    
    object Property4: PropertyType(
        name = "Parents' house",
        description = "11:02PM",
        picRes = R.drawable.uzbek
    )
    
    companion object {
        fun from(code: Int): PropertyType {
            return when(code) {
                0 -> Property0
                1 -> Property1
                2 -> Property2
                3 -> Property3
                4 -> Property4
                else -> Property0
            }
        }
    }
}