package com.example.recyclertask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CarAdapter (private val items: List<ItemCar>, private val onItemClick: (ItemCar) -> Unit) :
    RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val yearTextView: TextView = itemView.findViewById(R.id.yearTextView)

        fun bind(item: ItemCar) {
            Glide.with(itemView)
                .load(item.image)
                .into(imageView)

            nameTextView.text = item.name
            yearTextView.text = item.year

            itemView.setOnClickListener {
                onItemClick(item)
            }
        }
    }
}

