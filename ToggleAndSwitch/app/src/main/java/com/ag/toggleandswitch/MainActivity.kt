package com.ag.toggleandswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ag.toggleandswitch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            toggleButton.setOnCheckedChangeListener { buttonBiew, isChecked ->
                // if(isChecked) textToggle.text = "On" else textToggle.text = "Off"
                textToggle.text = if(isChecked) "On" else "Off"  // 위의 코드 간단하게
            }
            switchButton.setOnCheckedChangeListener { buttonBiew, isChecked ->
                textSwitch.text = if(isChecked) "On" else "Off"
            }
        }
    }
}