package com.example.memorygameorginal.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.memorygameorginal.R
import com.example.memorygameorginal.databinding.DialogPauseBinding

class PauseDialog : DialogFragment(R.layout.dialog_pause) {
    private val binding by viewBinding(DialogPauseBinding::bind)

    private lateinit var clickMenu: () -> Unit
    private lateinit var clickRestart: () -> Unit
    private lateinit var clickStart: () -> Unit

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val animation = binding.pauseLottieAnimation
        animation.playAnimation()

        this.isCancelable = false


        binding.btnHome.setOnClickListener {
            clickMenu.invoke()
            dismiss()
        }
        binding.btnRestart.setOnClickListener {
            clickRestart.invoke()
            dismiss()
        }
        binding.btnStart.setOnClickListener {
            clickStart.invoke()
            dismiss()
        }
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

    }

    fun setOnClickMenu(block: () -> Unit) {
        clickMenu = block
    }

    fun setOnClickRestart(block: () -> Unit) {
        clickRestart = block
    }

    fun setOnClickStart(block: () -> Unit) {
        clickStart = block
    }

    override fun onStart() {
        super.onStart()

        val width = resources.displayMetrics.widthPixels * 1    // 100% ekran eni
        val height = ViewGroup.LayoutParams.WRAP_CONTENT         // Avtomatik balandlik
        dialog?.window?.setLayout(width.toInt(), height)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.setCanceledOnTouchOutside(false)
    }

}
