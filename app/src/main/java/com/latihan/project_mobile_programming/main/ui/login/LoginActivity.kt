package com.latihan.project_mobile_programming.main.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.latihan.project_mobile_programming.databinding.ActivityLoginBinding
import com.latihan.project_mobile_programming.main.ui.channel.ChannelActivity
import com.latihan.project_mobile_programming.main.ui.signup.SignUpActivity

class LoginActivity : AppCompatActivity() {
    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            btnLogin.setOnClickListener {
                Intent(this@LoginActivity, ChannelActivity::class.java).also {
                    startActivity(it)
                }
            }

            tvvRegister.setOnClickListener {
                Intent(this@LoginActivity, SignUpActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}