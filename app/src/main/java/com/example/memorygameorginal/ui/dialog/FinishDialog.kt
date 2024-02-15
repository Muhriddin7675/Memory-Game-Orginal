package com.example.memorygameorginal.ui.dialog

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.memorygameorginal.R
import com.example.memorygameorginal.databinding.DialogFinishBinding

class FinishDialog : DialogFragment(R.layout.dialog_finish) {
    private lateinit var clickMenu: () -> Unit
    private lateinit var clickRestart: () -> Unit

    private val binding by viewBinding(DialogFinishBinding::bind)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_finish, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnHome.setOnClickListener {
            clickMenu.invoke()
            dismiss()
        }
        binding.btnRestart.setOnClickListener {
            clickRestart.invoke()
            dismiss()
        }
    }

    fun setOnClickMenu(block: () -> Unit) {
        clickMenu = block
    }

    fun setOnClickRestart(block: () -> Unit) {
        clickRestart = block
    }

    override fun onStart() {
        super.onStart()

        val width = resources.displayMetrics.widthPixels * 0.9    // 90% ekran eni
        val height = ViewGroup.LayoutParams.WRAP_CONTENT         // Avtomatik balandlik
        dialog?.window?.setLayout(width.toInt(), height)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.setCanceledOnTouchOutside(false)
    }

}