package com.erdemserhat.a1orwin.model

import com.erdemserhat.a1orwin.controller.HardwareOperations


public class Lack {

    companion object{
        fun initializeMultiplier(): Float {
            return (1 + Math.random()).toFloat();

        }

        fun rollDice(): Float {

            return ((Math.random() * 6).toInt() + 1).toFloat()
        }

    }
}