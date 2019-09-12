package dev.alexferreira.ui.view

import android.os.Bundle
import dev.alexferreira.R
import dev.alexferreira.ui.contract.MainMenuContract

class MainMenuActivity : AbstractView<MainMenuContract.View, MainMenuContract.Presenter>(), MainMenuContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }
}
