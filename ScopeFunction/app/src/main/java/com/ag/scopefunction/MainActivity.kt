package com.ag.scopefunction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.ag.scopefunction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(binding){
            button.setOnClickListener {  }
            imageView.setImageLevel(50)
            textView.text = "반가워"
        }
    }

    // 스코프함수
    // run, let, apply, also
    // with (사용법이 조금 다름)

    fun studyRun() {
        val phones = mutableListOf("010-1234-5678", "010-3456-8978", "010-4587-1345")
        val list = mutableListOf(1,2,3,4,5,6,7,8,9)
        val names = mutableListOf("Scott", "Kelly", "Michael")

        val seoulPeople = SeoulPeople()

        // 변수에 액션을 취하고 액션의 다른 결과값을 받고 싶다 -> run, let
        // 1.run
        val resultRun = seoulPeople.persons.run {
            add(Person("Scott", "010-1234-5678",22)) //seoulPeople의 4번째에 값 추가
            size  // size값이 저장되서 출력됨
        }

        // 2. let
        val resultLet = seoulPeople.persons.let{ persons ->  //seoulPeople을 persons이라고 하겠다는 의미
            persons.add(Person("Scott", "010-1234-5678",22))
            persons.add(Person("Scott", "010-1234-5678",22))
        }

        // 순수하게 변수에 반영된 값을 사용하고 싶다 -> apply, also
        // 3. apply
        val resultApply = seoulPeople.persons.apply {
            add(Person("Scott", "010-1234-5678",22)) //seoulPeople의 4번째에 값 추가
            11  // 상관 없이 전까지 값이 저장
        }

        // 4. also
        val resultAlso = seoulPeople.persons.also{ persons ->
            persons.add(Person("Scott", "010-1234-5678",19)) //seoulPeople의 4번째에 값 추가
            12  // 상관없이 전까지 값이 저장
        }
    }
}

class SeoulPeople {
    var persons = mutableListOf<Person>()
    init {
        persons.add(Person("Scott", "010-1234-5678",19))
        persons.add(Person("Kelly", "010-1234-5678",20))
        persons.add(Person("Michael", "010-1234-5678",21))
    }
}

class Person (
    var name:String = "",
    var phone:String = "",
    var age:Int = 21
)