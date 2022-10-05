package com.latihan.project_mobile_programming.presentation.channel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.latihan.project_mobile_programming.R
import com.latihan.project_mobile_programming.core.domain.model.Channel
import com.latihan.project_mobile_programming.databinding.FragmentChannelBinding

class ChannelFragment : Fragment() {

    private var _binding: FragmentChannelBinding? = null
    private val binding get() = _binding!!

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
                findNavController().navigate(R.id.action_channelFragment_to_profileFragment)
            }

            fabAdd.setOnClickListener {
                findNavController().navigate(R.id.action_channelFragment_to_createChannelFragment)
            }

            adapter.run {
                differ.submitList(
                    listOf(
                        Channel("Adhi Cs", "Adhi"),
                        Channel("Marella Cs", "Marel"),
                        Channel("Jozka Cs", "Jozka")
                    )
                )

                setOnItemClickListener { onItemClickListener(it) }
            }

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