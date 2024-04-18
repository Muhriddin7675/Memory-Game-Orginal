package com.example.memorygameorginal.ui.dialog

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.memorygameorginal.R
import com.example.memorygameorginal.databinding.DialogFinishBinding

class FinishDialog : DialogFragment() {
    private var _binding: DialogFinishBinding? = null
    private val binding get() = _binding!!
    private lateinit var clickMenu: () -> Unit
    private lateinit var clickRestart: () -> Unit
    private var number = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogFinishBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showAnim()

        this.isCancelable = false

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

    fun showAnim() {
        binding.apply {
            cup.visibility = View.VISIBLE
            starImage1.visibility = View.VISIBLE
            starImage2.visibility = View.VISIBLE
            starImage3.visibility = View.VISIBLE
            cup.scaleX = 0f
            cup.scaleY = 0f
            cup.alpha = 0f

            starImage1.scaleX = 0f
            starImage1.scaleY = 0f
            starImage1.alpha = 0f

            starImage2.scaleX = 0f
            starImage2.scaleY = 0f
            starImage2.alpha = 0f

            starImage3.scaleX = 0f
            starImage3.scaleY = 0f
            starImage3.alpha = 0f

            cup.animate()
                .setDuration(500)
                .withStartAction {
                    btnRestart.isClickable = false
                    btnHome.isClickable = false
                }
                .scaleX(1f)
                .scaleY(1f)
                .alpha(1f)
                .withEndAction {
                        starImage1.animate()
                            .setDuration(500)
                            .scaleX(1f)
                            .scaleY(1f)
                            .alpha(1f)
                            .withEndAction {
                                if(number == 1 || number == 2){
                                    starImage2.animate()
                                        .setDuration(500)
                                        .scaleX(1f)
                                        .scaleY(1f)
                                        .alpha(1f)
                                        .withEndAction {
                                            if (number == 2){
                                                starImage3.animate()
                                                    .setDuration(500)
                                                    .scaleX(1f)
                                                    .scaleY(1f)
                                                    .alpha(1f)
                                                    .withEndAction {
                                                        btnRestart.isClickable = true
                                                        btnHome.isClickable = true
                                                    }
                                                    .start()
                                            }
                                        }
                                        .start()
                                }
                            }
                            .start()
                }
                .start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStart() {
        super.onStart()
        val width = resources.displayMetrics.widthPixels * 1   // 100% of screen width
        val height = ViewGroup.LayoutParams.WRAP_CONTENT         // Automatic height
        dialog?.window?.setLayout(width.toInt(), height)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.setCanceledOnTouchOutside(false)
    }
    fun setNumber(k:Int){
        number = k
    }
}
