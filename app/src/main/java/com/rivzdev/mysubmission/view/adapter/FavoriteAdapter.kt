package com.rivzdev.mysubmission.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rivzdev.mysubmission.databinding.ItemRowFoodBinding
import com.rivzdev.mysubmission.model.Food

class FavoriteAdapter: RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    var listFood = ArrayList<Food>()

        set(listFavorite) {
            if (listFavorite.size >= 0) {
                this.listFood.clear()
            }
            this.listFood.addAll(listFavorite)
            notifyDataSetChanged()
        }

    inner class FavoriteViewHolder(private val binding: ItemRowFoodBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(food.detail)
                    .apply(RequestOptions().override(100, 100))
                    .into(imgPhoto)

                tvName.text = food.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding = ItemRowFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(listFood[position])
    }

    override fun getItemCount(): Int = listFood.size
}