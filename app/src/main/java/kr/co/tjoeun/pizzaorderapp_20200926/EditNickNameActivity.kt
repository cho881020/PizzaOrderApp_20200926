package kr.co.tjoeun.pizzaorderapp_20200926

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nick_name.*

class EditNickNameActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nick_name)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        okBtn.setOnClickListener {

//            입력한 닉네임 받아오기
            val inputNickName = nickNameEdt.text.toString()

//            돌아갈때 들고갈 데이터를 담기만 하는 목적으로 만드는 Intent (첨부만 할 생각)
//            이동 X. Intent 생성자를 비워두면 된다.
            val resultIntent = Intent()
            resultIntent.putExtra("nick", inputNickName)

//            finish()를 그냥 실행하면, 기본값이 CANCEL로 처리됨.
//            OK를 눌렀다 + 들고 돌아갈 데이터 같이 첨부.
            setResult(Activity.RESULT_OK, resultIntent)

//            결과 설정이 되고 나서 finish.
            finish()

        }

    }

    override fun setValues() {

    }

}