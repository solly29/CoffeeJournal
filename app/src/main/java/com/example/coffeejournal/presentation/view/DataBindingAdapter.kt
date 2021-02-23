package com.example.coffeejournal.presentation.view

import android.annotation.SuppressLint
import android.app.Activity
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.coffeejournal.R
import com.example.coffeejournal.domain.model.AppBarData
import com.example.coffeejournal.presentation.viewmodel.JoinViewModel


@BindingAdapter("toolBarLeftButton")
fun toolBarLeftButton(view: ImageView, resId: Int?) {
    resId?.let {
        view.setImageResource(it)
        view.setOnClickListener { (view.context as Activity).onBackPressed() }
    }
}

@BindingAdapter("toolBarRightButton")
fun toolBarRightButton(view: ImageView, appBarData: AppBarData) {
    appBarData.rightIcon?.let { view.setImageResource(it) }
    view.setOnClickListener { appBarData.rightIconClickListener?.invoke() }
}