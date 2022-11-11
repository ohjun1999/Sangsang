package com.link.sangsang.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.link.sangsang.R
import com.link.sangsang.adapter.ViewPagerAdapter
import com.link.sangsang.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityMainBinding? = null

    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!
    private var doubleBackToExit = false
    var currentPosition=0
    val handler=Handler(Looper.getMainLooper()){
        setPage()
        true
    }
    //    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityMainBinding.inflate(layoutInflater)
//firestore 변수 초기화

        setContentView(binding.root)

        binding.goAd.setOnClickListener {
            val intent = Intent(this, AdActivity::class.java)
            startActivity(intent)
        }
        binding.goBenefit.setOnClickListener {
            val intent = Intent(this, BenefitActivity::class.java)
            startActivity(intent)
        }
        binding.goCommunity.setOnClickListener {
            val intent = Intent(this, CommunityActivity::class.java)
            startActivity(intent)
        }
        binding.goPoint.setOnClickListener {
            val intent = Intent(this, PointActivity::class.java)
            startActivity(intent)
        }
        binding.goShop.setOnClickListener {
            val intent = Intent(this, ShopActivity::class.java)
            startActivity(intent)
        }
        binding.goSurvey.setOnClickListener {
            val intent = Intent(this, SurveyActivity::class.java)
            startActivity(intent)
        }

        binding.banner.adapter = ViewPagerAdapter(getIdolList(),this) // 어댑터 생성
        binding.banner.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로


        val thread=Thread(PagerRunnable())
        thread.start()


    }
    //페이지 변경하기
    fun setPage(){
        if(currentPosition==getIdolList().size) currentPosition=0
        binding.banner.setCurrentItem(currentPosition,true)
        currentPosition+=1
    }

    //2초 마다 페이지 넘기기
    inner class PagerRunnable:Runnable{
        override fun run() {
            while(true){
                Thread.sleep(3000)
                handler.sendEmptyMessage(0)
            }
        }
    }
    // 액티비티가 파괴될 때..
    override fun onDestroy() {
        // onDestroy 에서 binding class 인스턴스 참조를 정리해주어야 한다.
        mBinding = null
        super.onDestroy()
    }

    private fun getIdolList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.ic_moil_banner,R.drawable.ic_pmo_banner,R.drawable.asset_4_1)
    }
    override fun onBackPressed() {
        if (doubleBackToExit) {
            finishAffinity()
        } else {
            Toast.makeText(this, "종료하시려면 뒤로가기를 한번 더 눌러주세요.", Toast.LENGTH_SHORT).show()
            doubleBackToExit = true
            runDelayed(1500L) {
                doubleBackToExit = false
            }
        }
    }


    fun runDelayed(millis: Long, function: () -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed(function, millis)
    }


}