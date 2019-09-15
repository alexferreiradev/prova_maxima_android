package dev.alexferreira.ui.presenter.fragment

import android.os.Bundle
import dev.alexferreira.injection.scope.FragmentScope
import dev.alexferreira.ui.contract.DadosClienteContract
import javax.inject.Inject

@FragmentScope
class AlvaraFragPresenter @Inject constructor() :
    AbstractFragPresenter<DadosClienteContract.AlvaraContract.FragView>(),
    DadosClienteContract.AlvaraContract.FragPresenter {

    override fun onViewStarted(args: Bundle?) {
        super.onViewStarted(args)
        view.showEmptyLayout()
    }

    companion object {
        const val ARG_CLIENTE_ID = "cliente_id"
    }
}