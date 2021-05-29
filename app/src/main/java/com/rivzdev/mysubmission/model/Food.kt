package com.rivzdev.mysubmission.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    var name: String = "",
    var detail: String = "",
    var photo: Int= 0
): Parcelable