package com.link.sangsang.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.link.sangsang.adapter.BenefitAdapter
import com.link.sangsang.databinding.ActivityBenefitBinding
import com.link.sangsang.dataclass.BenefitDataClass

class BenefitActivity : AppCompatActivity() {
    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityBenefitBinding? = null

    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!
    lateinit var benefitRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityBenefitBinding.inflate(layoutInflater)
//firestore 변수 초기화
        binding.backKey.setOnClickListener {
            finish()
        }
        benefitRecyclerView = binding.benefitRecyclerView
        val benefitDataClass = mutableListOf<BenefitDataClass>()
        val benefitList = arrayListOf<BenefitDataClass>()
        val benefitAdapter = BenefitAdapter(this, benefitList)
        benefitDataClass.apply {
            add(
                BenefitDataClass(
                    mainImg = null,
                    mainExplain = "버스대절은 역시 킹버스",
                    tag1 = "버스대절",
                    tag2 = "교통",
                    tag3 = "전세버스",
                    logo = null,
                    company = "킹버스 (KINGBUS)",
                    sector = "교통, 전세버스 대절",
                    comNum = "1522-9821",
                    membership1 = "버스 대절시 전체 비용의 5% 할인",
                    membership2 = "버스 대절 우선권 증정",
                    membership3 = "버스 대절시 다양한 서비스 제공",
                    membership4 = "기사 채용",
                    companyLink = "http://www.kingbus.co.kr/"

                )

            )
            add(
                BenefitDataClass(
                    mainImg = null,
                    mainExplain = "IT Solution PMO",
                    tag1 = "앱 개발",
                    tag2 = "IT",
                    tag3 = "웹페이지",
                    logo = null,
                    company = "PMO",
                    sector = "IT 솔루션",
                    comNum = "1522-9821",
                    membership1 = "전체 비용의 5% 할인",
                    membership2 = "앱,웹 서버비 할인",
                    membership3 = "상담비 무료",
                    membership4 = "맞춤형 솔루션 잔단 무료제공",
                    companyLink = "http://linkpmo.co.kr/"

                )

            )
            add(
                BenefitDataClass(
                    mainImg = null,
                    mainExplain = "동문수첩앱 모일수록",
                    tag1 = "앱 개발",
                    tag2 = "IT",
                    tag3 = "동문수첩",
                    logo = null,
                    company = "모일수록",
                    sector = "IT",
                    comNum = "1522-9821",
                    membership1 = "전체 비용의 5% 할인",
                    membership2 = "서버비 할인",
                    membership3 = "기능추가 금액 할인",
                    membership4 = null,
                    companyLink = "http://www.moilsurok.shop/"

                )

            )

        }
        benefitAdapter.replaceList(benefitDataClass)
        benefitRecyclerView.adapter = benefitAdapter
        benefitRecyclerView.layoutManager =
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