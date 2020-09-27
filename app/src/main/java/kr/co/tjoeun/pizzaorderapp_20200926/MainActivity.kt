package kr.co.tjoeun.pizzaorderapp_20200926

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.tjoeun.pizzaorderapp_20200926.adapters.MainViewPagerAdapter

class MainActivity : BaseActivity() {

//    뷰페이저의 Fragment를 뿌려주기 위한 어댑터 (setValues에서 초기화)

    lateinit var mViewPagerAdapter: MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }


    override fun setupEvents() {

    }

    override fun setValues() {

//        위에서 초기화를 미뤄둔 어댑터를 실제로 채워주는 코드
        mViewPagerAdapter = MainViewPagerAdapter(supportFragmentManager)

//        메인화면 뷰페이저의 어댑터로, 방금 완성한 어댑터를 연결
        mainViewPager.adapter = mViewPagerAdapter

//        탭레이아웃의 재료로 메인화면 뷰페이저를 연결.
        mainTabLayout.setupWithViewPager(mainViewPager)

    }

}