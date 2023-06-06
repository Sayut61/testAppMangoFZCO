package com.example.testappmangofzco.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.testappmangofzco.R
import com.example.testappmangofzco.databinding.FragmentAuthBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthFragment : Fragment() {

    private val viewModel: AuthViewModel by viewModels()

    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickSendBtn()
                viewModel.responseOfSendPhoneLiveData.observe(viewLifecycleOwner) {
                    if (it) {
                        goToEnterCodeScreen(binding.countryCode.text.toString() + binding.inputNumber.text.toString())
                    } else {
                        goToRegistrationScreen()
                    }
                }
    }

    private fun goToRegistrationScreen() {
        binding.registrationTv.setOnClickListener {
            AuthFragmentDirections.actionAuthFragmentToRegistrationFragment().apply {
                findNavController().navigate(this)
            }
        }
    }

    private fun goToEnterCodeScreen(number: String) {
        AuthFragmentDirections.actionAuthFragmentToCodeEntryFragment(number).apply {
            findNavController().navigate(this)
        }
    }

    private fun onClickSendBtn() {
        binding.sendBtn.setOnClickListener {
            if (binding.inputNumber.text.toList().size < 10) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.enter_mobile),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val currentNumber = binding.countryCode.text.toString() + binding.inputNumber.text.toString()
                viewModel.sendNumber(currentNumber)
            }
        }
    }
}