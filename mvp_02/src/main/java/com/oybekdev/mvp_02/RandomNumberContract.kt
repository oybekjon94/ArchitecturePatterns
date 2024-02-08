package com.oybekdev.mvp_02

//contract
interface RandomNumberContract {
    interface MainView{
        fun showDialog()
        fun hideDialog()
        fun setRandomNumber(randomNumber:Int)
    }
    interface Presenter{
        fun onGenerateRandomNumberBtnClicked()
        fun onDestroy()
    }
    interface Module{
        interface OnRandomNumberFinished{
            fun numberReady(randomNumber: Int)
        }
        fun getRandomNumber(onRandomNumberFinished: OnRandomNumberFinished)
    }
}