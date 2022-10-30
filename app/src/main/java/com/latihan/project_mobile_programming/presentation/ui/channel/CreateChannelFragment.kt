package com.latihan.project_mobile_programming.presentation.ui.channel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.latihan.project_mobile_programming.R
import com.latihan.project_mobile_programming.databinding.FragmentCreateChannelBinding
import com.latihan.project_mobile_programming.presentation.viewmodel.ChannelViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class CreateChannelFragment : Fragment() {

    private var _binding: FragmentCreateChannelBinding? = null
    private val binding get() = _binding!!

    private val channelViewModel by sharedViewModel<ChannelViewModel>()
    private val args by navArgs<CreateChannelFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateChannelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            toolbar.tvTitle.text = getString(R.string.title_create_channel)
            toolbar.ibProfile.visibility = View.INVISIBLE

            toolbar.ibBack.setOnClickListener {
                findNavController().navigate(R.id.action_createChannelFragment_to_channelFragment)
            }

            fabCheck.setOnClickListener {
                val taskName = tietTaskName.text.toString().trim()
                channelViewModel.insertChannel(taskName, args.authorName)
                findNavController().navigate(CreateChannelFragmentDirections.actionCreateChannelFragmentToChannelFragment(args.authorName))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}