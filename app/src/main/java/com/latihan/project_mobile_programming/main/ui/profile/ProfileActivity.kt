package com.latihan.project_mobile_programming.main.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.latihan.project_mobile_programming.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.run {
            toolbar.tvTitle.text="Profile"
        }
    }
}