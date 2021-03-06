package com.rivzdev.mysubmission.view.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rivzdev.mysubmission.databinding.ActivityFavoriteBinding
import com.rivzdev.mysubmission.db.FavoriteHelper
import com.rivzdev.mysubmission.helper.MappingHelper
import com.rivzdev.mysubmission.model.Food
import com.rivzdev.mysubmission.view.adapter.FavoriteAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var adapter: FavoriteAdapter

    companion object {
        private const val EXTRA_STATE = "extra_state"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = " Daftar Favorit"

        binding.apply {
            rvFavorite.layoutManager = LinearLayoutManager(this@FavoriteActivity)
            rvFavorite.setHasFixedSize(true)
            adapter = FavoriteAdapter(this@FavoriteActivity)
            adapter.notifyDataSetChanged()
            rvFavorite.adapter = adapter
        }

        if (savedInstanceState == null) {
            loadFavoriteAsync()
        } else {
            val list = savedInstanceState.getParcelableArrayList<Food>(EXTRA_STATE)
            if (list != null) {
                adapter.listFood = list
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putParcelableArrayList(EXTRA_STATE, adapter.listFood)
    }

    private fun loadFavoriteAsync() {
        GlobalScope.launch(Dispatchers.Main) {
            showLoading(true)
            val favoriteHelper = FavoriteHelper.getInstance(applicationContext)
            favoriteHelper.open()
            val deferredFavorite = async(Dispatchers.IO) {
                val cursor = favoriteHelper.queryAll()
                MappingHelper.mapCursorToArrayList(cursor)
            }
            val favorite = deferredFavorite.await()
            showLoading(false)
            if (favorite.size > 0) {
                adapter.listFood = favorite
            } else {
                adapter.listFood = ArrayList()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        showLoading(true)
        loadFavoriteAsync()
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}