package com.ag.listener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.ag.listener.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            button.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    Log.d("리스너", "클릭되었습니다")
                }
            })
            //밑에거 처럼 해도 됨
            //button.setOnClickListener {
            //Log.d("리스너", "클릭되었습니다")

        }
    }
}