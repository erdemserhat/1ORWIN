package com.erdemserhat.a1orwin.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erdemserhat.a1orwin.model.Player

class GameViewModel : ViewModel() {
    //mutable live data objects...
    private val _player1: MutableLiveData<Player> =
        MutableLiveData(Player(username = "Player 1", canRollDice = true))
    private val _player2: MutableLiveData<Player> =
        MutableLiveData(Player(username = "Player 2", canRollDice = false))
    private val _diceNumber: MutableLiveData<Int> = MutableLiveData(1)

    //immutable objects for view view is observing these variables.
    val player1: LiveData<Player> = _player1
    val player2: LiveData<Player> = _player2
    val diceNumber: LiveData<Int> = _diceNumber

    //mac score: game will be finished when one of the player reaches this score
    val maxScore = 100


    /**
     * Call this function  when the player1 roll dice.
     */
    fun rollDiceForPlayer1() {
        rollDice(_player1.value!!, _player2.value!!)
    }

    /**
     * Call this function when the player2 roll dice.
     */

    fun rollDiceForPlayer2() {
        rollDice(_player2.value!!, _player1.value!!)
    }

    /**
     * call this function when the player 1 hold dice
     */
    fun holdDiceForPlayer1() {
        holdDice(_player1.value!!, _player2.value!!)
    }

    /**
     * call this function when the player 2 hold dice
     */
    fun holdDiceForPlayer2() {
        holdDice(_player2.value!!, _player1.value!!)
    }


    /**
     * This function handles the rolling event for specified users.
     */
    private fun rollDice(rolledPlayer: Player, otherPlayer: Player) {
        var _rolledPlayer = rolledPlayer
        var _otherPlayer = otherPlayer

        val randomScore = (Math.random() * 6).toInt() + 1

        if (randomScore != 1) {
            _rolledPlayer.currentScoreStack = _rolledPlayer.currentScoreStack.plus(randomScore)


        } else {

            //_rolledPlayer.totalScore = 0
            _rolledPlayer.currentScoreStack = 0
            _rolledPlayer.canRollDice = false
            _otherPlayer.canRollDice = true

        }

        _diceNumber.value = randomScore

        if (rolledPlayer.username == "Player 1") {
            _player1.value = _rolledPlayer
            _player2.value = _otherPlayer

        } else {
            _player1.value = _otherPlayer
            _player2.value = _rolledPlayer

        }
    }

    private fun holdDice(heldPlayer: Player, otherPlayer: Player) {
        var _heldPlayer = heldPlayer
        var _otherPlayer = otherPlayer

        _heldPlayer.totalScore = _heldPlayer.totalScore.plus(_heldPlayer.currentScoreStack)
        _heldPlayer.currentScoreStack = 0
        _heldPlayer.canRollDice = false

        _otherPlayer.canRollDice = true

        if (heldPlayer.username == "Player 1") {
            _player1.value = _heldPlayer
            _player2.value = _otherPlayer

        } else {

            _player2.value = _heldPlayer
            _player1.value = _otherPlayer

        }

        //controlling max score if it is reached..
        if(isMaxScoreReached(_heldPlayer)){
            Log.d("Winner","Winner is ${_heldPlayer.username}")
        }



    }

    private fun isMaxScoreReached(heldPlayer: Player):Boolean {
        return heldPlayer.totalScore >= maxScore
    }


}