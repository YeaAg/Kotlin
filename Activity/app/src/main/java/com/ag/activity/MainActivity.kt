package com.ag.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.ag.activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val activityLauncher = openActivityResultLauncher()

        binding.btnStart.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)

            //값 보내기
            intent.putExtra("from1", "Hello Bundle")
            intent.putExtra("from2", 2021)

            //startActivity(intent)
            activityLauncher.launch(intent)
        }

//        binding.btnStart.setOnClickListener{
//            val intent = Intent(this, SubActivity::class.java)
//
//            //값 보내기
//            intent.putExtra("from1", "Hello Bundle")
//            intent.putExtra("from2",2021)
//
//            //startActivity(intent)
//            startActivityForResult(intent,99)
//        }
    }

    private fun openActivityResultLauncher(): ActivityResultLauncher<Intent> {
        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    result.data?.getStringExtra("returnValue")?.let { message ->
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        return resultLauncher
    }
}

