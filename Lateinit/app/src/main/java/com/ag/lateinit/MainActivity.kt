package com.ag.lateinit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    // 지연초기화 : 메모리가 낭비되는 것을 막기 위함
    // 작은 값이 아닌 설계한 클래스를 지연초기화하기 위해서 사용

    // 1. lateinit var 변수명:타입
    lateinit var person:Person  // 코드 상 어딘가에서 변수에 값을 넣을 것이라는 의미
    // String은 기본형 X
    // lateinit은 기본형 사용 불가능
    // 기본형 : Int, Long, float, Double

    // 2. val 변수명 by lazy {변수에 들어갈 클래스생성자 또는 값}
    val age by lazy { 21 }  //한 번 값을 입력하고 바꾸는 경우가 없을 때 lazy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        person = Person()
    }
}

class Person {
    var name = ""
    var age = ""
    var address = ""
    var tel = ""
}

//1. 클래스
//2. Null safety
//에 대한 공부가 있어야 지연초기화 이해 가능