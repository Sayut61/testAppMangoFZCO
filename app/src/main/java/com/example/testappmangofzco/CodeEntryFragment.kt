package com.example.testappmangofzco

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.testappmangofzco.databinding.FragmentCodeEntryBinding

class CodeEntryFragment : Fragment() {

    private var _binding: FragmentCodeEntryBinding? = null
    private val binding get() = _binding!!

    private val args: CodeEntryFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCodeEntryBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVerifyCodeInputs()
        showMobileNumber()
    }

    private fun showMobileNumber() {
        binding.phoneNum.text = args.phoneNumber
    }


    private fun setupVerifyCodeInputs() {
        binding.apply {
            inputCode1.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    inputCode2.requestFocus()
                }

                override fun afterTextChanged(s: Editable?) {}
            })
            inputCode2.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    inputCode3.requestFocus()
                }

                override fun afterTextChanged(s: Editable?) {}
            })
            inputCode3.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    inputCode4.requestFocus()
                }

                override fun afterTextChanged(s: Editable?) {}
            })
            inputCode4.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    inputCode5.requestFocus()
                }

                override fun afterTextChanged(s: Editable?) {}
            })
            inputCode5.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    inputCode6.requestFocus()
                }

                override fun afterTextChanged(s: Editable?) {}
            })
        }
    }
}