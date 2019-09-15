package dev.alexferreira.ui.fragment

import android.content.Context
import dev.alexferreira.ui.contract.DadosClienteContract
import dev.alexferreira.ui.view.DadosClienteActivity
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.robolectric.RuntimeEnvironment
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil

class DadosClienteFragmentRoboTest {

    private lateinit var fragment: DadosClienteFragment
    private lateinit var contract: DadosClienteContract.DadosClienteContract.FragView
    private lateinit var context: Context
    private lateinit var presenter: DadosClienteContract.DadosClienteContract.FragPresenter

    @Before
    fun setUp() {
        fragment = DadosClienteFragment.newInstance("1")
        val fragClass = DadosClienteActivity::class.java
        SupportFragmentTestUtil.startFragment(fragment, fragClass)
        context = RuntimeEnvironment.systemContext
    }

    @Test
    fun contract_create_callPresenter() {
        Mockito.verify(presenter).onViewCreated(contract, context, null)
    }
}