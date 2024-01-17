package com.erdemserhat.a1orwin.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erdemserhat.a1orwin.model.Player

class GameViewModel : ViewModel() {
    private val _player1:MutableLiveData<Player> = MutableLiveData(Player(username = "Player 1", canRollDice = true))
    private val _player2:MutableLiveData<Player> = MutableLiveData(Player(username = "Player 2", canRollDice = false))
    private val _diceNumber:MutableLiveData<Int> = MutableLiveData(1)

    val player1:LiveData<Player> = _player1
    val player2:LiveData<Player> = _player2
    val diceNumber:LiveData<Int> = _diceNumber


    fun rollDiceForPlayer1(){
        val randomScore = (Math.random() * 6).toInt() + 1

        if (randomScore!=1){
            _player1.value?.currentScoreStack= _player1.value?.currentScoreStack?.plus(randomScore)!!

        }
        else{
            _player1.value?.currentScoreStack=0
            _player1.value?.totalScore=0;
            _player1.value!!.canRollDice=false
            _player2.value!!.canRollDice=true
            _player2.value= _player2.value!!.copy()
        }

        _diceNumber.value=randomScore
        _player1.value = _player1.value?.copy()
    }

    fun holdDiceForPlayer1(){
        Log.d("121","12")
        _player1.value?.totalScore=(_player1.value!!.currentScoreStack+ _player1.value!!.totalScore!!)
        _player1.value?.currentScoreStack=0;
        _player1.value?.canRollDice=false
        _player2.value?.canRollDice=true
        _player1.value = _player1.value?.copy()
        _player2.value= _player2.value!!.copy()

    }

    fun rollDiceForPlayer2(){
        val randomScore = (Math.random() * 6).toInt() + 1

        if (randomScore!=1){
            _player2.value?.currentScoreStack= _player2.value?.currentScoreStack?.plus(randomScore)!!

        }
        else{
            _player2.value?.currentScoreStack=0
            _player2.value?.totalScore=0;
            _player1.value!!.canRollDice=true
            _player2.value!!.canRollDice=false
            _player1.value = _player1.value?.copy()
            _player2.value= _player2.value!!.copy()
        }

        _diceNumber.value=randomScore
        _player1.value = _player1.value?.copy()
        _player2.value= _player2.value!!.copy()
    }

    fun holdDiceForPlayer2(){
        Log.d("121","12")
        _player2.value?.totalScore=(_player1.value!!.currentScoreStack+ _player1.value!!.totalScore!!)
        _player2.value?.currentScoreStack=0;
        _player2.value?.canRollDice=false
        _player1.value?.canRollDice=true
        _player1.value = _player1.value?.copy()
        _player2.value= _player2.value!!.copy()

    }




}