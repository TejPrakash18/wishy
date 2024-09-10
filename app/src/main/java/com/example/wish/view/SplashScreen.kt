package com.example.wish.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.wish.MainActivity
import com.example.wish.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            //create shared preference
            val sharedPreferences = getSharedPreferences("mypref",Context.MODE_PRIVATE)
            //get data
            val username = sharedPreferences.getString("username", null)
            //check condition base launched activity
            if (username.isNullOrBlank()) {
                startActivity(Intent(this, OnboardingScreen::class.java))

            }else{
                startActivity(Intent(this, MainActivity::class.java))

            }

            finish()
        },1500) // 1.5 sec

    }
}