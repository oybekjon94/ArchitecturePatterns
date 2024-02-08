package com.oybekdev.mvp_02

import kotlin.random.Random

class RandomNumberModule:RandomNumberContract.Module {
    override fun getRandomNumber(onRandomNumberFinished: RandomNumberContract.Module.OnRandomNumberFinished) {
        android.os.Handler().postDelayed({
            val random = Random
            onRandomNumberFinished.numberReady(random.nextInt(2000))
        },2000)
    }
}