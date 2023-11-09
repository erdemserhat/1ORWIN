package com.erdemserhat.a1orwin.controller

import Updatement
import android.graphics.Color
import com.erdemserhat.a1orwin.model.IPlayer

class GameEngine() {

    fun roll(player: IPlayer) {
        val diceNumber = player.rollDice()
        if (diceNumber == 1f) {
            player.resetTotalScore()
            sendUpdate("0", player)

        } else {
            sendUpdate(diceNumber.toString(), player)
            //1Effect()
            //updateUI()


        }


    }


    fun sendUpdate(score: String, player: IPlayer) {
        if (player.isPlayer1()) {
            Updatement.updateTotalScoresOfUser1(score)
            if (score == "0") {
                Constants.binding.player1rollDice.isEnabled = false
                Constants.binding.player1Hold.isEnabled = false
                Constants.binding.player2RollDice.isEnabled = true
                Constants.binding.player2HoldDice.isEnabled = true
                Constants.binding.player1TotalScore.text = player.takeTotalScore().toString()
            }
        } else if (player.isPlayer2()) {
            Updatement.updateTotalScoresOfUser2(score)
            if (score == "0") {
                Constants.binding.player2RollDice.isEnabled = false
                Constants.binding.player2HoldDice.isEnabled = false
                Constants.binding.player1Hold.isEnabled = true
                Constants.binding.player1rollDice.isEnabled = true
                Constants.binding.player2TotalScore.text = player.takeTotalScore().toString()


            }


        }


    }

    fun hold(player: IPlayer) {
        val currentScore: String
        if (player.isPlayer1()) {
            currentScore = Constants.binding.player1TakenScore.text.toString()
            player.addScore(currentScore.toFloat())
            //Update Model View
            Constants.binding.player1TotalScore.text=player.takeTotalScore().toString()
            Constants.binding.player1TakenScore.text="0"

            Updatement.updateEnableStatus(false,false,true,true)

        } else if (player.isPlayer2()) {
            currentScore = Constants.binding.player2TakenScore.text.toString()
            player.addScore(currentScore.toFloat())
            //Update Model View
            //player.addScore(currentScore.toFloat())
            Constants.binding.player2TotalScore.text=player.takeTotalScore().toString()
            Constants.binding.player2TakenScore.text="0"

            //Make non-enable user2 buttons
            Constants.binding.player2HoldDice.isEnabled=false
            Constants.binding.player2RollDice.isEnabled=false

            //make enable user1 buttons
            Constants.binding.player1rollDice.isEnabled=true
            Constants.binding.player1Hold.isEnabled=true


        }


    }


}










