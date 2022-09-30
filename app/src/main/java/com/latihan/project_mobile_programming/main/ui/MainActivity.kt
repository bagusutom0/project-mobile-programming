package com.latihan.project_mobile_programming.main.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.latihan.project_mobile_programming.R
import com.latihan.project_mobile_programming.core.domain.repository.UserRepository
import com.latihan.project_mobile_programming.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}