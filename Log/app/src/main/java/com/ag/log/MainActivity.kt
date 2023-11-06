package com.ag.log

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ag.log.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //로그(Log) : 코딩 할 때 코드의 흐름을 파악하기 위해 앱 외부에 출력하는 정보
        //로그캣(Logcat) : 출력되는 로그를 모아서 보는 도구
        binding.buttonLog.setOnClickListener {
            Log.d( TAG, "Hello Kotlin!!")
        }
    }
}