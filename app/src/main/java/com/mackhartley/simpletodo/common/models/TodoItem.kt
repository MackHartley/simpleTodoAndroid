package com.mackhartley.simpletodo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TodoItem(
    val id: Int,
    val text: String
) : Parcelable {
    companion object {
        fun getDefault() = TodoItem(-1, "")
    }
}