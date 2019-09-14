package dev.alexferreira.ui.view

import android.widget.ImageView
import dev.alexferreira.R
import dev.alexferreira.ui.contract.SplashContract
import org.junit.Assert.assertNotNull
import org.junit.Test

class SplashActivityRoboTest :
    AbstractRoboTest<SplashActivity, SplashContract.View, SplashContract.Presenter>(SplashActivity::class.java) {

    @Test
    fun whenStart_showAppBackground() {
        val image = activity.findViewById<ImageView>(R.id.iv_background)

        assertNotNull(image)
    }
}