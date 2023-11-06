package com.ag.ratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ag.ratingbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser -> //seekbar와 유사
                if(fromUser)
                    textView.text = "$rating"
            }
        }
    }
}

//activity option
//numStars : 별 개수
//rating : 처음 값 지정
//stepSize : 디테일한 별점