package com.erdemserhat.a1orwin.model


public class Lack {

    companion object{
        fun initializeMultiplier(): Float {
            return (1 + Math.random()).toFloat();

        }

        fun rollDice(): Float {
            return ((Math.random() * 7).toInt() + 1).toFloat()
        }

    }
}