package com.example.cats_ApiApp
import android.os.Bundle
import android.util.Log
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cats_ApiApp.models.CatsModel
import com.example.cats_ApiApp.network.CatsService
import com.example.dodopizza.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    var BASE_URL="https://api.api-ninjas.com/v1/"
    lateinit var binding:ActivityMainBinding
    lateinit var adapter: CatAdapter
    var API_KEY="hhCMpDRCk79f72MYWENpvg==d9R0zB2SZsSzepkQ"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter= CatAdapter()
        binding.recView.layoutManager= LinearLayoutManager(this)
        binding.recView.adapter=adapter



        val intercertor=HttpLoggingInterceptor()
        intercertor.level=HttpLoggingInterceptor.Level.BODY

        var cleint =OkHttpClient.Builder()
            .addInterceptor(intercertor)
            .build()

        var retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(cleint)
            .build()


        var mainApi=retrofit.create(CatsService::class.java)

        binding.searchView2.setOnQueryTextListener (object : OnQueryTextListener{
            override fun onQueryTextSubmit(text: String?): Boolean {
                var retroData=mainApi.getCatbyName(text,API_KEY)
                retroData.enqueue(object : Callback<List<CatsModel>> {
                    override fun onResponse(
                        call: Call<List<CatsModel>>,
                        response: Response<List<CatsModel>>
                    ) {
                        var data=response.body()
                        if (data != null) {
                            if(data.isEmpty())
                                Toast.makeText(baseContext,"Cat doesn`t exist",Toast.LENGTH_SHORT).show()
                        }

                        CoroutineScope(Dispatchers.IO).launch {
                            runOnUiThread{
                                binding.apply {
                                    adapter.submitList(data)
                                }
                            }
                        }

                        Log.d("data",data.toString())
                    }

                    override fun onFailure(call: Call<List<CatsModel>>, t: Throwable) {
                    Log.e("ApiError",t.message.toString())
                       Toast.makeText(baseContext,"Cat doesn`t exist",Toast.LENGTH_SHORT).show()
                    }

                })
               return true
            }

            override fun onQueryTextChange(text: String?): Boolean {

                return true
            }

        })


    }



}
