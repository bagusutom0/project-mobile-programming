package com.latihan.project_mobile_programming.main.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.latihan.project_mobile_programming.databinding.ActivityMainBinding
import com.latihan.project_mobile_programming.databinding.ActivityTaskBinding

class TaskActivity : AppCompatActivity() {
    private var _binding: ActivityTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}