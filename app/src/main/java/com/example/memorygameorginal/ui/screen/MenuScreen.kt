package com.example.memorygameorginal.ui.screen

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.memorygameorginal.R
import com.example.memorygameorginal.app.data.LevelEnum
import com.example.memorygameorginal.databinding.ScreenMenuBinding
import com.example.memorygameorginal.ui.viewmodul.MenuViewModel
import com.example.memorygameorginal.ui.viewmodul.impl.MenuViewModelImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuScreen : Fragment(R.layout.screen_menu) {
    private val binding by viewBinding(ScreenMenuBinding::bind)
    private val viewModel: MenuViewModel by viewModels<MenuViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnEasy.setOnClickListener {
            viewModel.openGameScreen(LevelEnum.EASY)
        }

        binding.btnMedium.setOnClickListener {
            viewModel.openGameScreen(LevelEnum.MEDIUM)
        }

        binding.btnHard.setOnClickListener {
            viewModel.openGameScreen(LevelEnum.HARD)
        }
        binding.btnInfo.setOnClickListener {
            viewModel.openInfoScreen()
        }
   /*     val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                AlertDialog.Builder(requireContext())
                    .setMessage("Do you want to exit the memory game :( ?")
                    .setPositiveButton("Yes") { _, _ ->
                      requireActivity().finish()
                    }
                    .setNegativeButton("No", null)
                    .show()
            }
        }*/

//        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
}

//    override fun onBackPressed() {
//        AlertDialog.Builder(requireContext())
//            .setMessage("Are you sure you want to exit?")
//            .setPositiveButton("Yes") { _, _ ->
//                super.onBackPressed()
//            }
//            .setNegativeButton("No", null)
//            .show()
//    }

