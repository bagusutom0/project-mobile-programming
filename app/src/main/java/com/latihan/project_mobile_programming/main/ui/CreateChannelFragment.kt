package com.latihan.project_mobile_programming.main.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
}