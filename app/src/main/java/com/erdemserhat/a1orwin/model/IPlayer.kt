package com.erdemserhat.a1orwin.model

interface IPlayer {
    fun rollDice():Float
    fun hold()
    fun luckMultiplierInitializer()

    fun addScore(score:Float)

    fun resetTotalScore()

    fun takeTotalScore():Float

    fun isPlayer1():Boolean
    fun isPlayer2():Boolean



}