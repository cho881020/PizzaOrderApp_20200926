package kr.co.tjoeun.pizzaorderapp_20200926.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kr.co.tjoeun.pizzaorderapp_20200926.R
import kr.co.tjoeun.pizzaorderapp_20200926.datas.Store

// StoreAdapter를 만들때 (생성자) 3개의 재료 요구
// Context => 어떤 화면에서 어댑터를 쓰는지, 화면을 받아오자. => Glide 등을 쓰려면 필요한 경우가 많다.
// Int => ArrayAdapter 의 기반 작업에서 어떤 모양으로 준비할지 전달만 하는 용도. (getView 사용 X) - val 안붙임.
// List<Store> => getView에서 위치에 맞는 데이터를 뿌릴때 사용하는, 모든 데이터를 들고있는 목록.
// 받아온 세가지는 => 그대로 부모에게 전달도 같이.

class StoreAdapter(
    val mContext:Context,
    resId:Int,
    val mList:List<Store>) : ArrayAdapter<Store>(mContext, resId, mList) {

//    코딩의 편의성을 위해, 미리 멤버변수로 inflate 해주는 변수를 준비함.

    val inf = LayoutInflater.from(mContext)


//    position을 가지고 실행 : getView 함수 전체가 한줄 그릴때마다 한번씩 계속 실행됨.

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

//        화면에 어떤 줄을 그려야할지, 필요할때마다 실행된다는걸 확인하는 로그
        Log.d("리스트뷰", "${position}번 줄 그릴 차례")

//        convertView는 내용 변경 불가. (val)
//        null인 경우 채워 넣기 위해 (내용을 바꾼다) => var 을 만들자. 그 이름이 tempRow로 결정됨.

        var tempRow = convertView

        if (tempRow == null) {
//            convertView가 null인 상태로 getView가 실행된다면 => 재사용할 뷰가 없으니, 새로 그리자.
//            inflate 해주자.

            Log.d("리스트뷰", "재사용 할 뷰가 아직 부족함")

            tempRow = inf.inflate(R.layout.store_list_item, null)
        }


//        row에 store_list_item 의 모양이 담겨있다. => 절대 null이 아닌 상태로 담겨있게 된다.
        val row = tempRow!!

//        store_list_item모양 그대로인 row를 => 가공해서, 마지막에 return하자.
//        데이터가 반영된 채로 화면에 뿌려진다.

//        데이터를 반영해줄 View 들 가져오기
        val logoImg = row.findViewById<ImageView>(R.id.logoImg)
        val brandNameTxt = row.findViewById<TextView>(R.id.brandNameTxt)

//        View에 뿌려줄 근거 데이터 가져오기
        val storeData = mList[position]


//        데이터를 기반으로 View 값들 변경
        brandNameTxt.text = storeData.brandName
        Glide.with(mContext).load(storeData.logoUrl).into(logoImg)

//        모든 데이터가 반영된 row를 최종 결과 (화면에 뿌려지게) 처리
        return row
    }

}