package com.erdemserhat.a1orwin.model

data class Player(
    var totalScore:Int=0,
    var currentScoreStack:Int=0,
    val username:String ="",
    var canRollDice:Boolean,
    var isWinner:Boolean = false
)