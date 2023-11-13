package com.erdemserhat.a1orwin.view

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.pm.ActivityInfo
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import android.os.Vibrator
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.erdemserhat.a1orwin.controller.Constants
import com.erdemserhat.a1orwin.controller.GameEngine
import com.erdemserhat.a1orwin.controller.HardwareOperations
import com.erdemserhat.a1orwin.databinding.ActivityMainBinding
import com.erdemserhat.a1orwin.model.Player


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var gameEngine: GameEngine
    private lateinit var vibrator: Vibrator;
    private lateinit var context: Context

    // sensor manager and our sensor.
    var sensorManager: SensorManager? = null
    var proximitySensor: Sensor? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        context = applicationContext
        setContentView(view)
        /**
         * You can either set screen orientation below way or AndroidManifest.xml
         */

        //this.requestedOrientation=ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        //this.requestedOrientation=ActivityInfo.SCREEN_ORIENTATION_LOCKED
        initializeConstants()
        HardwareOperations.initalizeHardwareOperations(context)

        gameEngine = GameEngine(applicationContext)

        binding.player1rollDice.setOnClickListener {
            gameEngine.roll(Constants.player1)
        }

        binding.player2RollDice.setOnClickListener {
            gameEngine.roll(Constants.player2)
        }

        binding.player1Hold.setOnClickListener {
            gameEngine.hold(Constants.player1)
        }

        binding.player2HoldDice.setOnClickListener {
            gameEngine.hold(Constants.player2)
        }

        binding.newGame.setOnClickListener {
            gameEngine.newGame()
        }







    }

    fun initializeConstants() {
        Constants.defineConstants(
            binding, Player(username = "player1"), Player(username = "player2")
        )
    }
}