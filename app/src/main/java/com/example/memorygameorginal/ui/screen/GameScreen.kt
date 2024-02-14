package com.example.memorygameorginal.ui.screen


import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.setMargins
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.memorygameorginal.R
import com.example.memorygameorginal.util.closeAnim
import com.example.memorygameorginal.data.CardData
import com.example.memorygameorginal.data.LevelEnum
import com.example.memorygameorginal.databinding.ScreenGameBinding
import com.example.memorygameorginal.util.hideAnime
import androidx.navigation.fragment.navArgs
import com.example.memorygameorginal.util.openFirstAnim
import com.example.memorygameorginal.util.openSecondAnim
import com.example.memorygameorginal.ui.viewmodul.GameViewModel
import com.example.memorygameorginal.ui.viewmodul.impl.GameViewModelImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class GameScreen : Fragment(R.layout.screen_game) {

    private val binding: ScreenGameBinding by viewBinding(ScreenGameBinding::bind)
    private val viewModel: GameViewModel by viewModels<GameViewModelImpl>()
    private val views = ArrayList<ImageView>()
    private var cardWidth = 0f
    private var cardHeight = 0f
    private var firstIndex = -1
    private var secondIndex = -1
    private var level = LevelEnum.EASY
    private var findCardCount = 0
    private val navArgs :GameScreenArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        level = navArgs.levelEnum
        binding.container.post {
            cardHeight = binding.container.height.toFloat() / level.verCount
            cardWidth = binding.container.width.toFloat() / level.horCount
            viewModel.loadCardByLevel(level)
        }

        viewModel.cardFlow
            .onEach { loadViews(level, it) }
            .launchIn(lifecycleScope)

        viewModel.closeAllViewsFlow
            .onEach { closeAllViews() }
            .launchIn(lifecycleScope)
    }

    private fun loadViews(levelEnum: LevelEnum, ls: List<CardData>) {
        for (i in 0 until levelEnum.horCount) {
            for (j in 0 until levelEnum.verCount) {
                val img = ImageView(requireContext())
                img.x = i * cardWidth
                img.y = j * cardHeight
                binding.container.addView(img)
                img.isClickable = false
                img.tag = ls[i * levelEnum.verCount + j]
                img.setImageResource(ls[i * levelEnum.verCount + j].id)
                views.add(img)

                val lp = img.layoutParams as ViewGroup.MarginLayoutParams
                lp.apply {
                    lp.width = cardWidth.toInt()
                    lp.height = cardHeight.toInt()
                    lp.setMargins(50)
                }
                img.layoutParams = lp
            }
        }
        clickReaction()
    }

    private fun closeAllViews() {
        views.forEach {image ->
//            image.closeAnim { image.isClickable = true }
            image.animate()
                .setDuration(1000)
                .rotationY(89f)
                .withEndAction {
                    image.rotationY = -89f
                    image.setImageResource(R.drawable.image_animals)
                    image.animate()
                        .setDuration(1000)
                        .rotationY(0f)
                        .withEndAction { image.isClickable = true }
                        .start()
                }
                .start()
        }
    }

    private fun clickReaction() {
        views.forEachIndexed { index , imageView ->
            imageView.setOnClickListener {
                if (firstIndex != -1 && secondIndex != -1) return@setOnClickListener
                if (index == firstIndex || index == secondIndex) return@setOnClickListener

                if (firstIndex == -1) {
                    firstIndex = index
                    imageView.openFirstAnim()
                } else  {
                    secondIndex = index
                    imageView.openSecondAnim {
                        check()
                    }
                }
            }
        }
    }

    private fun check() {
        val firstData = views[firstIndex].tag as CardData
        val secondData = views[secondIndex].tag as CardData
        if (firstData.id == secondData.id) {
            views[firstIndex].hideAnime()
            views[secondIndex].hideAnime {
                firstIndex = -1
                secondIndex = -1
                findCardCount += 2
                isFinish()
            }
        } else {
            views[firstIndex].closeAnim()
            views[secondIndex].closeAnim {
                firstIndex = -1
                secondIndex = -1
            }
        }
    }

    private fun isFinish() {
        if (findCardCount == level.verCount * level.horCount)
            Toast.makeText(requireContext(), "Finish", Toast.LENGTH_SHORT).show()
    }
}
