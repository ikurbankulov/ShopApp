package com.example.uilover

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uilover.databinding.ActivityResetPasswordBinding

class ResetPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val email = intent.getStringExtra("resetEmail")
        binding.editTextEmail.setText(email)


        binding.buttonResetPassword.setOnClickListener {
            val email = binding.editTextEmail.text.toString().trim()
            // TODO:  reset password
        }
    }
}