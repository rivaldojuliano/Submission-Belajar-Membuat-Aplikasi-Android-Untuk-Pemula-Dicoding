package com.rivzdev.mysubmission.db

import android.provider.BaseColumns

internal class DatabaseContract {

    internal class FavoriteColumns: BaseColumns {

        companion object {
            const val TABLE_NAME = "favorite"
            const val NAME_FOOD = "name_food"
            const val PHOTO_FOOD = "photo_food"
        }
    }
}