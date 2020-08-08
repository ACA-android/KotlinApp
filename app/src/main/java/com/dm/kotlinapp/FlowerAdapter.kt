package com.dm.kotlinapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FlowerAdapter(private val data: List<Flower> = mutableListOf()) : RecyclerView.Adapter<FlowerAdapter.ViewHolder>() {

    private var onItemClickListener: (flower: Flower) -> Unit = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_flower, parent, false))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        data[position].let { flower ->
            holder.apply {
                image.setImageResource(flower.imageRes)
                text.text = flower.name
                text.setBackgroundColor(flower.color)
                itemView.setOnClickListener {
                    onItemClickListener(flower)
                }
            }
        }
    }

    fun setOnItemClickListener(l: (flower: Flower) -> Unit) {
        onItemClickListener = l
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
        val text: TextView = itemView.findViewById(R.id.flowerTextView)
    }
}