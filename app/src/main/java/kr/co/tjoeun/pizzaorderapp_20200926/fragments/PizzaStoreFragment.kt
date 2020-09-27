package kr.co.tjoeun.pizzaorderapp_20200926.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_pizza_store.*
import kr.co.tjoeun.pizzaorderapp_20200926.R
import kr.co.tjoeun.pizzaorderapp_20200926.ViewStoreDetailActivity
import kr.co.tjoeun.pizzaorderapp_20200926.adapters.StoreAdapter
import kr.co.tjoeun.pizzaorderapp_20200926.datas.Store

class PizzaStoreFragment : Fragment() {

//    실제 피자가게 데이터를 담기 위한 목록(ArrayList)
    val mPizzaStoreList = ArrayList<Store>()

//    리스트뷰에 피자가게 아이템들을 뿌려주는 어댑터 (setValues에서 실제로 채워줌)
    lateinit var mStoreAdapter : StoreAdapter


//    단순히 Fragment의 코틀린 / xml을 연결 하는 용도로만 사용하는 함수

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        fragment_pizza_store xml을 그려서 -> 프래그먼트의 화면으로 (결과로) 지정
        return inflater.inflate(R.layout.fragment_pizza_store, container, false)
    }

//    onCreate : 프래그먼트가 만들어질때 생성
//    onActivityCreated : 만들어진 프래그먼트가 => 액티비티위에 얹어지고 나서 실행.
//    화면에 접근하려면 -> onActivityCreated 안에서 작성하는게 편리하다.

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        연습용 데이터를 수기로 채우는 코드 (분석 필요 X)
//        Store클래스의 생성자에 맞는 순서대로 데이터 기입.
        mPizzaStoreList.add(Store("피자헛", "1588-5588", "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg"))
        mPizzaStoreList.add(Store("파파존스", "1577-8080", "http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800"))
        mPizzaStoreList.add(Store("미스터피자", "1577-0077", "https://post-phinf.pstatic.net/MjAxODEyMDVfMzYg/MDAxNTQzOTYxOTA4NjM3.8gsStnhxz7eEc9zpt5nmSRZmI-Pzpl4NJvHYU-Dlgmcg.7Vpgk0lopJ5GoTav3CUDqmXi2-_67S5AXD0AGbbR6J4g.JPEG/IMG_1641.jpg?type=w1200"))
        mPizzaStoreList.add(Store("도미노피자", "1577-3082", "https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png"))

//        멤버변수로 (lateinit var) 만들어둔 mStoreAdapter에 실제 어댑터 객체 생성 / 대입
        mStoreAdapter = StoreAdapter(context!!, R.layout.store_list_item, mPizzaStoreList)

//        리스트뷰의 어댑터로써 => mStoreAdapter를 지정. pizzaStoreListView의 내용물을 관리하게 된다.
        pizzaStoreListView.adapter = mStoreAdapter

//        => 여기까지 리스트뷰에 내용물을 띄우기 위한 코드.


//        리스트뷰 아이템이 눌렸을때 (피자 가게 하나가 눌렸을때) 이벤트 처리.
        pizzaStoreListView.setOnItemClickListener { parent, view, position, id ->

//            클릭된 피자가게가 어떤 가게인지, position을 이용해서 추출.
            val clickedStore = mPizzaStoreList[position]

//            상세 조회 화면으로 (가게데이터를 통째로 들고) 이동
            val myIntent = Intent(context, ViewStoreDetailActivity::class.java)
//            Store클래스에 Serializable 속성을 부여했기 때문에 통째로 첨부 가능.
            myIntent.putExtra("storeData", clickedStore)
            startActivity(myIntent)

        }


    }

}