package com.example.uilover

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.uilover.databinding.ActivityDrawerBinding
import com.example.uilover.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        init()
    }

    private fun init() {
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

            }
        }
        binding.includedView.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}