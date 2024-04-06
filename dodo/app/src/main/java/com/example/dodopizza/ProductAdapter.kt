package com.example.dodopizza


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dodopizza.ProductAdapter.ProductAdapterVH


class ProductAdapter(var clickLisiner: ClickLisiner) : RecyclerView.Adapter<ProductAdapterVH>() {

        var productModelsList = ArrayList<Product>();

        fun setData(productModelsList: List<Product>) {
                this.productModelsList = productModelsList as ArrayList<Product>;
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapterVH {
                return ProductAdapterVH(
                        LayoutInflater.from(parent.context)
                                .inflate(R.layout.product_view, parent, false)
                );
        }

        override fun getItemCount(): Int {
                return productModelsList.size
        }

        override fun onBindViewHolder(holder: ProductAdapterVH, position: Int) {
                val productModal = productModelsList[position];
                holder.name.text = productModal.name
                holder.name.text = productModal.name
                holder.desc.text = productModal.description
                holder.image.setImageResource(productModal.img)
                holder.price.setText(productModal.price)
                holder.itemView.setOnClickListener {
                        val intent = Intent(holder.itemView.context, second_activity::class.java)
                        intent.putExtra("pizzaName", productModal.name)
                        intent.putExtra("pizzaDescription", productModal.description)
                        intent.putExtra("pizzaImageResId", productModal.img)
                        intent.putExtra("pizzaCost", productModal.price)
                        holder.itemView.context.startActivity(intent)
                }
        }


        class ProductAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
                val name: TextView = itemView.findViewById(R.id.text_name)
                val desc: TextView = itemView.findViewById(R.id.desc_text)
                val image: ImageView = itemView.findViewById(R.id.imageview)
                val price: TextView = itemView.findViewById<TextView?>(R.id.price_button)

        }

        interface ClickLisiner {
                fun ClikedItem(product: Product)
        }

        fun filter(searchText: String) {
                val filteredList =
                        productModelsList.filter { it.name.contains(searchText, ignoreCase = true) }
                setData(filteredList)
        }

}

