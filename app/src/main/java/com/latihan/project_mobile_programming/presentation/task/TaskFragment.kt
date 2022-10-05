package com.latihan.project_mobile_programming.presentation.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.latihan.project_mobile_programming.R
import com.latihan.project_mobile_programming.databinding.FragmentTaskBinding

class TaskFragment : Fragment() {

    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<TaskFragmentArgs>()

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
            toolbar.ibProfile.visibility = View.INVISIBLE

            toolbar.ibBack.setOnClickListener {
                findNavController().navigate(R.id.action_taskFragment_to_channelFragment)
            }

            fabAdd.setOnClickListener {
                findNavController().navigate(R.id.action_taskFragment_to_createTaskFragment)
            }

//            adapter.differ.submitList(
//                listOf(
//                    Todo(isChecked = false, todo = "makan", deadline = "31 Agustus 2021", author = "Adhi"),
//                    Todo(isChecked = false, todo = "mandi", deadline = "32 Agustus 2021", author = "Adhi"),
//                    Todo(isChecked = false, todo = "turu", deadline = "33 Agustus 2021", author = "Adhi"),
//                )
//            )

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