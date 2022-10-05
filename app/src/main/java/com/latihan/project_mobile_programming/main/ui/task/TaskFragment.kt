package com.latihan.project_mobile_programming.main.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.latihan.project_mobile_programming.R
import com.latihan.project_mobile_programming.core.domain.model.Task
import com.latihan.project_mobile_programming.databinding.FragmentTaskBinding

class TaskFragment : Fragment() {

    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!
    private val args: TaskFragmentArgs by navArgs()
    private val adapter by lazy {
        TaskAdapter(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            toolbar.tvTitle.text = args.title
            toolbar.ibBack.visibility = View.INVISIBLE

            fabAdd.setOnClickListener {
                findNavController().navigate(R.id.action_taskFragment_to_createTaskFragment)
            }

            adapter.differ.submitList(
                listOf(
                    Task(false, "makan", "31 Agustus 2021", "Adhi"),
                    Task(false, "mandi", "32 Agustus 2021", "Adhi"),
                    Task(false, "turu", "33 Agustus 2021", "Adhi"),
                )
            )

            rvTask.layoutManager = LinearLayoutManager(requireContext())
            rvTask.setHasFixedSize(true)
            rvTask.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}