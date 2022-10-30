package com.latihan.project_mobile_programming.presentation.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.latihan.project_mobile_programming.databinding.FragmentLoginBinding
import com.latihan.project_mobile_programming.presentation.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.sharedStateViewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel by sharedStateViewModel<UserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tvSignUp.setOnClickListener {
                findNavController()
                    .navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
            }


            btnLogin.setOnClickListener {
                val email = tietEmail.text.toString().trim()
                val password = tietPassword.text.toString().trim()
                viewModel.checkUser(email, password)
            }

        }

        viewModel.run {
            user.observe(viewLifecycleOwner) { user ->
                isUserExist.observe(viewLifecycleOwner) { isUserExist ->
                    if (isUserExist) {
                        findNavController()
                            .navigate(
                                LoginFragmentDirections.actionLoginFragmentToChannelFragment(
                                    user.name
                                )
                            )
                    } else {
                        Toast.makeText(requireActivity(), "User Tidak Ada", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}