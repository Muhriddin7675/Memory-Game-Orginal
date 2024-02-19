package com.example.memorygameorginal.ui.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.memorygameorginal.R
import com.example.memorygameorginal.databinding.ScreenInfoBinding

class InfoScreen : Fragment(R.layout.screen_info) {
    private val binding by viewBinding(ScreenInfoBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnHome.setOnClickListener {
            findNavController().popBackStack()
        }

    }

}