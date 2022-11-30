package com.latihan.project_mobile_programming.presentation.ui.signup

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.latihan.project_mobile_programming.R
import com.latihan.project_mobile_programming.databinding.FragmentSignUpBinding
import com.latihan.project_mobile_programming.presentation.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    private val viewModel by sharedViewModel<UserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tvLogin.setOnClickListener {
                findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
            }
            btnSignUp.setOnClickListener {
                val name = tietFullName.text.toString().trim()
                val email = tietEmail.text.toString().trim()
                val password = tietPassword.text.toString().trim()
                val confirmPassword = tietConfirmPassword.text.toString().trim()

                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(
                        requireContext(),
                        "Mohon isi semua data",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        Toast.makeText(
                            requireContext(),
                            "Mohon masukan Email dengan benar",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    if (password == confirmPassword) {
                        viewModel.insertNewuser(name, email, password)
                        findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Password tidak sama",
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