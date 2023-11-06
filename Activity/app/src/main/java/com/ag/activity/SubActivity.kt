package com.ag.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ag.activity.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    val binding by lazy { ActivitySubBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            to1.text = intent.getStringExtra("from1")
            to2.text = "${intent.getIntExtra("from2", 0)}"
            //                            form2의 값이 main에 없으면 default값으로 0을 사용하겠다는 의미
            btnClose.setOnClickListener{
                val returnIntent = Intent()  //나를 호출한 인텐트로 돌려주기 때문에 ()안에 아무것도 안 넣어도 됨
                val message = editMessage.text.toString()
                returnIntent.putExtra("returnValue",message)
                setResult(RESULT_OK, returnIntent)
                finish()
            }
        }
    }
}

//https://winterpoet-kim.tistory.com/25