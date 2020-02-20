package com.codeinger.moviestack.utils

import android.view.View
import androidx.constraintlayout.widget.Group
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.text.SimpleDateFormat
import java.util.*

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun <T : ViewModel?> T.createFactory(): ViewModelProvider.Factory {
    val viewModel = this
    return object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T = viewModel as T
    }
}


fun Calendar.toFormattedDisplay(): String {
    val simpleDateFormat = SimpleDateFormat("dd-MMMM-yyyy hh:mm a", Locale.US)
    return simpleDateFormat.format(this.time)
}