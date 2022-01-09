package com.example.mycontacts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eventribe.R

class ContactsAdapter(var contactList: List<Contacts>) :RecyclerView.Adapter<ContactsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        var itemView=
            LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item,parent,false)
        return ContactsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        var currentContact=contactList.get(position)
        //set att to the view displayed.Bind the data to the views
        holder.tvName.text=currentContact.name
        holder.tvEmail.text=currentContact.email


    }

    override fun getItemCount(): Int {
        return contactList.size

    }

}
class ContactsViewHolder( itemView: View): RecyclerView.ViewHolder(itemView){
    var tvName=itemView.findViewById<TextView>(R.id.tvName)
    var tvEmail=itemView.findViewById<TextView>(R.id.tvEmail)

}
