package com.ag.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.ag.spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var data = listOf("-선택하세요-","1월","2월","3월")

        //                spinner에 들어갈 item type
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)

        with(binding) {
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val selected = data.get(position)
                    result.text = selected
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        }
    }
}