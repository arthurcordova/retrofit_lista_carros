package com.proway.retrofitapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.proway.retrofitapplication.endpoint.RetrofitBuilder
import com.proway.retrofitapplication.endpoint.ServiceUser
import com.proway.retrofitapplication.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity(), Callback<User> {

    lateinit var nameTextView: TextView
    lateinit var emailTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        loadComponents()

//        val userId = intent.getIntExtra("user_id", 0)
//        if (userId > 0) {
//
//        }

        User.listaUsuariosStatic()
        
        val callUser = RetrofitBuilder.getServiceUserInstance().getUser()
        callUser.enqueue(this)
    }

    private fun loadComponents() {
        nameTextView = findViewById(R.id.nameTextView)
        emailTextView = findViewById(R.id.emailTextView)
    }

    override fun onResponse(call: Call<User>, response: Response<User>) {
        response.body()?.apply {
            nameTextView.text = "${name.firstname} ${name.lastname}"
            emailTextView.text = email
        }
    }

    override fun onFailure(call: Call<User>, t: Throwable) {

    }
}