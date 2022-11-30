package com.latihan.project_mobile_programming.presentation.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.latihan.project_mobile_programming.R
import com.latihan.project_mobile_programming.databinding.FragmentProfileBinding
import com.latihan.project_mobile_programming.presentation.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val viewModel by sharedViewModel<UserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            toolbar.tvTitle.text = getString(R.string.title_profile)
            toolbar.ibProfile.visibility = View.INVISIBLE

            toolbar.ibBack.setOnClickListener {
                findNavController().navigate(
                    ProfileFragmentDirections.actionProfileFragmentToLoginFragment()
                )
            }
            btnLogOut.setOnClickListener {
                findNavController().navigate(
                    ProfileFragmentDirections.actionProfileFragmentToSplashScreenActivity()
                )
            }

            viewModel.user.observe(viewLifecycleOwner) { user ->
                tvEmail.text = user.email
                tvName.text = user.name
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}