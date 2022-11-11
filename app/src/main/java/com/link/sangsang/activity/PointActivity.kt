package com.link.sangsang.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.link.sangsang.adapter.PointAdapter
import com.link.sangsang.dataclass.PointDataClass
import com.link.sangsang.databinding.ActivityPointBinding

class PointActivity : AppCompatActivity() {
    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityPointBinding? = null

    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!
    lateinit var pointRecyclerView: RecyclerView

    //    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityPointBinding.inflate(layoutInflater)
//firestore 변수 초기화
        binding.backKey.setOnClickListener {
            finish()
        }
        pointRecyclerView = binding.pointRecyclerView
        val pointDataClass = mutableListOf<PointDataClass>()
        val pointList = arrayListOf<PointDataClass>()
        val pointAdapter = PointAdapter(this, pointList)
        pointDataClass.apply {
            add(
                PointDataClass(
                    pointImg = "ic_kingbus_logo",
                    pointName = "킹버스"

                    )

            )
            add(
                PointDataClass(

                    pointImg = "ic_pmo_logo",
                    pointName = "PMO"
                )

            )
            add(
                PointDataClass(
                    pointImg = "ic_moilsurok",
                    pointName = "모일수록"

                )

            )
            add(
                PointDataClass(
                    pointImg = "ic_ratel_logo",
                    pointName = "RATEL"

                )

            )

        }
        pointAdapter.replaceList(pointDataClass)
        pointRecyclerView.adapter = pointAdapter
        pointRecyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)





        setContentView(binding.root)
    }

    // 액티비티가 파괴될 때..
    override fun onDestroy() {
        // onDestroy 에서 binding class 인스턴스 참조를 정리해주어야 한다.
        mBinding = null
        super.onDestroy()
    }
}