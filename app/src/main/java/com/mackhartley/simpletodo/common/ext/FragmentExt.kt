package com.mackhartley.simpletodo.common.ext

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mackhartley.simpletodo.R
import com.mackhartley.simpletodo.common.MainActivity

fun Fragment.showToast(msg: String, lengthShort: Boolean = true) {
    val length = if (lengthShort) Toast.LENGTH_SHORT else Toast.LENGTH_LONG
    Toast.makeText(context, msg, length).show()
}

fun Fragment.showError() {
    showToast(getString(R.string.network_error_msg), false)
}

/**
 * A better way to do this might be having a base Fragment class that has it's own loading
 * indicator. For now this solution will suffice.
 */
fun Fragment.setLoading(isLoading: Boolean) {
    val parentActivity = activity
    (parentActivity as? MainActivity)?.setLoading(isLoading)
}