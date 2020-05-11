package com.example.lab_5_android.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_5_android.R
import com.example.lab_5_android.database.Guest
import kotlinx.android.synthetic.main.guest_layout.view.*

class GuestsAdapter(val guests: List<Guest>): RecyclerView.Adapter<GuestsAdapter.GuestViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestsAdapter.GuestViewHolder {
        return GuestViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.guest_layout, parent, false)
        )
    }

    override fun getItemCount() = guests.size

    override fun onBindViewHolder(holder: GuestsAdapter.GuestViewHolder, position: Int) {
        holder.view.text_view_name.text = guests[position].name
        holder.view.text_view_phone.text = guests[position].phone
        holder.view.text_view_email.text = guests[position].email
    }

    class GuestViewHolder(val view:View) : RecyclerView.ViewHolder(view)
}