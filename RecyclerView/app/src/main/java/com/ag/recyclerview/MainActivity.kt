package com.ag.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ag.recyclerview.databinding.ActivityMainBinding
import com.ag.recyclerview.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 1. 데이터를 불러온다
        val data = loadData()
        // 2. 아답터를 생성
        val customAdapter = CustomAdapter(data)
        // 3. 화면의 RecyclerView와 연결
        binding.recyclerView.adapter = customAdapter
        // 4. 레이아웃 매니저 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun loadData() : MutableList<Memo> {
        val memoList = mutableListOf<Memo>()  // data는 변수로 사용하지 않는 것이 좋음(무슨 데이터인지 구별이 불가하기 때문)
        for(no in 1..100){
            //val : 수정 필요X
            val title = "이것이 안드로이드다 $no"
            val data = System.currentTimeMillis()
            val memo = Memo(no, title, data)
            memoList.add(memo)
        }
        return memoList
    }
}

//                                           RecyclerView : 데이터 전체 관리    Holder : item layout 하나 하나 관리
//                  val을 사용하면 전역변수처럼 사용할 수 있음
class CustomAdapter(val listDate:MutableList<Memo>) : RecyclerView.Adapter<CustomAdapter.Holder>() {
    //RecyclearView를 상속받아서 CustomAdapter을 만듦

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        //                                         ( ) 안의 내용은 고정이어서 항상 이렇게 사용한다고 보면 됨
        return Holder(binding) // class Holder의 생성자가 binding이어서
    }

    override fun getItemCount() = listDate.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        // 1. 사용할 데이터를 꺼내고
        val memo = listDate.get(position)
        // 2. 홀더에 데이터를 전달
        holder.setMemo(memo)
    }

    //adapter가 holder를 가지고 item layout의 값을 세팅할거야
    //holder class는 RecyclerView의 ViewHolder라는 것을 상속받음
    class Holder(val binding: ItemRecyclerBinding):RecyclerView.ViewHolder(binding.root){

        //val listDate:MutableList<Memo>{} --> 코드를 줄이기 위해 CustomAdapter의 생성자로 이동

        lateinit var currentMemo:Memo
        // 클릭처리는 init에서만 한다
        init {
            binding.root.setOnClickListener {
                Toast.makeText(binding.root.context, "클릭된 아이템 : ${currentMemo.title}",Toast.LENGTH_SHORT).show()
            }
        }

        // 3. 받은 데이터를 화면에 출력한다.
        fun setMemo(memo:Memo){

            currentMemo = memo

            with(binding) {
                textNo.text = "${memo.no}"
                textTitle.text = memo.title

                // timestamp의 숫자형을 yyyy-MM-dd 형태로 바꿔줌
                val sdf = SimpleDateFormat("yyyy-MM-dd")
                val formattedDate = sdf.format(memo.timestamp)
                textDate.text = formattedDate
            }
        }
    }
}

// recycler의 특징 : 화면에 보이는 만큼만 생성해놓고 재사용

// item_recycler.xml 에서 텍스트의 Attributes에서 layout_weight에 숫자를 지정해도 비율이 이상하게 표시되는데
//                               Layout에서 layout_width를 0dp로 해주면 정상적인 비율로 표시된다

// 목록 한줄 한줄에 뿌려지는 데이터의 패턴에 맞게끔 class를 하나 정의해서 사용
// com.ag.recyclerview에서 오른쪽 클릭 -> new -> kotlin class -> data class