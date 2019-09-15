package dev.alexferreira.ui.view

import android.os.Bundle
import android.view.MenuItem
import dev.alexferreira.R
import dev.alexferreira.data.model.Cliente
import dev.alexferreira.ui.adapter.DadosClienteViewPagerAdapter
import dev.alexferreira.ui.contract.DadosClienteContract
import kotlinx.android.synthetic.main.activity_dados_cliente.*

class DadosClienteActivity : AbstractView<DadosClienteContract.View, DadosClienteContract.Presenter>(),
    DadosClienteContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados_cliente)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item == null) {
            return false
        }
        return presenter.selectBottomNavItemMenu(item)
    }

    override fun initViewPager(cliente: Cliente) {
        viewPager.adapter = DadosClienteViewPagerAdapter(supportFragmentManager, cliente)
    }

    override fun setViewPagerPos(pos: Int) {
        viewPager.setCurrentItem(pos, true)
    }
}
