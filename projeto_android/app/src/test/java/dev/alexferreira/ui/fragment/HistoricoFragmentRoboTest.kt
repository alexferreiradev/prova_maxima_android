package dev.alexferreira.ui.fragment

import android.support.constraint.ConstraintLayout
import android.view.View
import dev.alexferreira.R
import dev.alexferreira.application.RoboApp
import dev.alexferreira.ui.contract.DadosClienteContract
import org.jetbrains.anko.find
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = RoboApp::class)
class HistoricoFragmentRoboTest :
    AbstractFragmentRoboTest<AlvaraFragment, DadosClienteContract.AlvaraContract.FragView
            , DadosClienteContract.AlvaraContract.FragPresenter>(
        AlvaraFragment.newInstance("1")
    ) {

    @Test
    fun contract_showEmptyLayout_showEmpty() {
        contract.showEmptyLayout()

        val constraintLayout = fragment.view!!.find<ConstraintLayout>(R.id.empty_layout)
        Assert.assertEquals("Empty não esta visivel", View.VISIBLE, constraintLayout.visibility)
    }
}