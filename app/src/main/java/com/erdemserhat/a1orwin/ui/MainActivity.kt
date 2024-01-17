package com.erdemserhat.a1orwin.ui

import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.erdemserhat.a1orwin.R
import com.erdemserhat.a1orwin.data.GameViewModel
import com.erdemserhat.a1orwin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var gameViewModel: GameViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        // Obtain the ViewModel component.
       // val gameViewModel: GameViewModel by viewModels()
        gameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        // Inflate view and obtain an instance of the binding class.
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.lifecycleOwner = this

        // Assign the component to a property in the binding class.
        binding.viewmodel=gameViewModel















}}