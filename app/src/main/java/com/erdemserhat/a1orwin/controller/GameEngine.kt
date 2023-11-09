package com.erdemserhat.a1orwin.controller

import Updatement
import com.erdemserhat.a1orwin.model.IPlayer

class GameEngine() {

    fun roll(player:IPlayer) {
        val score = player.rollDice()
        if (score == 1f) {
            player.resetTotalScore()
            sendUpdate("0",player)

        } else {
            sendUpdate(score.toString(),player)
            //1Effect()
            //updateUI()


        }




    }


    fun sendUpdate(score:String,player:IPlayer){
        if(player.isPlayer1())
            Updatement().updateTotalScoresOfUser1(score)
        else if(player.isPlayer2())
            Updatement().updateTotalScoresOfUser2(score)

    }





}










