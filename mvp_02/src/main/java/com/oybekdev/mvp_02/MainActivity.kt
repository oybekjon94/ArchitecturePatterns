package com.oybekdev.mvp_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.oybekdev.mvp_02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),RandomNumberContract.MainView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter : RandomNumberPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = RandomNumberPresenter(this)

        binding.randomBtn.setOnClickListener {
            presenter.onGenerateRandomNumberBtnClicked()
        }

    }

    override fun showDialog() {
        binding.progressBar.isVisible = true
    }

    override fun hideDialog() {
        binding.progressBar.isVisible = false

    }

    override fun setRandomNumber(randomNumber: Int) {
        binding.randomNumTv.text = randomNumber.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}