package dev.alexferreira.ui.view

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v4.view.ViewPager
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
        setSupportActionBar(toolbar)

        val drawable = ResourcesCompat.getDrawable(resources, R.drawable.ic_maxima_voltar, null) as BitmapDrawable
        val bitmapDrawable = BitmapDrawable(resources, Bitmap.createScaledBitmap(drawable.bitmap, 64, 64, true))
        supportActionBar?.setHomeAsUpIndicator(bitmapDrawable)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { onBackPressed() }
        bottomNavigationView.setOnNavigationItemSelectedListener {
            presenter.selectBottomNavItemMenu(it)
        }
    }

    override fun initViewPager(cliente: Cliente) {
        viewPager.adapter = DadosClienteViewPagerAdapter(supportFragmentManager, cliente)
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
                presenter.onPageSelected(p0)
            }
        })
    }

    override fun setAbTitle(title: Int) {
        supportActionBar?.setTitle(title)
    }

    override fun setViewPagerPos(pos: Int) {
        viewPager.setCurrentItem(pos, true)
    }

    override fun setBottomNavSelectedItem(itemId: Int) {
        bottomNavigationView.selectedItemId = itemId
    }
}
