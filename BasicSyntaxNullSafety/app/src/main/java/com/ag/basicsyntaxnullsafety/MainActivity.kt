package com.ag.basicsyntaxnullsafety

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myName:String = "메시"
        var number:Int? = null  // 1. nullable : 변수를 정의할 때 ? 붙여서 null을 넣을 수 있는 상태야 해주는 것
        var newVariable: Activity? = null  //클래스(Activity)의 경우 --> 생성될지 아닐지 확정되지 않은 경우 null로 초기화하는 경우가 있음

        Log.d("Null Test", "문자열의 길이는=${myName.length}")

        //값이 null이 아닐 경우 class의 기능을 사용할 수 있음
        var number2:Int = 30
        var result1 = number2.plus(50)

        //값이 null일 경우 plus 사용 못함
        //number.plus(37)
        //Null Pointer Exception --> 방지하기 위해 나온 것이 nullsafety
        var result2 = number?.plus(37) ?: 51
        //2. ? : Safe Call
        // number = null 이면 ? 다음 코드 실행되지 않음 --> result2에는 null이 저장
        //3. Elvis Expression '?:' --> null일 경우 result2에 저장되는 기본갑 설정 가능

        var result3 = result2.plus(53)
    }
}