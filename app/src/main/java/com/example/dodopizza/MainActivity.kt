package com.example.dodopizza


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity(),ProductAdapter.ClickLisiner {
    var imagesName= arrayOf(
        Product(R.drawable.a,name="Баварская", description = "Острая чоризо из цыпленка, маринованные огурчики, красный лук, томаты, соус медово-горчичный, моцарелла, фирменный томатный соус","от 2700тг"),
        Product(R.drawable.b,name="Наруто Пицца", description = "Куриные кусочки, моцарелла, ананасы, фирменный соус альфредо, соус терияки","от 3900тг"),
        Product(R.drawable.c,name="Вау! Кебаб", description = "Кебаб из говядины, соус ранч, моцарелла, сладкий перец, томаты, красный лук, фирменный томатный соус","от 2900тг"),
        Product(R.drawable.d,name="Пепперони с грибами", description = "Пикантная пепперони из цыпленка, моцарелла, шампиньоны, фирменный соус альфредо","от 2000тг"),
        Product(R.drawable.e,name="Ветчина и огурчики", description = "Соус ранч, ветчина из цыпленка, моцарелла, маринованные огурчики, красный лук","от 2000тг"),
        Product(R.drawable.f,name="Миксик", description = "Пицца четвертинками с ветчиной, цыпленком, томатами, брынзой, моцареллой, фирменным соусом альфредо и набор юного садовода в подарок","от 2200тг"),
        Product(R.drawable.g,name="Пицца Жюльен", description = "Цыпленок, шампиньоны, соус сливочный с грибами, красный лук, чеснок, моцарелла, смесь сыров чеддер и пармезан, фирменный соус альфредо","от 2700тг"),
        Product(R.drawable.h,name="Сырная", description = "Моцарелла, сыры чеддер и пармезан, соус альфредо","от 1900тг"),
        Product(R.drawable.i,name="Пепперони фреш", description = "Пепперони из цыпленка, увеличенная порция моцареллы, томаты, томатный соус","от 1900тг"),
        Product(R.drawable.g,name="Двойной цыпленок", description = "Цыпленок, моцарелла, соус альфредо","от 2100тг")
    )
    val productModellist= arrayListOf<Product>()
    var productAdapter:ProductAdapter?=null
    var filteredList = arrayListOf<Product>()
    private lateinit var searchEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(items in imagesName){
            productModellist.add(items)
            filteredList = productModellist
        }

        productAdapter= ProductAdapter(this)
        productAdapter!!.setData(productModellist)

        val recyclerView: RecyclerView = findViewById(R.id.recView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = productAdapter

        searchEditText = findViewById(R.id.textInputEdit)

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No implementation needed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // No implementation needed
            }

            override fun afterTextChanged(s: Editable?) {
                performSearch()
            }
        })





    }




     override fun ClikedItem(product: Product) {
         val intent = Intent(this, second_activity::class.java).apply {
             putExtra("name", product.name)
             putExtra("description", product.description)
             putExtra("price", product.price)
             putExtra("image", product.img) // If you are passing image as resource ID
         }
         startActivity(intent)
     }

    private fun showPizzaList(list: List<Product>) {
        productAdapter?.setData(list)
    }

    private fun performSearch() {
        productAdapter?.filter(searchEditText.text.toString())
    }
}



