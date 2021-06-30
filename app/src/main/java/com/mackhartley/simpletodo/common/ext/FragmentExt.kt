package com.mackhartley.simpletodo.common.ext

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mackhartley.simpletodo.R

fun Fragment.showToast(msg: String, lengthShort: Boolean = true) {
    val length = if (lengthShort) Toast.LENGTH_SHORT else Toast.LENGTH_LONG
    Toast.makeText(context, msg, length).show()
}

fun Fragment.showError() {
    showToast(getString(R.string.network_error_msg), false)
}