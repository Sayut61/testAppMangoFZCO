package com.example.testappmangofzco

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.testappmangofzco.databinding.FragmentAuthBinding

class AuthFragment : Fragment() {

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
        goToRegistrationScreen()
        onClickSendBtn()
    }

    private fun goToRegistrationScreen() {
        binding.registrationTv.setOnClickListener {
            AuthFragmentDirections.actionAuthFragmentToRegistrationFragment().apply {
                findNavController().navigate(this)
            }
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
                AuthFragmentDirections.actionAuthFragmentToCodeEntryFragment(
                    binding.countryCode.text.toString() +
                            binding.inputNumber.text.toString()).apply {
                        findNavController().navigate(this)
                    }
            }
        }
    }
}