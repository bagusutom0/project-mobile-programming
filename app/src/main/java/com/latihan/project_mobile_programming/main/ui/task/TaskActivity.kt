package com.latihan.project_mobile_programming.main.ui.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.latihan.project_mobile_programming.core.domain.model.Task
import com.latihan.project_mobile_programming.databinding.ActivityMainBinding
import com.latihan.project_mobile_programming.databinding.ActivityTaskBinding
import com.latihan.project_mobile_programming.main.ui.profile.ProfileActivity

class TaskActivity : AppCompatActivity() {
    private var _binding: ActivityTaskBinding? = null
    private val binding get() = _binding!!

    private val args: TaskActivityArgs by navArgs()

    private val adapter by lazy { TaskAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initiateUI()
    }

    private fun initiateUI() {
        binding.run {
            toolbar.run {
                tvTitle.text = args.title
                ibProfile.setOnClickListener {
                    Intent(this@TaskActivity, ProfileActivity::class.java).also {
                        startActivity(it)
                    }
                }
            }

            fabAdd.setOnClickListener {
                Intent(this@TaskActivity, CreateTaskActivity::class.java).also {
                    startActivity(it)
                }
            }

            adapter.differ.submitList(
                listOf(
                    Task(false, "makan", "31 Agustus 2021", "Adhi"),
                    Task(false, "mandi", "32 Agustus 2021", "Adhi"),
                    Task(false, "turu", "33 Agustus 2021", "Adhi"),
                )
            )

            rvTask.layoutManager = LinearLayoutManager(this@TaskActivity)
            rvTask.setHasFixedSize(true)
            rvTask.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}