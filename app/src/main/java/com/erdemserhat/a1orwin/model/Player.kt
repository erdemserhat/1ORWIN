package com.erdemserhat.a1orwin.model

data class Player(

    var luckMultiplier:Float=1f,
    val score:Float=0f,
    val username:String
):IPlayer{


    override fun rollDice():Int {
        return Lack.rollDice()

    }

    override fun hold() {

    }

    override fun luckMultiplierInitializer(){
        luckMultiplier=Lack.initializeMultiplier()

    }
}
