package com.example.dodopizza

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter( private var products: ArrayList<Product>) :
        RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_view,parent,false)
        return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.nameView.text = product.name
        holder.descView.text = product.description
        holder.imgView.setImageResource(product.img)
                holder.buttonView.setText(product.price)
        }

        override fun getItemCount(): Int {
        return products.size
        }

        fun filterList(filteredList: ArrayList<Product>){
                this.products =filteredList;
                notifyDataSetChanged()

        }
        }
