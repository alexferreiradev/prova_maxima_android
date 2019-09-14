package dev.alexferreira.ui.view

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import dev.alexferreira.R
import dev.alexferreira.ui.contract.MainMenuContract
import org.hamcrest.Matchers
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito


class MainMenuActivityRoboTest :
    AbstractRoboTest<MainMenuActivity, MainMenuContract.View, MainMenuContract.Presenter>(MainMenuActivity::class.java) {

    @Before
    override fun setUp() {
        super.setUp()
        startMenuList()
    }

    @Test
    fun selectMenuItem_callPresenter() {
        val recyclerView = activity.findViewById<RecyclerView>(R.id.recyclerView)
        initRecyclerViewLenght(recyclerView)
        val viewHolder = recyclerView.findViewHolderForLayoutPosition(0)!!
        viewHolder.itemView.performClick()

        Mockito.verify(presenter).selectMenuItem()
    }

    @Test
    fun initMenuAdapterList() {
        val recyclerView = activity.findViewById<RecyclerView>(R.id.recyclerView)

        Assert.assertNotNull(recyclerView.adapter)
        Assert.assertNotNull(recyclerView.layoutManager)
        Assert.assertThat(
            recyclerView.layoutManager!!.javaClass.name,
            Matchers.`is`(GridLayoutManager::class.java.name)
        )
    }

    private fun startMenuList() {
        view.initAdapter()
    }
}