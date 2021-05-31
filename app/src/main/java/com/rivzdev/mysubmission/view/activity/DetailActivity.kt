package com.rivzdev.mysubmission.view.activity

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rivzdev.mysubmission.R
import com.rivzdev.mysubmission.databinding.ActivityDetailBinding
import com.rivzdev.mysubmission.db.DatabaseContract
import com.rivzdev.mysubmission.db.FavoriteHelper
import com.rivzdev.mysubmission.helper.MappingHelper
import com.rivzdev.mysubmission.model.Food

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var favoriteHelper: FavoriteHelper
    private var statusFavorite = false

    companion object {
        const val EXTRA_FOOD = "extra_food"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val food = intent.getParcelableExtra<Food>(EXTRA_FOOD) as Food

        favoriteHelper = FavoriteHelper.getInstance(applicationContext)
        favoriteHelper.open()

        supportActionBar?.title = food.name

        val values = ContentValues()
        values.put(DatabaseContract.FavoriteColumns.NAME_FOOD, food.name)
        values.put(DatabaseContract.FavoriteColumns.PHOTO_FOOD, food.photo)
        values.put(DatabaseContract.FavoriteColumns.FOOD_DETAIL, food.detail)

        binding.apply {
            imgPhoto.setImageResource(food.photo)
            tvName.text = food.name
            tvDetail.text = food.detail
        }

        binding.btnFavorite.setOnClickListener {
            if (!statusFavorite) {
                statusFavorite = !statusFavorite
                favoriteHelper.insert(values)
                setStatusFavorite(statusFavorite)
            } else {
                statusFavorite = !statusFavorite
                favoriteHelper.deleteById(food.name)
                setStatusFavorite(statusFavorite)
            }
        }

        val cursor = favoriteHelper.queryById(food.name)
        if (cursor.moveToNext()) {
            statusFavorite = true
            MappingHelper.mapCursorToArrayList(cursor)
            cursor.close()
            setStatusFavorite(statusFavorite)
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.btnFavorite.setImageResource(R.drawable.ic_favorite_checked)
        } else {
            binding.btnFavorite.setImageResource(R.drawable.ic_favorite_unchecked)
        }
    }
}