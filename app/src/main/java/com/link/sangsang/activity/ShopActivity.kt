package com.link.sangsang.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.link.sangsang.databinding.ActivityShopBinding

class ShopActivity: AppCompatActivity() {
    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityShopBinding? = null

    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    //    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityShopBinding.inflate(layoutInflater)
//firestore 변수 초기화
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