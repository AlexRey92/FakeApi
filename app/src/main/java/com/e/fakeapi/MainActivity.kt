package com.e.fakeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter:ProductAdapter

    var listaDeProductos= listOf<ProductsOb>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ProductAdapter()
        recyclerView.adapter = adapter

        geRetrofit()
        getListaProductos()
    }

    private fun getListaProductos() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = geRetrofit().create(ApiService::class.java).getProduct()
            val response = call.body()
            runOnUiThread {
                if (call.isSuccessful) {
                   response?.apply {
                       listaDeProductos = this.map { Products-> Products.mapProduct() }
                       with(adapter) {
                           submitList(listaDeProductos)
                       }
                   }
                }
            }
        }
    }

    private fun geRetrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    
    companion object{
        const val URL_API = "https://fakestoreapi.com/"
    }
}