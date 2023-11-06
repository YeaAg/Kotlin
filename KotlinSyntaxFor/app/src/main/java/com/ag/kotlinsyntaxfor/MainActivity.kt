package com.ag.kotlinsyntaxfor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.selects.whileSelect

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //컬렉션과 반복문의 사용
        var intArray = intArrayOf(0,10,20,30,40,50,60,70,80)

        for ( value in intArray ){
            Log.d("반복문", "value=${value}")
        }

        //for
        //일반적으로 몇 번의 횟수를 반복하는 형태
        for ( index in 1..10 ) {
            //Log.d("반복문", "index=${index}")
        }

        for ( index in 1 until 10 ) { //마지막 10은 제외
            //Log.d("반복문", "index=${index}")
        }

        for ( index in 1 until 10 step 2 ) { // 1 3 5 7 9
            //Log.d("반복문", "index=${index}")
        }

        for ( index in 10 downTo 1 ) { // 10 ~ 1
            //Log.d("반복문", "index=${index}")
        }

        for ( index in 10 downTo 1 step 2 ) { // 10 8 6 4 2
            //Log.d("반복문", "index=${index}")
        }

        // while
        var out = 3
        while (out < 3) {  //조건이 들어가는 ()에 true를 하면 무한루프
            Log.d("while","현재 out 카운트 = ${out}")
            out = out + 1
        }

        do {  //조건이 들어가는 ()에 true를 하면 무한루프
            Log.d("while","현재 out 카운트 = ${out}")
            out = out + 1
        } while (out < 3)

        //control loop
        //break : 특정한 조건을 만나면 for문 종료
        for(index in 0..10) {
            if (index > 5) break
            Log.d("포", "현재 숫자=${index}")
        }
        //continue : 특정한 조건을 만나면 다음 코드를 실행하지 않고 코드 블록의 처음으로 이동
        for(index in 0..10) {
            if (index == 5) continue
            Log.d("포", "현재 숫자=${index}")
        }
    }
}