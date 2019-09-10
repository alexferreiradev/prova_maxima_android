package dev.alexferreira.ui.view

import android.os.Bundle
import dev.alexferreira.R
import dev.alexferreira.ui.contract.SplashContract

class SplashActivity : AbstractView<SplashContract.View, SplashContract.Presenter>(), SplashContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}
