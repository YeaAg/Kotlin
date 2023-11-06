package com.ag.kotlinsyntaxclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //클래스 사용 방법
        // 1. 초기화
        var cls = 클래스 ()  // 인스턴스 = 메모리에 로드되어 있는 클래스
        cls.variable
        cls.function()

        // 2. companion object 로 만들기
        Log.d("태그", "메시지")


        //상속
        var parent = Parent()
        parent.showHouse()  //강남 200평 아파트

        var child = Child()
        child.showMoney()
        child.showHouse()  //강남 10평 오피스텔


        var son = Son()
        var result = son.getNumber("홈")
    }
}

class Log {

    companion object{
        var variable = "난 누구"
        fun d(tag:String, msg:String) {
            print("[$tag] : $msg")
        }
    }
}

// 클래스 : 변수(property)와 함수(method)의 모음
class 클래스 {

    init {
        //클래스를 초기화(클래스코드를 메모리에 로드한다)하면 호출된다
    }

    var variable:String = ""  //변수 - 프로퍼티

    fun function() {  //함수 - 메서드
        var variable_local = ""
    }
}

//상속
//상속을 사용하는 이유
// 1.기존에 작성된 코드를 재활용하기 위해서
// 2. 코드를 재활용하는데 -> 체계적인 구조로 사용하기 위해서

//override : 아빠가 정의해 놓은 함수가 있지만 동일한 이름을 사용해야할 때
open class Parent {  //상속이 되는 클래스는 상속을 할 수 있다는 의미로 앞에 open
    var money = 5000000000
    open var house = "강남 200평 아파트"

    open fun showHouse() {
        Log.d("클래스", "my house=${house}")
    }
}

class Child : Parent() {
    //상속받으면, 아빠클래스ㅡ이 프로퍼티와 메서드를 내것처럼 사용가능
    override var house = "강남 10명 오피스텔"  //재정의

    fun showMoney() {
        Log.d("클래스", "money=${money}")
    }

    override fun showHouse() {
        Log.d("클래스", "my house=${house}")
    }
}

//overload : 동일한 이름의 함수를 만드는 것
class Son {

    fun getNumber() :Int {
        return 1
    }

    fun getNumber(param:String) : Int {
        return 2
    }
}