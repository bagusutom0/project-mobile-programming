package com.latihan.project_mobile_programming.presentation.ui.login

import android.os.Bundle
import android.util.Patterns
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

    companion object {
        var isNavigating = false
    }

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

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(
                        requireContext(),
                        "Email dan Password tidak boleh kosong",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        Toast.makeText(
                            requireContext(),
                            "Mohon masukan Email dengan benar",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        viewModel.checkUser(email, password)
                    }
                }
            }

            viewModel.run {
                isUserExist.observe(viewLifecycleOwner) { isUserExist ->
                    if (isUserExist) {
                        user.observe(viewLifecycleOwner) { user ->
                            if (!isNavigating) {
                                isNavigating = true

                                findNavController().navigate(
                                    LoginFragmentDirections
                                        .actionLoginFragmentToChannelFragment(
                                            user.name
                                        )
                                )
                            }
                        }
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "User Tidak Ada",
                            Toast.LENGTH_SHORT
                        ).show()
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