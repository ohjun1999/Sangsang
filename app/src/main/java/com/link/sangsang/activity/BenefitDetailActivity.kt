package com.link.sangsang.activity

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.link.sangsang.R
import com.link.sangsang.databinding.ActivityBenefitDetailBinding

class BenefitDetailActivity : AppCompatActivity() {
    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityBenefitDetailBinding? = null

    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    //    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityBenefitDetailBinding.inflate(layoutInflater)
//firestore 변수 초기화
        val mainImg = intent.getStringExtra("mainImg")
        val logo = intent.getStringExtra("logo")
        val company = intent.getStringExtra("company")
        val sector = intent.getStringExtra("sector")
        val comNum = intent.getStringExtra("comNum")
        val membership1 = intent.getStringExtra("membership1")
        val membership2 = intent.getStringExtra("membership2")
        val membership3 = intent.getStringExtra("membership3")
        val membership4 = intent.getStringExtra("membership4")
        val companyLink = intent.getStringExtra("companyLink")
        when (company.toString()) {
            "킹버스 (KINGBUS)" -> binding.companyLogo.setImageResource(R.drawable.ic_kingbus_logo)

            "PMO" -> binding.companyLogo.setImageResource(R.drawable.ic_pmo_logo)

            "모일수록" -> binding.companyLogo.setImageResource(R.drawable.ic_moilsurok)

            "RATEL" -> binding.companyLogo.setImageResource(R.drawable.ic_ratel_logo)
        }
        binding.backKey.setOnClickListener {
            finish()
        }

        binding.company.text = company
        binding.sector.text = sector
        binding.comNum.text = comNum
        binding.mem1.text = membership1
        binding.mem2.text = membership2
        binding.mem3.text = membership3
        binding.mem4.text = membership4
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


            // 리스트 형태의 다이얼로그
            var colorArray: Array<String> = arrayOf("빨강", "주황", "초록", "파랑") // 리스트에 들어갈 Array

                // 다이얼로그를 띄워주기

        }

        binding.goSite.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(companyLink.toString()))



            startActivity(intent)

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