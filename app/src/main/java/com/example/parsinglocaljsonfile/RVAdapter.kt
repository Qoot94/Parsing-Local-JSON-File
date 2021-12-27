package com.example.parsinglocaljsonfile


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.parsinglocaljsonfile.databinding.ItemRowBinding


class RVAdapter(
    private val Context: Context,
    private val container: ArrayList<String>
//    var onItemClick: ((Photo) -> Unit)? = null
) :
    RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    private var view: View? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        view = parent.rootView

        return ItemViewHolder(
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val cards = container[position]
        holder.binding.apply {
            Glide.with(Context).load(cards).into(ivResult)

        }
    }

    override fun getItemCount(): Int = container.size
}
