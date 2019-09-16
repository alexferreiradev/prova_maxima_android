package dev.alexferreira.ui.view

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import dev.alexferreira.R
import dev.alexferreira.ui.adapter.MainMenuAdapter
import dev.alexferreira.ui.contract.MainMenuContract
import dev.alexferreira.ui.model.MainMenuModel
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AbstractView<MainMenuContract.View, MainMenuContract.Presenter>(), MainMenuContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }

    override fun initAdapter(menuList: MutableList<MainMenuModel>) {
        recyclerView.adapter = MainMenuAdapter(applicationContext, menuList, object : MainMenuAdapter.Listener {
            override fun onMenuItemClick(mainMenuModel: MainMenuModel) {
                presenter.selectMenuItem(mainMenuModel)
            }
        })
        recyclerView.layoutManager =
            GridLayoutManager(applicationContext, resources.getInteger(R.integer.main_menu_grid_span))
    }

    override fun setVersionText(versionText: String) {
        tv_version.text = versionText
    }
}
