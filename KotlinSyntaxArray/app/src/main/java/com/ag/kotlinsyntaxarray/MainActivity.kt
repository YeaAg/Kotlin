package com.ag.kotlinsyntaxarray

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var variable:Int =157
        //배열, 컬렉션 : 하나의 변수에 여러개 값을 넣을 수 있게 설계된 데이터 타입

        // 배열
        // Int ->IntArray
        var intArr:IntArray = IntArray(10)  //타입을 명시하고 사용하는 것이 좋음
        // index = 0부터 시작
        intArr[0] = 10  // 0~9
        intArr[1] = 20
        intArr[2] = 30
        intArr[3] = 40
        intArr[4] = 50

        intArr[9] = 100

        Log.d("배열","9번 인덱스의 값=${intArr[9]}")

        //정해져 있는 값을 미리 하나의 변수에 저장해 사용할 필요가 있을 때 사용
        var weekArray = CharArray(7)
        weekArray[0] = '월'
        weekArray[1] = '화'
        //...
        weekArray[6] = '일'

        //컬렉션 : 배열과 다르게 개수를 특정하지 않음(동적배열)
        //리스트(배열과 동일/입력된 값의 개수를 바꿀 수 없음) vs 뮤터블리스트(리스트를 동적으로 사용)
        //                 <Generic(제네릭)>
        var mutableList = mutableListOf<Int>()
        //값 넣기
        mutableList.add(5)   //index 0 (자동 인덱스 생성)
        mutableList.add(10)  // 1
        mutableList.add(75)  // 2
        mutableList.add(36)  // 3
        mutableList.add(66)  // 4

        //                                        mutableList[3] 도 가능
        Log.d("컬렉션","3번 인덱스의 값=${mutableList.get(3)}")
        //입력과 사용의 일관성을 주기 위해서 get 사용

        //맵 (key : value)
        var mutableMap = mutableMapOf<String, String>()
        mutableMap.put("변수1", "값1")
        mutableMap.put("변수2", "값2")

        Log.d("맵","맵 변수1의 값=${mutableMap.get("변수1")}")

    }
}