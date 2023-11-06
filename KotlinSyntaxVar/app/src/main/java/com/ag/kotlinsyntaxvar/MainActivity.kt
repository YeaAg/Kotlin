package com.ag.kotlinsyntaxvar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//모든 코드는 클래스 안에 작성

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //onCreate : 시작점
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var variable = "홍길동"
        //문자열이 들어왔으니까 앞으로 variable이 사용할 type은 string이야라고 알려주는 것
        //값으로 초기화하는 것은 타입이 생략된 체로 작성된 것과 같음
        //타입이 지정되면 다른 타입으로 변경 불가능
        var variable:String = "홍길동"  //타입은 꼭 붙이기

        var variable2:String  //값으로 초기화하지 않았을 때 미리 type 특정 가능
        variable2 = "안녕하세요"

        variable = "다른값"

        //<코틀린의 기본타입>
        //1. 실수형
        var doubleValue:Double = 35.6
        var floatValue:Float = 123.7f
        //실수형으로 입력하면 전부 double로 인식함(f로 float이라고 알림)
        //double만 사용해도 됨

        //2. 정수형
        var intValue:Int = 1235468
        var longValue:Long = 32_147_483_647  //int의 가장 큰 숫자 범위, 자리수 구분하기 위해 _사용(개발자가 보기 편하게)
        //뒤에 L 안붙여도 괜찮음
        var shortValue:Short = 123
        var byteValue:Byte = 127
        //int만 사용해도 됨

        //3. 문자형
        var charValue:Char = 'a'
        var stringValue:String = "문자형 길이에 상관없이 값을 입력할 수 있다 = 크기를 특정할 수 없다."

        //4. 불린형
        var booleanValue:Boolean = true

        booleanValue = false  //변수, 변경 가능

        val VALVALUE:Boolean = true  //상수, 변경 불가능, 변수명은 대문자로(개발자들끼리 약속)

        var helloWorld = "안녕 세상아!"  //새로운 단어 나타나면 대문자로(camel case)
        var hello_world = "안녕 세상아!"  //(snake case)
        //둘 중에 하나만 사용해서 일관성 있게 코드 작성
    }

}