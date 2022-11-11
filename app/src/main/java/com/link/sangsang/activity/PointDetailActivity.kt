package com.link.sangsang.activity

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.link.sangsang.adapter.*
import com.link.sangsang.databinding.ActivityPointDetailBinding
import com.link.sangsang.dataclass.*

class PointDetailActivity : AppCompatActivity() {
    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityPointDetailBinding? = null

    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!
    lateinit var pointDetailRecyclerView: RecyclerView

    //    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityPointDetailBinding.inflate(layoutInflater)
//firestore 변수 초기화
        pointDetailRecyclerView = binding.pointDetailRecyclerView

        val pointDetailKingbusDataClass = mutableListOf<PointDetailKingbusDataClass>()
        val kingbusList = arrayListOf<PointDetailKingbusDataClass>()
        val kingbusAdapter = PointDetailKingbusAdapter(this, kingbusList)
        val pointDetailPmoDataClass = mutableListOf<PointDetailPmoDataClass>()
        val pmoList = arrayListOf<PointDetailPmoDataClass>()
        val pointDetailPmoAdapter = PointDetailPmoAdapter(this, pmoList)
        val pointDetailRatelDataClass = mutableListOf<PointDetailRatelDataClass>()
        val ratelList = arrayListOf<PointDetailRatelDataClass>()
        val ratelAdapter = PointDetailRatelAdapter(this, ratelList)
        val pointDetailMoilsurokDataClass = mutableListOf<PointDetailMoilsurokDataClass>()
        val moilsurokList = arrayListOf<PointDetailMoilsurokDataClass>()
        val moilsurokAdapter = PointDetailMoilsurokAdapter(this, moilsurokList)

        pointDetailKingbusDataClass.apply {
            add(
                PointDetailKingbusDataClass(

                    mainText = "사이트 방문시 포인트 적립",
                    pointName = "킹버스",
                    subText1 = "킹버스 사이트 방문시 포인트가 적립됩니다.",
                    subText2 = "*앱 내에서 사용가능한 포인트 입니다.",
                    link = "http://www.kingbus.co.kr/"

                    )

            )
            add(
                PointDetailKingbusDataClass(
                    mainText = "버스대절시 포인트 적립",
                    pointName = "킹버스",
                    subText1 = "킹버스를 통해 버스대절시 포인트가 적립됩니다.",
                    subText2 = "*앱 내에서 사용가능한 포인트 입니다.",
                    link = "http://www.kingbus.co.kr/"

                )

            )
            add(
                PointDetailKingbusDataClass(
                    mainText = "버스 견적서 작성시 포인트 적립",
                    pointName = "킹버스",
                    subText1 = "킹버스에서 버스 견적서 작성시 포인트가 적립됩니다.",
                    subText2 = "*앱 내에서 사용가능한 포인트 입니다.",
                    link = "http://www.kingbus.co.kr/"
                )

            )
            add(
                PointDetailKingbusDataClass(
                    mainText = "킹버스 광고 영상 시청시 포인트 적립",
                    pointName = "킹버스",
                    subText1 = "킹버스 광고영상 시청시 포인트가 적립됩니다.",
                    subText2 = "*앱 내에서 사용가능한 포인트 입니다.",
                    link = "http://www.kingbus.co.kr/"
                )

            )

        }
        pointDetailPmoDataClass.apply {
            add(
                PointDetailPmoDataClass(

                    mainText = "사이트 방문시 포인트 적립",
                    pointName = "PMO",
                    subText1 = "PMO 사이트 방문시 포인트가 적립됩니다.",
                    subText2 = "*앱 내에서 사용가능한 포인트 입니다.",
                    link = "http://linkpmo.co.kr/"

                )

            )
            add(
                PointDetailPmoDataClass(
                    mainText = "웹사이트 제작 의뢰시 포인트 적립",
                    pointName = "PMO",
                    subText1 = "PMO웹 제작서비스 이용시 포인트가 적립됩니다.",
                    subText2 = "*앱 내에서 사용가능한 포인트 입니다.",
                    link = "http://linkpmo.co.kr/"

                )

            )
            add(
                PointDetailPmoDataClass(
                    mainText = "앱 제작 의뢰시 포인트 적립",
                    pointName = "PMO",
                    subText1 = "PMO 앱 제작 서비스 의뢰시 포인트가 적립됩니다.",
                    subText2 = "*앱 내에서 사용가능한 포인트 입니다.",
                    link = "http://linkpmo.co.kr/"
                )

            )
            add(
                PointDetailPmoDataClass(
                    mainText = "PMO 제작사 자료 다운로드시 포인트 적립",
                    pointName = "PMO",
                    subText1 = "PMO 제작사 자료 다운로드(PDF)시 포인트가 적립됩니다.\n" +
                            "PMO 사이트 내에서 다운로드 가능",
                    subText2 = "*앱 내에서 사용가능한 포인트 입니다.",
                    link = "http://linkpmo.co.kr/"
                )

            )

        }
        pointDetailMoilsurokDataClass.apply {
            add(
                PointDetailMoilsurokDataClass(

                    mainText = "사이트 방문시 포인트 적립",
                    pointName = "모일수록",
                    subText1 = "모일수록 사이트 방문시 포인트가 적립됩니다.",
                    subText2 = "*앱 내에서 사용가능한 포인트 입니다.",
                    link = "http://www.moilsurok.shop/"

                )

            )
            add(
                PointDetailMoilsurokDataClass(
                    mainText = "모일수록 앱 설치시 포인트 적립",
                    pointName = "모일수록",
                    subText1 = "킹버스 사이트 방문시 포인트가 적립됩니다.",
                    subText2 = "*앱 내에서 사용가능한 포인트 입니다.",
                    link = "http://www.moilsurok.shop/"

                )

            )
            add(
                PointDetailMoilsurokDataClass(
                    mainText = "모일수록 제작 의뢰시 포인트 적립",
                    pointName = "모일수록",
                    subText1 = "모일수록 제작 의뢰시 포인트가 적립됩니다.",
                    subText2 = "*앱 내에서 사용가능한 포인트 입니다.",
                    link = "http://www.moilsurok.shop/"
                )

            )

        }
        pointDetailRatelDataClass.apply {
            add(
                PointDetailRatelDataClass(

                    mainText = "사이트 방문시 포인트 적립",
                    pointName = "RATEL",
                    subText1 = "라텔 사이트 방문시 포인트가 적립됩니다.",
                    subText2 = "*앱 내에서 사용가능한 포인트 입니다.",
                    link = "http://linkpmo.co.kr/"

                )

            )
            add(
                PointDetailRatelDataClass(
                    mainText = "RATEL 앱 설치시 포인트 적립",
                    pointName = "RATEL",
                    subText1 = "RATEL 앱 설치시 포인트가 적립됩니다.",
                    subText2 = "*앱 내에서 사용가능한 포인트 입니다.",
                    link = "http://linkpmo.co.kr/"

                )

            )
            add(
                PointDetailRatelDataClass(
                    mainText = "RATEL에 회원가입시 포인트 적립",
                    pointName = "RATEL",
                    subText1 = "RATEL에 회원가입시 포인트가 적립됩니다.",
                    subText2 = "*앱 내에서 사용가능한 포인트 입니다.",
                    link = "http://linkpmo.co.kr/"
                )

            )

        }

