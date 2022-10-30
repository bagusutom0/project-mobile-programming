package com.latihan.project_mobile_programming.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.latihan.project_mobile_programming.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}