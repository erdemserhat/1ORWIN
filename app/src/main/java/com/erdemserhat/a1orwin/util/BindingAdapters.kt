package com.erdemserhat.a1orwin.util

import android.animation.ValueAnimator
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
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
    animateAlpha(view)
    view.background = drawable

    if(diceNumber==1){
        vibrate(view,100)
    }
}


private fun vibrate(view: View, millisecondsValue:Long){
    val v = (view.context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        v.vibrate(
            VibrationEffect.createOneShot(millisecondsValue,
                VibrationEffect.DEFAULT_AMPLITUDE))
    }
    else {
        v.vibrate(millisecondsValue)
    }
}
private fun animateAlpha(view:View) {
    // Create a ValueAnimator that animates the alpha value from 0 to 1
    val animator = ValueAnimator.ofFloat(0f, 1f)

    // Add an update listener to the animator to receive callbacks when the animation value changes
    animator.addUpdateListener { animation ->
        // Get the current animated alpha value
        val alphaValue = animation.animatedValue as Float

        // Set the alpha value of the diceView
        view.alpha = alphaValue
    }

    // Set the duration of the animation in milliseconds
    animator.duration = 500

    // Start the animation
    animator.start()
}

