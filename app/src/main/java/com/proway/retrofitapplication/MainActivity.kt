package com.proway.retrofitapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.retrofitapplication.adapter.AdapterMarcas
import com.proway.retrofitapplication.endpoint.RetrofitBuilder
import com.proway.retrofitapplication.model.Marca
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity(), Callback<List<Marca>> {

    private val adapterMarcas = AdapterMarcas()
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var errorMessage: TextView
    private val call by lazy {
        val service = RetrofitBuilder.getServiceCarInstance()
        service.buscarMarcas()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadComponent()

        call.enqueue(this)
    }

    fun loadComponent() {
        recyclerView = findViewById(R.id.listaDeMarcas)
        progressBar = findViewById(R.id.progressBar)
        errorMessage = findViewById(R.id.errorMessageTextView)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapterMarcas
    }

    override fun onResponse(call: Call<List<Marca>>, response: Response<List<Marca>>) {
        progressBar.visibility = View.GONE
        response.body()?.apply {
            adapterMarcas.update(this)
        }
    }

    override fun onFailure(call: Call<List<Marca>>, t: Throwable) {
        progressBar.visibility = View.GONE
        errorMessage.visibility = View.VISIBLE
    }
}
