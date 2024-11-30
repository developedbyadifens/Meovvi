package id.haonlabs.meovvi.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gallery(
    val imgUrl: String,
) : Parcelable
