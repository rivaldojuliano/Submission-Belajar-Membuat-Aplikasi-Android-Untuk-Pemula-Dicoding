package com.rivzdev.mysubmission.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rivzdev.mysubmission.R
import com.rivzdev.mysubmission.databinding.ActivityHomeBinding
import com.rivzdev.mysubmission.model.Food
import com.rivzdev.mysubmission.model.FoodData
import com.rivzdev.mysubmission.view.adapter.ListFoodAdapter

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var list: ArrayList<Food> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Daftar Makanan"

        binding.rvFood.setHasFixedSize(true)
        list.addAll(FoodData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        binding.rvFood.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListFoodAdapter(list)
        binding.rvFood.adapter = listFoodAdapter

        listFoodAdapter.setOnItemClickCallback(object : ListFoodAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Food) {
                showSelectedFood(data)
            }
        })
    }

    private fun showSelectedFood(data: Food) {
        val mIntent = Intent(this@HomeActivity, DetailActivity::class.java)
        mIntent.putExtra(DetailActivity.EXTRA_FOOD, data)
        startActivity(mIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectMode: Int) {
        when (selectMode) {
            R.id.action_about -> {
                val mIntent = Intent(this, AboutActivity::class.java)
                startActivity(mIntent)
            }
            R.id.action_favorite -> {
                val mIntent = Intent(this, FavoriteActivity::class.java)
                startActivity(mIntent)
            }
        }
    }
}