        binding.comeDialog.setOnClickListener {
            // 기본 형태의 다이얼로그

            val builder = AlertDialog.Builder(this)
            builder.setTitle("추가정보")
                .setMessage("추가정보 입니다.")
                .setPositiveButton("확인",
                    DialogInterface.OnClickListener { dialog, id ->

                    })
                .setNegativeButton("취소",
                    DialogInterface.OnClickListener { dialog, id ->
                    })
            // 다이얼로그를 띄워주기
            builder.show()



            // 다이얼로그를 띄워주기

        }
        kingbusAdapter.replaceList(pointDetailKingbusDataClass)
        pointDetailPmoAdapter.replaceList(pointDetailPmoDataClass)
        ratelAdapter.replaceList(pointDetailRatelDataClass)
        moilsurokAdapter.replaceList(pointDetailMoilsurokDataClass)

        val pointName = intent.getStringExtra("pointName")
        when (pointName.toString()) {
            "킹버스" -> {
                pointDetailRecyclerView.adapter = kingbusAdapter
                pointDetailRecyclerView.layoutManager =
                    LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            }


            "PMO" -> {
                pointDetailRecyclerView.adapter = pointDetailPmoAdapter
                pointDetailRecyclerView.layoutManager =
                    LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            }
            "모일수록" -> {
                pointDetailRecyclerView.adapter = moilsurokAdapter
                pointDetailRecyclerView.layoutManager =
                    LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            }
            "RATEL" -> {
                pointDetailRecyclerView.adapter = ratelAdapter
                pointDetailRecyclerView.layoutManager =
                    LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            }
        }


        binding.backKey.setOnClickListener {
            finish()
        }
        setContentView(binding.root)
    }

    // 액티비티가 파괴될 때..
    override fun onDestroy() {
        // onDestroy 에서 binding class 인스턴스 참조를 정리해주어야 한다.
        mBinding = null
        super.onDestroy()
    }
}