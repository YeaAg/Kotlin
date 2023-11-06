package com.ag.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ag.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    val listFragment by lazy { ListFragment() }
    val detailFragment by lazy { DetailFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setFragment()

        binding.btnSend.setOnClickListener {
            listFragment.setValue("값 전달하기")
        }
    }

    fun goDetail() {
        val detailFragment = DetailFragment()
        val transection = supportFragmentManager.beginTransaction()
        transection.add(R.id.frameLayout, detailFragment)
        transection.addToBackStack("detail")  // addToBackStack : 뒤로가기 구현하기 위해서 위의 코드를 스택에 저장해 둠
        transection.commit()
    }

    fun goBack() {
        onBackPressed()
    }

    fun setFragment(){

        val bundle = Bundle()
        bundle.putString("key1", "List Fragment")
        bundle.putInt("key2", 20231104)

        listFragment.arguments = bundle

        // 1. 사용할 프래그먼트 생성
        // val listFragment = ListFragment()  -> class 밑에 생성해 둠
        // 2. 트랜잭션 생성
        val transection = supportFragmentManager.beginTransaction()
        // 3. 트랜잭션을 통해 프래그먼트 삽입
        transection.add(R.id.frameLayout, listFragment)  //위에 listfragment 미리 생성해 둠
        transection.commit()
    }
}

// textAllCaps : 버튼 이름을 Next로 적었는데 NEXT로 나올 때 false로 바꾸면 잘 나옴