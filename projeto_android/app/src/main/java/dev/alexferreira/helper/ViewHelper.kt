package dev.alexferreira.helper

import android.content.Context
import android.support.design.widget.TextInputEditText
import android.support.v4.app.FragmentManager
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.text.InputType
import android.view.View
import android.widget.TextView
import org.jetbrains.anko.toast

class ViewHelper {
    companion object {
        fun setTitle(toolbar: Toolbar, title: String) {
            toolbar.title = title
        }

        fun showErrorMsg(context: Context, msg: String) {
            context.toast(msg)
        }

        fun showSuccessMsg(context: Context, msg: String) {
            context.toast(msg)
        }

        fun getActivityName(mainActivity: AppCompatActivity): String {
            return mainActivity.javaClass.simpleName
        }

        fun setEmptyText(emptyView: TextView, value: String) {
            emptyView.text = value
        }

        fun showFirstHideSecond(firstView: View, secondView: View) {
            firstView.visibility = View.VISIBLE
            secondView.visibility = View.GONE
        }
    
        fun showFirstHideOthers(
                firstView: View,
                vararg views: View
        ) {
            firstView.visibility = View.VISIBLE
            views.forEach {
                it.visibility = View.GONE
            }
        }

        fun hideView(view: View?) {
            view?.visibility = View.GONE
        }

        fun setViewInvisible(view: View?) {
            view?.visibility = View.INVISIBLE
        }

        fun setViewVisible(view: View?) {
            view?.visibility = View.VISIBLE
        }

        fun setLinearLayoutToRV(recycler_view: RecyclerView, context: Context, reverse: Boolean) {
            recycler_view.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, reverse)
        }

        fun setViewEnabled(view: View, enabled: Boolean) {
            view.isEnabled = enabled
        }

        fun disableViews(vararg views: View) {
            views.forEach {
                it.isEnabled = false
            }
        }

        fun enableViews(vararg views: View) {
            views.forEach {
                it.isEnabled = true
            }
        }

        fun removeAllFragments(supportFragmentManager: FragmentManager) {
            val fragments = supportFragmentManager.fragments
            val beginTransaction = supportFragmentManager.beginTransaction()
            fragments.forEach {
                beginTransaction.remove(it)
            }
            beginTransaction.commit()
        }

        fun setTitle(toolbar: ActionBar?, title: String) {
            toolbar?.title = title
        }

        fun updateCoinEditTextValue(
            editText: TextInputEditText, text: String
        ) {
            editText.inputType = InputType.TYPE_CLASS_TEXT
            editText.setText(text)
            editText.setSelection(safeTextLenght(editText))
            editText.inputType = InputType.TYPE_CLASS_NUMBER.or(InputType.TYPE_NUMBER_FLAG_DECIMAL)
        }

        private fun safeTextLenght(editText: TextInputEditText) =
            if (editText.text.toString().isNotEmpty()) editText.text.toString().length - 1 else 0
    }
}