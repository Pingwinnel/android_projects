package com.example.dodopizza

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgView: ImageView = itemView.findViewById(R.id.imageview)
        val nameView: TextView = itemView.findViewById(R.id.textview)
        val descView: TextView = itemView.findViewById(R.id.desc_textview)
        val buttonView:Button=itemView.findViewById(R.id.price_button)
        }
