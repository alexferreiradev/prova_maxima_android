package dev.alexferreira.ui.view

import android.os.Bundle
import dev.alexferreira.R
import dev.alexferreira.ui.contract.DadosClienteContract

class DadosClienteActivity : AbstractView<DadosClienteContract.View, DadosClienteContract.Presenter>(),
    DadosClienteContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados_cliente)
    }

    override fun initViewPager() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setViewPagerPos(pos: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
