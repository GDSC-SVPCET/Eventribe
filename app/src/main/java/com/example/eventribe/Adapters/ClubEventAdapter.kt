package com.example.eventribe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eventribe.data.EventDataSource

class ClubEventAdapter: RecyclerView.Adapter<ClubEventViewHolder>() {
    private val list: List<com.example.eventribe.model.Event> = EventDataSource().getEvents()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubEventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.clubeventlistitem,parent,false)
        return ClubEventViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClubEventViewHolder, position: Int) {
        val item = list[position]
        holder.eventImage.setImageResource(item.image)
        holder.titleText.text = item.title
        holder.descriptionText.text = item.description
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class ClubEventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val eventImage:ImageView = itemView.findViewById(R.id.eventImage)
    val titleText: TextView = itemView.findViewById(R.id.titleText)
    val descriptionText:TextView = itemView.findViewById(R.id.descriptionText)
}