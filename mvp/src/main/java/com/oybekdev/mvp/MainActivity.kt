package com.oybekdev.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.view.isVisible
import com.oybekdev.mvp.databinding.ActivityMainBinding
import kotlin.concurrent.thread
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.generateRandom.setOnClickListener {
            binding.progressBar.isVisible = true
            getRandomNumber()
        }
    }

    fun getRandomNumber(){
       Handler().postDelayed({
           val random = Random
           binding.numberTv.text = random.nextInt(1000).toString()
           binding.progressBar.isVisible = false
       },2000)
    }
}