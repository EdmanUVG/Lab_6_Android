package com.example.lab_5_android.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_5_android.R
import com.example.lab_5_android.database.Guest

class GuestsAdapter: RecyclerView.Adapter<GuestsAdapter.ViewHolder>() {

    var data = listOf<Guest>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        val res = holder.itemView.context.resources
        holder.textName.text = item.name
        holder.textPhone.text = item.phone
        holder.textEmail.text = item.email
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.list_item_guest, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textName: TextView = itemView.findViewById(R.id.text_view_name)
        val textPhone: TextView = itemView.findViewById(R.id.text_view_phone)
        val textEmail: TextView = itemView.findViewById(R.id.text_view_email)

    }

    class TextItemViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}