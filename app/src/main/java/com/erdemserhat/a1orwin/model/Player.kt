package com.erdemserhat.a1orwin.model

data class Player(

    var luckMultiplier:Float=1f,
    var totalScore:Float=0f,
    val username:String
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


}
