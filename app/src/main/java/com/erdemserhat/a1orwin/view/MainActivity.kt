package com.erdemserhat.a1orwin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.erdemserhat.a1orwin.R
import com.erdemserhat.a1orwin.controller.Constants
import com.erdemserhat.a1orwin.controller.GameEngine
import com.erdemserhat.a1orwin.databinding.ActivityMainBinding
import com.erdemserhat.a1orwin.model.IPlayer
import com.erdemserhat.a1orwin.model.Player

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var gameEngine: GameEngine
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        initializeConstants()
        gameEngine=GameEngine()

        binding.player1rollDice.setOnClickListener {
            gameEngine.roll(Constants.player1)
        }

        binding.player2RollDice.setOnClickListener {
            gameEngine.roll(Constants.player2)
        }








    }

    fun initializeConstants(){
        Constants.defineConstants(binding, Player(username = "player1"),Player(username = "player2"))
    }


}