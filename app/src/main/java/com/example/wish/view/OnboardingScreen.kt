package com.example.wish.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.wish.MainActivity

import com.example.wish.databinding.ActivityOnboardingScreenBinding

open class OnboardingScreen : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOnboardingScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGotoMain.setOnClickListener{
            val username = binding.usernameTv.text.toString()
            if (username.isNotEmpty()){
// crete shared preference

                val sharedPreferences = getSharedPreferences("mypref",Context.MODE_PRIVATE)
                // object of shared preference
                val editor = sharedPreferences.edit()
// set data
                editor.putString("username", username)
                editor.apply()

                startActivity(Intent(/* packageContext = */ this, /* cls = */ MainActivity::class.java))
                finish()
            }

        }
    }
}