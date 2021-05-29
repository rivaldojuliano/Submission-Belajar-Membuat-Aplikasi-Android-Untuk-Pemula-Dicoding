package com.rivzdev.mysubmission.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.rivzdev.mysubmission.db.DatabaseContract.FavoriteColumns.Companion.NAME_FOOD
import com.rivzdev.mysubmission.db.DatabaseContract.FavoriteColumns.Companion.TABLE_NAME
import java.sql.SQLException

class FavoriteHelper(context: Context) {

    private var databaseHelper: DatabaseHelper = DatabaseHelper(context)
    private lateinit var database: SQLiteDatabase

    companion object {
        private const val DATABASE_TABLE = TABLE_NAME
        private var INSTANCES: FavoriteHelper? = null

        fun getInstance(context: Context): FavoriteHelper = INSTANCES ?: synchronized(this) {
            INSTANCES ?: FavoriteHelper(context)
        }
    }

    @Throws(SQLException::class)
    fun open() {
        database = databaseHelper.writableDatabase
    }

    fun queryAll(): Cursor {
        return  database.query(
            DATABASE_TABLE,
            null,
            null,
            null,
            null,
            null,
            "$NAME_FOOD ASC"
        )
    }

    fun queryById(id: String): Cursor {
        return database.query(
            DATABASE_TABLE,
            null,
            "$NAME_FOOD = ?",
            arrayOf(id),
            null,
            null,
            null,
            null
        )
    }

    fun insert(values: ContentValues?): Long {
        return database.insert(DATABASE_TABLE, null, values)
    }

    fun deleteById(id: String): Int {
        return database.delete(DATABASE_TABLE, "$NAME_FOOD = '$id'", null)
    }
}