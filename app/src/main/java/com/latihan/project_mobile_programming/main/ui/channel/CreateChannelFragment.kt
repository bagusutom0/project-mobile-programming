package com.latihan.project_mobile_programming.main.ui.channel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.latihan.project_mobile_programming.R
import com.latihan.project_mobile_programming.databinding.FragmentCreateChannelBinding


class CreateChannelFragment : Fragment() {

    private var _binding: FragmentCreateChannelBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateChannelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            toolbar.tvTitle.text = getString(R.string.title_create_channel)
            toolbar.ibProfile.visibility = View.INVISIBLE

            toolbar.ibBack.setOnClickListener {
                findNavController().navigate(R.id.action_createChannelFragment_to_channelFragment)
            }

            fabCheck.setOnClickListener {
                findNavController().navigate(R.id.action_createChannelFragment_to_channelFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}