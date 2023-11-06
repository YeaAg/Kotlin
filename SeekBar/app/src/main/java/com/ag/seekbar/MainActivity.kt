package com.ag.seekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import com.ag.seekbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            seekBar.setOnSeekBarChangeListener(object: OnSeekBarChangeListener{
                //ctrl+i
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    //                       seekBar자체 / 현재 탐색구간 값 / true이면 사람이 터치
                    if(p2) { //사람이 터치로 동작시킬때만 코드 실행
                        textView.text = "$p1"
                    }
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {}
                override fun onStopTrackingTouch(p0: SeekBar?) {}

            })
        }
    }
}