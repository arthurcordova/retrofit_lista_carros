package com.proway.retrofitapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.proway.retrofitapplication.endpoint.RetrofitBuilder
import com.proway.retrofitapplication.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(), Callback<List<User>> {

    private lateinit var inputEmail: EditText

    private val call by lazy {
        val service = RetrofitBuilder.getServiceUserInstance()
        service.getAll()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loadComponents()

    }

    private fun loadComponents() {

        inputEmail = findViewById(R.id.inputEmail)
        findViewById<Button>(R.id.buttonLogin).apply {
            setOnClickListener { login() }
        }

    }

    private fun login() {
        call.clone().enqueue(this)
    }

    override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
        val user = response.body()?.let { listOfUsers ->
            listOfUsers.first { inputEmail.text.toString() == it.email }
        }
        if (user != null) {
            Intent(this, UserActivity::class.java).apply {
                putExtra("user_id", user.id)
                startActivity(this)
            }
        } else {
            println("Não existe user")
        }
    }

    override fun onFailure(call: Call<List<User>>, t: Throwable) {
        println("Falha no request")
    }
}