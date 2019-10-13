package com.example.crabtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_rakuten.*

class AppmovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appmovie)

        button.setOnClickListener {
            val intent = Intent(this, RakutenActivity::class.java)
            startActivity(intent)
        }
    }
}
