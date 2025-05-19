package com.example.pbl5.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pbl5.R
import com.example.pbl5.databinding.ActivityMainBinding
import com.example.pbl5.utils.VibrationUtils
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        bottomNavigation = binding.bottomNavBar

        // default: show speed fragment
        bottomNavigation.selectedItemId = R.id.nav_speed
        replaceFragment(FragmentSpeed())


        bottomNavigation.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.nav_history -> {
                    replaceFragment(FragmentHistory())
                    true
                }
                R.id.nav_speed ->{
                    replaceFragment(FragmentSpeed())
                    true
                }
                R.id.nav_dashboard ->{
                    replaceFragment(FragmentDashboard())
                    true
                }
                else -> {
                    replaceFragment(FragmentSpeed())
                    true
                }
            }
        }




//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.main_frame_layout,fragment).commit()
    }

    override fun onDestroy() {
        VibrationUtils.cancelVibration(this) // đảm bảo tắt rung nếu app bị destroy
        super.onDestroy()
    }
}