package com.example.uilover

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.WindowManager
import com.example.uilover.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        versionCheck()
        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()
            // TODO:  login
        }
        binding.textViewForgetPassword.setOnClickListener {
            var intent = Intent(this, ResetPasswordActivity::class.java)
            intent.putExtra("resetEmail", binding.editTextEmail.text.toString())
            startActivity(intent)
        }
        binding.buttonGoogle.setOnClickListener {
            // TODO: login with google
        }

    }

    private fun versionCheck() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }
}