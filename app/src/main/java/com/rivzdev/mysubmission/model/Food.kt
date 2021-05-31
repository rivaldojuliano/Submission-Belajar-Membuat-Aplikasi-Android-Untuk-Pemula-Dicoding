package com.rivzdev.mysubmission.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    var name: String = "",
    var photo: Int= 0,
    var detail: String = ""

): Parcelable