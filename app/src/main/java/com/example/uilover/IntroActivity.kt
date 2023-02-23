package com.example.uilover

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.example.uilover.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        binding.buttonLogin.setOnClickListener{
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

       binding.buttonSignup.setOnClickListener{
           var intent = Intent(this, SignUpActivity::class.java)
           startActivity(intent)
       }
/* TODO: Установить слушатель нажатий на кнопку login и создать переход на другую активити с помощью intent */
    }
}