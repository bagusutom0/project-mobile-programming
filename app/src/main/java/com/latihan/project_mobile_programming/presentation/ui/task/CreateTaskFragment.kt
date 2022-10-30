package com.latihan.project_mobile_programming.presentation.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.latihan.project_mobile_programming.R
import com.latihan.project_mobile_programming.databinding.FragmentCreateTaskBinding
import com.latihan.project_mobile_programming.presentation.viewmodel.TodoViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CreateTaskFragment : Fragment() {

    private var _binding: FragmentCreateTaskBinding? = null
    private val binding get() = _binding!!

    private val viewModel by sharedViewModel<TodoViewModel>()
    private val args by navArgs<CreateTaskFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            toolbar.tvTitle.text = getString(R.string.title_create_task)
            toolbar.ibProfile.visibility = View.INVISIBLE

            toolbar.ibBack.setOnClickListener {
                findNavController().navigate(
                    CreateTaskFragmentDirections.actionCreateTaskFragmentToTaskFragment(args.channel, args.author)
                )
            }

            fabCreate.setOnClickListener {
                val taskName = tietTaskName.text.toString().trim()
                val deadline = tietDeadline.text.toString().trim()

                viewModel.insertTodo(taskName, args.channel, args.author, deadline, false)
                findNavController().navigate(CreateTaskFragmentDirections.actionCreateTaskFragmentToTaskFragment(args.channel, args.author))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}