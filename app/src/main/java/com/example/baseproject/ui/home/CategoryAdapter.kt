package com.example.baseproject.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseproject.databinding.ItemCategoryBinding

class CategoryAdapter(private val mContext: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mCategories = mutableListOf<Category>()

    fun updateData(categoryList: List<Category>) {
        this.mCategories.clear()
        this.mCategories.addAll(categoryList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount() = mCategories.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CategoryViewHolder) {
            val category = mCategories[holder.adapterPosition]
            holder.bind(category)
        }
    }

    class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            binding.categoryName.text = category.name
        }
    }
}