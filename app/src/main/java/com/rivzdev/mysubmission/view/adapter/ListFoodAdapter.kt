package com.rivzdev.mysubmission.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rivzdev.mysubmission.databinding.ItemRowFoodBinding
import com.rivzdev.mysubmission.model.Food

class ListFoodAdapter(private val listFood: ArrayList<Food>): RecyclerView.Adapter<ListFoodAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(private val binding: ItemRowFoodBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(food: Food) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(food.photo)
                    .apply(RequestOptions().override(100, 100))
                    .into(imgPhoto)

                tvName.text = food.name
                tvDetail.text = food.detail
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listFood[position])

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listFood[holder.bindingAdapterPosition]) }
    }

    override fun getItemCount(): Int = listFood.size

    interface OnItemClickCallback {
        fun onItemClicked(data: Food)
    }
}