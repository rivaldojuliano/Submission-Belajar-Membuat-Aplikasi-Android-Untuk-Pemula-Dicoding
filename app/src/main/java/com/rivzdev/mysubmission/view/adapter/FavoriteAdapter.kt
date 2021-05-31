package com.rivzdev.mysubmission.view.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rivzdev.mysubmission.databinding.ItemRowFavoriteBinding
import com.rivzdev.mysubmission.model.Food
import com.rivzdev.mysubmission.view.activity.DetailActivity

class FavoriteAdapter(private val activity: Activity): RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    var listFood = ArrayList<Food>()

        set(listFavorite) {
            if (listFavorite.size >= 0) {
                this.listFood.clear()
            }
            this.listFood.addAll(listFavorite)
            notifyDataSetChanged()
        }

    inner class FavoriteViewHolder(private val binding: ItemRowFavoriteBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(food.photo)
                    .apply(RequestOptions().override(100, 100))
                    .into(imgPhoto)

                tvName.text = food.name
                tvDetail.text = food.detail

                cvItemFavorite.setOnClickListener {
                    val mIntent = Intent(activity, DetailActivity::class.java)
                    mIntent.putExtra(DetailActivity.EXTRA_FOOD, food)
                    activity.startActivity(mIntent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding = ItemRowFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(listFood[position])
    }

    override fun getItemCount(): Int = listFood.size
}