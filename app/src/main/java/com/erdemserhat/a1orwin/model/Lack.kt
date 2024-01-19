package com.erdemserhat.a1orwin.model


public class Lack {

    companion object{
        fun initializeMultiplier(): Float {
            return (1 + Math.random()).toFloat();

        }

        fun rollDice(): Int {

            return ((Math.random() * 6).toInt() + 1)
        }

    }
}