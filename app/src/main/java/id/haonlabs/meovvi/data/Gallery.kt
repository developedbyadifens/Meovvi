package id.haonlabs.meovvi.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name: String,
    val job: String,
    val age: Int,
) : Parcelable
