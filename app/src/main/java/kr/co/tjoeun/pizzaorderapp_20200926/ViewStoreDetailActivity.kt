package kr.co.tjoeun.pizzaorderapp_20200926

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_view_store_detail.*
import kr.co.tjoeun.pizzaorderapp_20200926.datas.Store

class ViewStoreDetailActivity : BaseActivity() {

//    가게 정보 데이터는 setValues / setupEvents 모두가 공유해야하는 데이터.
//    변수는 만든 시점의 중괄호를 벗어나면 소멸됨. => 최대한 바깥 중괄호에 만들어주자.
//    멤버변수로 만들어주는게 편리하다.

    lateinit var mStore : Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        
        callBtn.setOnClickListener {

//            pl 변수에, 권한 여부에 따른 행동 방침을 저장.
            
            val pl = object : PermissionListener {
                override fun onPermissionGranted() {
//                    권한 승인시

//                    mStore가 가진 폰번을 이용해 => CALL 액션 실행
                    val myUri = Uri.parse("tel:${mStore.phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    
//                    권한 거부시 => 토스트 출력

                    Toast.makeText(mContext, "전화 연결 권한이 거부되어 통화가 불가능합니다.", Toast.LENGTH_SHORT)
                        .show()

                }

            }

            
//            pl에 적힌 방침을 기반으로 => 실제 권한 확인 요청.
            TedPermission.with(mContext)
                .setPermissionListener(pl)
                .setDeniedMessage("[설정] 에서 전화 권한을 켜야 주문이 가능합니다.")
//                    CALL_PHONE 권한 요청. (여러 권한이 필요하면, 추가 배치 가능)
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()

        }

    }

    override fun setValues() {

//        이 화면에 들어오는 intent에 첨부된, Serializable을 가져오자. (이름표 : storeData)
//        Serializable은 Store가 아님. => Store로 변형 (캐스팅) 과정 필요 : as Store 
        mStore = intent.getSerializableExtra("storeData") as Store

//        받아온 mStore를 이용해서, 각종 화면 표시 데이터 세팅.
        Glide.with(mContext).load(mStore.logoUrl).into(storeLogoImg)
        storeNameTxt.text = mStore.brandName
        phoneNumTxt.text = mStore.phoneNum

    }

}