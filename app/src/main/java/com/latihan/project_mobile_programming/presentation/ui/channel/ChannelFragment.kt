package com.latihan.project_mobile_programming.presentation.ui.channel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.latihan.project_mobile_programming.R
import com.latihan.project_mobile_programming.databinding.FragmentChannelBinding
import com.latihan.project_mobile_programming.presentation.viewmodel.ChannelViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ChannelFragment : Fragment() {

    private var _binding: FragmentChannelBinding? = null
    private val binding get() = _binding!!

    private val channelViewModel by sharedViewModel<ChannelViewModel>()
    private val args by navArgs<ChannelFragmentArgs>()

    private val adapter by lazy {
        ChannelAdapter(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChannelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            toolbar.tvTitle.text = getString(R.string.title_channel)
            toolbar.ibBack.visibility = View.INVISIBLE

            toolbar.ibProfile.setOnClickListener {
                findNavController().navigate(
                    ChannelFragmentDirections.actionChannelFragmentToProfileFragment(args.user)
                )
            }

            fabAdd.setOnClickListener {
                findNavController().navigate(
                    ChannelFragmentDirections.actionChannelFragmentToCreateChannelFragment(args.user)
                )
            }

            channelViewModel.listChannel.observe(viewLifecycleOwner) { listChannel ->
                adapter.differ.submitList(listChannel)
            }

            adapter.setOnItemClickListener { onItemClickListener(it) }

            rvTask.layoutManager = LinearLayoutManager(requireContext())
            rvTask.setHasFixedSize(true)
            rvTask.adapter = adapter
        }
    }

    private fun onItemClickListener(title: String) {
        findNavController().navigate(
            ChannelFragmentDirections.actionChannelFragmentToTaskFragment(title)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}