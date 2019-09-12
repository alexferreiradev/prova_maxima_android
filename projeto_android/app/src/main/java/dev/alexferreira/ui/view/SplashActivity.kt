package dev.alexferreira.ui.view

import android.os.Bundle
import android.os.Handler
import dev.alexferreira.R
import dev.alexferreira.ui.contract.SplashContract
import org.jetbrains.anko.intentFor

class SplashActivity : AbstractView<SplashContract.View, SplashContract.Presenter>(), SplashContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun openMainMenuView() {
        Handler().postDelayed(
            {
                startActivity(intentFor<MainMenuActivity>())
            }, 1000
        )
    }
}
