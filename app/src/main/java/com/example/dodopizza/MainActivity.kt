package com.example.dodopizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dodopizza.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView;
    lateinit var binding:ActivityMainBinding;
    lateinit var adapter: ProductAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)





        recyclerView = findViewById(R.id.recyclerview_pizzalist)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)



        imageId = arrayListOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
        )
        nameing = arrayListOf(
            "Bavarian",
            "Наруто Пицца",
            "Вау! Кебаб",
            "Пепперони с грибами",
            "Ветчина и огурчики",
            "Миксик",
            "Пицца Жюльен",
            "Сырная",
            "Пепперони фреш",
            "Двойной цыпленок"
        )
        descList = arrayListOf(
            "Острая чоризо из цыпленка, маринованные огурчики, красный лук, томаты, соус медово-горчичный, моцарелла, фирменный томатный соус",
            "Куриные кусочки, моцарелла, ананасы, фирменный соус альфредо, соус терияки",
            "Кебаб из говядины, соус ранч, моцарелла, сладкий перец, томаты, красный лук, фирменный томатный соус",
            "Пикантная пепперони из цыпленка, моцарелла, шампиньоны, фирменный соус альфредо",
            "Соус ранч, ветчина из цыпленка, моцарелла, маринованные огурчики, красный лук",
            "Пицца четвертинками с ветчиной, цыпленком, томатами, брынзой, моцареллой, фирменным соусом альфредо и набор юного садовода в подарок",
            "Цыпленок, шампиньоны, соус сливочный с грибами, красный лук, чеснок, моцарелла, смесь сыров чеддер и пармезан, фирменный соус альфредо",
            "Моцарелла, сыры чеддер и пармезан, соус альфредо",
            "Пепперони из цыпленка, увеличенная порция моцареллы, томаты, томатный соус",
            "Цыпленок, моцарелла, соус альфредо"
        )
        priceList = arrayListOf(
            "от 2700тг",
            "от 3900тг",
            "от 2900тг",
            "от 2000тг",
            "от 2000тг",
            "от 2200тг",
            "от 2700тг",
            "от 1900тг",
            "от 1900тг",
            "от 2100тг"
        )


        adapter = ProductAdapter(ArrayList())

        recyclerView = findViewById(R.id.recyclerview_pizzalist);
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)


        binding.se.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(s: Editable?) {
                filter(s.toString(),adapter)
            }
        })

        newList = arrayListOf<Product>()
        getUserdata()


    }

    lateinit var newList: ArrayList<Product>;
    lateinit var imageId: ArrayList<Int>;
    lateinit var nameing: ArrayList<String>;
    lateinit var descList: ArrayList<String>;
    lateinit var priceList: ArrayList<String>

    fun filter (text:String ,adapter: ProductAdapter){
        val filteredlist:ArrayList<Product> = ArrayList()
        for(eachProduct in newList){
            if(eachProduct.name.toLowerCase().contains(text.toLowerCase())){
                filteredlist.add(eachProduct)
            }
        }
        adapter.filterList(filteredlist)
    }

    private fun getUserdata(){
        for (i in imageId.indices) {
            val products = Product(imageId[i], nameing[i], descList[i], priceList[i])
            newList.add(products);
        }
        recyclerView.adapter=ProductAdapter(newList)
    }



}



