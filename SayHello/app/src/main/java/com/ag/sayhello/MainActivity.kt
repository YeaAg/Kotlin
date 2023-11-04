package com.ag.sayhello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ag.sayhello.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSay.setOnClickListener {
            binding.textSay.text = "Hello Kotlin!"
        }
    }
}