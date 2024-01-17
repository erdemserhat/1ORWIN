package com.erdemserhat.a1orwin.util

import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import com.erdemserhat.a1orwin.R

@BindingAdapter("android:diceDrawable")
fun setDiceDrawable(view: View, diceNumber:Int){
    val drawableId = when (diceNumber) {
        1 -> R.drawable.dice_number_1
        2 -> R.drawable.dice_number_2
        3 -> R.drawable.dice_number_3
        4 -> R.drawable.dice_number_4
        5 -> R.drawable.dice_number_5
        6 -> R.drawable.dice_number_6
        else -> R.drawable.dice_number_1
    }
    val drawable = ResourcesCompat.getDrawable(view.resources, drawableId, null)
    view.background = drawable

}
