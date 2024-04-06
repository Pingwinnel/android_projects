package com.example.cats_ApiApp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cats_ApiApp.models.CatsModel
import com.example.dodopizza.R
import com.example.dodopizza.databinding.ProductViewBinding


class CatAdapter:ListAdapter<CatsModel,CatAdapter.ViewHolder>(Comparator()) {
class ViewHolder(view:View):RecyclerView.ViewHolder(view){

        private var databind=ProductViewBinding.bind(view)

        fun bind(catsModel: CatsModel)= with(databind){
                textName.text="Name:"+catsModel.name
                textOrigin.text="Origin: "+catsModel.origin
                textLength.text="Length: "+catsModel.length
                textMaxLife.text="Max life expectancy: "+catsModel.maxLifeExpectancy
                Glide.with(imageview.context)
                        .load(catsModel.imageLink)
                        .into(imageview)
        }
}
class Comparator:DiffUtil.ItemCallback<CatsModel>(){
        override fun areItemsTheSame(oldItem: CatsModel, newItem: CatsModel): Boolean {
                return oldItem.name==newItem.name
        }

        override fun areContentsTheSame(oldItem: CatsModel, newItem: CatsModel): Boolean {
                return oldItem==newItem
        }

}
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                var view=LayoutInflater.from(parent.context).inflate(R.layout.product_view,parent,false)
                return ViewHolder(view)
        }



        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                holder.bind(getItem(position))
        }

}