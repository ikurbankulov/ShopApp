package com.example.uilover

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.uilover.databinding.ActivityDrawerBinding
import com.example.uilover.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

private lateinit var binding: ActivityMainBinding
private var auth = Firebase.auth
private lateinit var drawerTextView: TextView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        versionCheck()
        init()
    }

    private fun init() {
        drawerTextView =
            binding.includedView.navigationView.getHeaderView(0)
                .findViewById(R.id.drawer_accountEmail)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.includedView.drawerLayout,
            binding.toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )
        binding.includedView.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.includedView.navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_my_ads -> {
                Toast.makeText(this, "Мои объявления", Toast.LENGTH_LONG).show()
            }
            R.id.id_car -> {

            }
            R.id.id_pc -> {

            }
            R.id.id_other -> {

            }
            R.id.id_sign_in -> {

            }
            R.id.id_sign_up -> {
                var intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
            R.id.id_sign_out -> {
                auth.signOut()
                uiUpdate(null)
                var intent = Intent(this, IntroActivity::class.java)
                startActivity(intent)
            }
        }
        binding.includedView.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    @SuppressLint("ObsoleteSdkInt")
    private fun versionCheck() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }

    companion object{
        fun uiUpdate(user: FirebaseUser?){
        drawerTextView.text = if (user == null){
            "Login or signUp"
        } else{
            user.email
        }}

    }
}