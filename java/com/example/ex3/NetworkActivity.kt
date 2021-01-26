package com.example.ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_network.*

class NetworkActivity : AppCompatActivity() {


    var isChekedDone: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)




        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this, Observer { isConnect ->
            if (isConnect){
                layoutDisconnect.visibility = View.GONE
                layoutConnect.visibility = View.VISIBLE
            } else{

                layoutDisconnect.visibility = View.VISIBLE
                layoutConnect.visibility = View.GONE

            }

        })



    }
}