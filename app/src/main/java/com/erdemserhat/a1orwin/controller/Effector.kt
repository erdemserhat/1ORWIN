package com.erdemserhat.a1orwin.controller

import android.animation.ValueAnimator
import android.view.View

class Effector {

    companion object{

        /**
         * Animates the alpha value of the diceView using ValueAnimator.
         */
        fun animateAlpha(view:View) {
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










    }


}