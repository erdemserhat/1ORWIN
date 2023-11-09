package com.erdemserhat.a1orwin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.erdemserhat.a1orwin.R
import com.erdemserhat.a1orwin.controller.Constants
import com.erdemserhat.a1orwin.databinding.ActivityMainBinding
import com.erdemserhat.a1orwin.model.IPlayer

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

    }


}