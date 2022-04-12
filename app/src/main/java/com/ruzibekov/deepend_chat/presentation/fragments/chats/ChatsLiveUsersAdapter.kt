package com.ruzibekov.deepend_chat.presentation.fragments.chats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ruzibekov.deepend_chat.R
import com.ruzibekov.deepend_chat.models.LiveUserModel

class ChatsLiveUsersAdapter(private val liveUsers: MutableList<LiveUserModel>) :
    RecyclerView.Adapter<ChatsLiveUsersAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_live_user, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.findViewById<ImageView>(R.id.image_live_user)
            .setBackgroundResource(liveUsers[position].image)

        holder.itemView.findViewById<TextView>(R.id.text_live_user).visibility =
            if (liveUsers[position].live)
                View.VISIBLE
            else
                View.GONE

        holder.itemView.findViewById<TextView>(R.id.text_username_live_user).text = liveUsers[position].username
    }

    override fun getItemCount() = liveUsers.size
}