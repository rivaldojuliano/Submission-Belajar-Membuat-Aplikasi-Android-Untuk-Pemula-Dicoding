package com.rivzdev.mysubmission.helper

import android.database.Cursor
import com.rivzdev.mysubmission.db.DatabaseContract
import com.rivzdev.mysubmission.model.Food

object MappingHelper {

    fun mapCursorToArrayList(favoriteCursor: Cursor?): ArrayList<Food> {

        val favoriteList = ArrayList<Food>()

        favoriteCursor?.apply {
            while (moveToNext()) {
                val nameFood = getString(getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.NAME_FOOD))
                val photoFood = getString(getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.PHOTO_FOOD))
                favoriteList.add(Food(nameFood, photoFood))
            }
        }
        return favoriteList
    }
}