package com.gdsc.eventribe.homeadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.eventribe.R
import com.example.eventribe.mainPageFragmentDirections
import com.gdsc.eventribe.homeadapter.FeaturedAdapter.FeaturedViewHolder
import java.util.*

class FeaturedAdapter(var featuredLocations: ArrayList<FeaturedhelperClass>) :
    RecyclerView.Adapter<FeaturedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.featured_card_design, parent, false)
        return FeaturedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeaturedViewHolder, position: Int) {
        val featuredhelperClass = featuredLocations[position]
        holder.image.setImageResource(featuredhelperClass.image)
        holder.title.text = featuredhelperClass.title
        holder.desc.text = featuredhelperClass.description
        holder.card.setOnClickListener {
            val action = mainPageFragmentDirections.actionMainPageFragmentToClubNameFragment()
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return featuredLocations.size
    }

    class FeaturedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var title: TextView
        var desc: TextView
        var card:CardView

        init {
            //hooks
            image = itemView.findViewById(R.id.featured_image1)
            title = itemView.findViewById(R.id.featured_title1)
            desc = itemView.findViewById(R.id.featured_desc1)
            card = itemView.findViewById(R.id.featuredClubs)
        }
    }
}