package com.ag.kotlinsyntaxstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ag.kotlinsyntaxstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var myName = "정예은"  //변수
        //Log.d(TAG,"my name =$myName")  //import alt+Enter
        myName = "홍길동"  //재정의 가능
        //Log.d(TAG,"my name =$myName")  //import alt+Enter

        val myAge = 19  //재정의 불가
        val PI = 3.141592  //상수, 주로 대문자로 선언
        //Log.d(TAG,"pi =$PI")  //import alt+Enter

        var myNumbers = "1,2,3,4,5,6"
        var thisWeekNumbers = "1,2,3,4,5,6"
        if(myNumbers == thisWeekNumbers){
            binding.textLog.text = "당첨되었습니다"  //화면출력
            //Log.d(TAG, "당첨되었습니다") //화면에 나오지 않음
        } else {
            binding.textLog.text = "당첨되지않았습니다"
            //Log.d(TAG, "당첨되지않았습니다")
        }

        for(index in 1..10){  //변수로 키워드(for, if 등)는 사용 불가
            binding.textLog.append("\n현재 숫자는 ${index}입니다")

            //Log.d(TAG, "현재 숫자는 ${index}입니다")
            //문자열 템플릿 사용 시 {}하지 않을 때에는 뒤에 한칸 띄우기
        }
    }
}