package com.example.cats_ApiApp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dodopizza.R


class second_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent = intent

        val pizzaCost = intent.getStringExtra("pizzaCost")
        val pizzaName = intent.getStringExtra("pizzaName")
        val pizzaDescription = intent.getStringExtra("pizzaDescription")
        val pizzaImage = intent.getStringExtra("pizzaImage")
        val pizzaImageResId = intent.getIntExtra("pizzaImageResId", 0)

        val imageView : ImageView = findViewById(R.id.imageView)
        if (pizzaImage != null) {
            imageView.setImageResource(pizzaImage.toInt())
        }
        //app:srcCompat="@drawable/image1"
        val button : Button = findViewById(R.id.sec_price_button)

        val textPizzaName: TextView = findViewById(R.id.sec_text_name)
        val textPizzaDescription: TextView = findViewById(R.id.sec_desc_text)

        button.text = " В КОРЗИНУ ЗА $pizzaCost KZT"
        textPizzaName.text = pizzaName
        textPizzaDescription.text = pizzaDescription

        if (pizzaImageResId != 0) {
            imageView.setImageResource(pizzaImageResId)
        }

        val button2 : Button = findViewById(R.id.back_btn)
        button2.setOnClickListener {
            val intent1 = Intent(this, MainActivity::class.java)
            startActivity(intent1)
        }
    }
}