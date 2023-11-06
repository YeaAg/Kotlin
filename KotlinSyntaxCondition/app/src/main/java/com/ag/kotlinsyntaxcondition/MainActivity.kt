package com.ag.kotlinsyntaxcondition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var first = 300
        var second = 500
        var third = 270

        //비교연산자 <, >, >=, <=, ==, !=
        var result1 = first < 500
        Log.d("compare","첫번째 결과=${result1}")
        var result2 = second < 500
        Log.d("compare","두번째 결과=${result2}")

        //논리연산자(비교연산자의 결과를 다시 한번 확인하기 위해 사용)
        var logic1 = result1 && result2  //둘다 true --> true
        Log.d("compare","논리연산 && 결과=${logic1}")
        var logic2 = result1 || result2  //둘개 중 하나라도 true --> true
        Log.d("compare","논리연산 || 결과=${logic2}")
        //부정연산자
        var logic3 = !result1
        Log.d("compare","논리연산 ! 결과=${logic3}")

        //if
        var out = 0
        var strike = 3
        if(strike > 2) {
            out = out + 1
        }
        Log.d("if", "결과 out=${out}")

        var month = 7
        if(month > 9) {
            Log.d("if","가을 옷을 입습니다.")
        } else if (month < 9 && month > 6){
            // 위의 if 조건을 만족하지 않았을 때 실행되는 코드블럭
            Log.d("if","해수욕장을 갑니다.")
        } else if (month < 7 && month > 3) {
            Log.d("if", "소풍을 갑니다.")
        } else {
            Log.d("if","집에 있습니다.")
        }

        //코틀린 when - if문의 확장판
        //위의 if문 --> when
        when(month) {
            9, 10, 11, 12 -> Log.d("if","가을 옷을 입습니다.")
            7, 8 -> {
                Log.d("when","해수욕장을 갑니다.")
            }
            in 4..6 -> {
                Log.d("when", "소풍을 갑니다.")
            }
            else -> {
                Log.d("when","집에 있습니다.")
            }
        }
    }
}