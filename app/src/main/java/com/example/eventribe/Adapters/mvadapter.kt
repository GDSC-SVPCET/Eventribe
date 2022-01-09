package com.gdsc.eventribe.mvadapteradapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eventribe.R
import com.gdsc.eventribe.mvadapter.mvhelperclass
import java.util.*

class mvadapter(var mostViewedLocations: ArrayList<mvhelperclass>) :
    RecyclerView.Adapter<mvadapter.MostViewedViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MostViewedViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.upcomming_cards, parent, false)
        return MostViewedViewHolder(view)
    }

    override fun onBindViewHolder(holder: MostViewedViewHolder, position: Int) {
        val mvhelperclass: mvhelperclass = mostViewedLocations[position]
        holder.imageView.setImageResource(mvhelperclass.images)
        holder.title.text= mvhelperclass.title
    }

    override fun getItemCount(): Int {
        return mostViewedLocations.size
    }

    class MostViewedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var title: TextView

        init {
            imageView = itemView.findViewById(R.id.mv_image)
            title = itemView.findViewById(R.id.mv_title)
        }
    }

}