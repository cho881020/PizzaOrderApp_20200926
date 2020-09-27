package kr.co.tjoeun.pizzaorderapp_20200926.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kr.co.tjoeun.pizzaorderapp_20200926.fragments.MyProfileFragment
import kr.co.tjoeun.pizzaorderapp_20200926.fragments.PizzaStoreFragment

class MainViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence? {

//        결과를 상황을 맞춰서 지정한다. return when(변수)
//        코틀린에서 상황별 결과 지정해야한다 => return when이 더 정석이다.

        return when(position) {
            0 -> "피자 주문"
            else -> "내 정보 설정"
        }

    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> PizzaStoreFragment()
            else -> MyProfileFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }
}