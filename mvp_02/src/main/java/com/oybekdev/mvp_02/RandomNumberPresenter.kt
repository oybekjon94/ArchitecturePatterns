package com.oybekdev.mvp_02

class RandomNumberPresenter(view:RandomNumberContract.MainView):RandomNumberContract.Presenter,
    RandomNumberContract.Module.OnRandomNumberFinished {
    var mainView:RandomNumberContract.MainView? = null
    val module = RandomNumberModule()

    init {
        mainView = view
    }

    override fun onGenerateRandomNumberBtnClicked() {
        mainView?.showDialog()
        module.getRandomNumber(this)
    }

    override fun onDestroy() {
        mainView = null
    }

    override fun numberReady(randomNumber: Int) {
        mainView?.hideDialog()
        mainView?.setRandomNumber(randomNumber)
    }
}