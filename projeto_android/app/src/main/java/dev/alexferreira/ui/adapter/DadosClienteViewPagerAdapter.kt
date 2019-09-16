package dev.alexferreira.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import dev.alexferreira.data.model.Cliente
import dev.alexferreira.ui.fragment.AlvaraFragment
import dev.alexferreira.ui.fragment.DadosClienteFragment
import dev.alexferreira.ui.fragment.HistoricoPedidoFragment
import timber.log.Timber

class DadosClienteViewPagerAdapter(
    fm: FragmentManager?,
    val cliente: Cliente
) : FragmentStatePagerAdapter(fm) {

    override fun getItem(pos: Int): Fragment {
        val clienteId = cliente.id.toString()
        val firstFragment = DadosClienteFragment.newInstance(clienteId = clienteId)
        when (pos) {
            DADOS_CLIENTE_POS -> {
                return firstFragment
            }
            HISTORICO_PEDIDOS_POS -> {
                return HistoricoPedidoFragment.newInstance(clienteId = clienteId)
            }
            ALVARA_POS -> {
                return AlvaraFragment.newInstance(clienteId = clienteId)
            }
            else -> {
                Timber.e("Não foi implementado fragment no adapter do VP: $pos. Será retornado o primeiro fragment criado como default")
                return firstFragment
            }
        }
    }

    override fun getCount(): Int {
        return TOTAL_ITEMS
    }

    companion object {
        private const val TOTAL_ITEMS = 3

        const val DADOS_CLIENTE_POS = 0
        const val HISTORICO_PEDIDOS_POS = 1
        const val ALVARA_POS = 2
    }
}