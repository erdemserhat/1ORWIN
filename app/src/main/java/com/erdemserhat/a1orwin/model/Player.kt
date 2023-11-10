package com.erdemserhat.a1orwin.model

data class Player(

    var luckMultiplier:Float=1f,
    var totalScore:Float=0f,

    var currentScoreStack:Float=0f,
    val username:String?=null
):IPlayer{


    override fun rollDice(): Float {
        return Lack.rollDice()

    }

    override fun hold() {

    }

    override fun luckMultiplierInitializer(){
        luckMultiplier=Lack.initializeMultiplier()

    }

    override fun addScore(score:Float) {
        totalScore+=score

    }

    override fun resetTotalScore(){
        totalScore=0f;

    }

    override fun takeTotalScore(): Float {
        return totalScore

    }

    override fun isPlayer1():Boolean{
        return (username=="player1")

    }

    override fun isPlayer2():Boolean{
        return (username=="player2")
    }

    override fun addCurrentScoreStack(score: Float) {
        currentScoreStack+=score
    }

    override fun resetCurrentScoreStack() {
        currentScoreStack=0f

    }

    override fun bringCurrentScoreStack(): Float {
        return  currentScoreStack
    }


}
