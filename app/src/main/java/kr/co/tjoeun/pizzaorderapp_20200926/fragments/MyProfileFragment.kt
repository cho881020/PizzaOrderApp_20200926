package kr.co.tjoeun.pizzaorderapp_20200926.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_my_profile.*
import kr.co.tjoeun.pizzaorderapp_20200926.EditNickNameActivity
import kr.co.tjoeun.pizzaorderapp_20200926.R

class MyProfileFragment : Fragment() {

//    숫자 1000은 코드를 다시 볼때 무슨 의미로 지은 숫자인지 알아보기 어렵다.
//    변수 이름을 통해서 의미를 쉽게 파악하도록 작성.
    val REQ_FOR_NICKNAME = 1000

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        changeNickNameBtn.setOnClickListener {

            val myIntent = Intent(context, EditNickNameActivity::class.java)

//            그냥 화면 전환 X, 닉네임을 가지러 간다고 명시하는 화면 전환.
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)

        }

    }


//    닉네임 등 화면에서 돌아왔을때 (startActivityForResult 로 넘어간 화면에서 돌아왔을때)
//     => 확인 / 취소 상관없이 모두 실행됨.

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        닉네임을 받으러 갔다 온건지? 확인 / 필터
//         => 다른 요청 (ex. 프사 선택)에 의해 다녀왔어도 실행되기 때문에 걸러주는 역할.
        if (requestCode == REQ_FOR_NICKNAME) {

//            OK를 누른게 맞는지? 검사.
            if (resultCode == Activity.RESULT_OK) {

//                닉네임을 받으러 다녀와서 && OK도 눌렀으면 실행되는 코드.

//                data는 왜 null 가능? => setResult에서 Intent를 첨부하지 않을 수도 있기 때문.
//                받는 입장에서는 null일 수도 있다. data : Intent?

//                우리의 코드에서는 무조건 Intent 첨부. => data!! 로 처리해도 무관하다.
                nickNameTxt.text = data!!.getStringExtra("nick")

            }
        }

    }

}