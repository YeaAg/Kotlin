package com.ag.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ag.fragment.databinding.FragmentListBinding

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    lateinit var mainActivity : MainActivity

    override fun onAttach(context: Context) {  //context에는 나를 삽인한 액티비티가 담겨 있음(여기서는 MainActivity)
        super.onAttach(context)
        if(context is MainActivity) mainActivity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            // arguments?.apply{ } 안에 아래 코드 두 줄을 넣으면 arguments?. 는 없애고 사용해도 됨
            textTitle.text = arguments?.getString("key1")
            textValue.text = "${arguments?.getInt("key2")}"

            btnNext.setOnClickListener {
                mainActivity.goDetail()
            }
        }
    }

    fun setValue(value : String) {
        binding.textFromActivity.text = value
    }
}