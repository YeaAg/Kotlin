package com.ag.progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ag.progressbar.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            /// <- 메인스레드
            showProgress(true)
            thread(start=true) { /// -> 서브스레드
                Thread.sleep(3000) //3초만 있다가 실행해
                // 화면에 영향을 미치는 코드는 메인스레드로 다시 보내야 한다.
                runOnUiThread {
                    showProgress(false)
                }
            } /// <- 서브스레드

            /// <- 메인스레드
        }
    }

    fun showProgress(show : Boolean) {
        binding.progressLayout.visibility =if(show) View.VISIBLE else View.GONE
    }
}