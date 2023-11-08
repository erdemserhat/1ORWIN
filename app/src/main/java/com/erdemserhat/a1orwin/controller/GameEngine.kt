package com.erdemserhat.a1orwin.controller

import com.erdemserhat.a1orwin.model.IPlayer

class GameEngine(val player:IPlayer) {

    fun roll() {
        val score = player.rollDice()
        if (score == 1f) {
            player.resetTotalScore()
            //winEffect()
            TODO("Business logic has not been implemented yet")
            //updateUI(user.getName()

        } else {
            player.addScore(score)
            //1Effect()
            //updateUI()
            TODO("Business logic has not been implemented yet")

        }


    }}










