package com.erdemserhat.a1orwin.controller

import com.erdemserhat.a1orwin.databinding.ActivityMainBinding
import com.erdemserhat.a1orwin.model.Player

class Constants(

) {


    companion object {
        lateinit var player1:Player
        lateinit var player2:Player
        lateinit var binding:ActivityMainBinding

        fun defineConstants(
            binding: ActivityMainBinding,
            player1: Player,
            player2: Player

        ) {
            this.player1=player1
            this.player2=player2
            this.binding=binding


        }


    }
}