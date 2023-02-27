package com.example.uilover

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uilover.databinding.ActivityResetPasswordBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

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
            Firebase.auth.sendPasswordResetEmail(email)
            finish()
        }
    }

    companion object{
        fun newIntent(context: Context, string: String): Intent {
            val intent = Intent(context, ResetPasswordActivity::class.java)
            intent.putExtra("resetEmail", string)
            return intent
        }
    }
}