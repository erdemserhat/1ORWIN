package com.erdemserhat.a1orwin.controller

import Updatement
import android.app.Dialog
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.createBitmap
import com.erdemserhat.a1orwin.R
import com.erdemserhat.a1orwin.model.IPlayer


class GameEngine(val context:Context) {

    fun roll(player: IPlayer) {
        val diceNumber = player.rollDice()
        val drawableId = when (diceNumber) {
            1f -> R.drawable.dice_number_1
            2f -> R.drawable.dice_number_2
            3f -> R.drawable.dice_number_3
            4f -> R.drawable.dice_number_4
            5f -> R.drawable.dice_number_5
            6f -> R.drawable.dice_number_6
            else -> R.drawable.dice_number_1 // Eğer beklenmeyen bir zar sayısı gelirse, varsayılan drawable kullanılır.
        }

        val drawable = ResourcesCompat.getDrawable(Constants.binding.diceView.resources, drawableId, null)
        Constants.binding.diceView.setImageDrawable(drawable)
        Effector.animateAlpha(Constants.binding.diceView)
        if (diceNumber == 1f) {
            HardwareOperations.viberate(500)


            //player.resetTotalScore()
            player.resetCurrentScoreStack()
            sendUpdate(diceNumber, player)

        } else {
            player.addCurrentScoreStack(diceNumber)
            sendUpdate(diceNumber, player)

            //1Effect()
            //updateUI()


        }


    }


    private fun sendUpdate(diceNumber: Float, player: IPlayer) {
        if (player.isPlayer1()) {
            Updatement.updateCurrentScoreOfUser1(player.bringCurrentScoreStack().toString())
            if (diceNumber == 1f) {
                Updatement.updateEnableStatus(false,false,true,true)
                //Constants.binding.player1TotalScore.text = "0"
                Constants.binding.player1TakenScore.text = "0"
                Effector.animateAlpha(Constants.binding.player1TakenScore)
            }
        } else if (player.isPlayer2()) {
            Updatement.updateCurrentScoreOfUser2(player.bringCurrentScoreStack().toString())
            if (diceNumber == 1f) {
                Updatement.updateEnableStatus(true,true,false,false)
                //Constants.binding.player2TotalScore.text = "0"
                Constants.binding.player2TakenScore.text= "0"
                Effector.animateAlpha(Constants.binding.player2TakenScore)


            }


        }


    }

    fun hold(player: IPlayer) {


        val currentScore: String
        if (player.isPlayer1()) {
            player.resetCurrentScoreStack()
            currentScore = Constants.binding.player1TakenScore.text.toString()
            player.addScore(currentScore.toFloat())
            //Update Model View
            Constants.binding.player1TotalScore.text=player.takeTotalScore().toString()
            Effector.animateAlpha(Constants.binding.player1TotalScore)
            Constants.binding.player1TakenScore.text="0"
            Effector.animateAlpha(Constants.binding.player1TakenScore)

            Updatement.updateEnableStatus(false,false,true,true)

        } else if (player.isPlayer2()) {
            player.resetCurrentScoreStack()
            currentScore = Constants.binding.player2TakenScore.text.toString()
            player.addScore(currentScore.toFloat())
            //Update Model View
            //player.addScore(currentScore.toFloat())
            Constants.binding.player2TotalScore.text=player.takeTotalScore().toString()
            Effector.animateAlpha(Constants.binding.player2TotalScore)
            Constants.binding.player2TakenScore.text="0"
            Effector.animateAlpha(Constants.binding.player2TakenScore)

            //Make non-enable user2 buttons
            Updatement.updateEnableStatus(true,true,false,false)
        }

        //Winner Control
        if (player.takeTotalScore()>=100){
            Updatement.updateEnableStatus(false,false,false,false)
            val text:String="${player.bringUsername()} winned !!"
            Constants.binding.winner.text=text.uppercase()
            Constants.binding.winner.visibility=View.VISIBLE


        }


    }

    fun newGame(){
        Constants.player1.currentScoreStack=0f;
        Constants.player1.totalScore=0f;
        Constants.binding.player1TakenScore.text="0"
        Constants.binding.player1TotalScore.text="0"
        Effector.animateAlpha(Constants.binding.player1TakenScore)
        Effector.animateAlpha(Constants.binding.player1TotalScore)

        Constants.player2.currentScoreStack=0f;
        Constants.player2.totalScore=0f;
        Constants.binding.player2TakenScore.text="0"
        Constants.binding.player2TotalScore.text="0"
        Effector.animateAlpha(Constants.binding.player2TakenScore)
        Effector.animateAlpha(Constants.binding.player2TotalScore)
        HardwareOperations.viberate(1000)

        Updatement.updateEnableStatus(true,true,true,true)
        Constants.binding.winner.text=""

        Toast.makeText(context,"New Game Started!",Toast.LENGTH_SHORT).show()
    }


}

