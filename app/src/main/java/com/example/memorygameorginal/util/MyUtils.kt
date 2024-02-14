package com.example.memorygameorginal.util

import android.widget.ImageView
import com.example.memorygameorginal.R
import com.example.memorygameorginal.data.CardData

fun ImageView.openFirstAnim() {
    this.animate()
        .setDuration(500)
        .rotationY(89f)
        .scaleY(0.5f)
        .withEndAction {
            this.rotationY = -89f
            val cardData = this.tag as CardData
            this.setImageResource(cardData.resID)
            this.animate()
                .setDuration(500)
                .scaleY(1f)
                .rotationY(0f)
                .start()
        }
        .start()
}

fun ImageView.openSecondAnim(endAnim : () -> Unit) {
    this.animate()
        .setDuration(500)
        .rotationY(89f)
        .withEndAction {
            this.rotationY = -89f
            val cardData = this.tag as CardData
            this.setImageResource(cardData.resID)
            this.animate()
                .setDuration(500)
                .rotationY(0f)
                .withEndAction(endAnim)
                .start()
        }
        .start()
}

fun ImageView.closeAnim() {
    this.animate()
        .setDuration(500)
        .rotationY(-89f)
        .withEndAction {
            this.rotationY = 89f
            this.setImageResource(R.drawable.image_animals)
            this.animate()
                .setDuration(500)
                .rotationY(0f)
                .start()
        }
        .start()
}

fun ImageView.closeAnim(endAnim: () -> Unit) {
    this.animate()
        .setDuration(500)
        .rotationY(-89f)
        .withEndAction {
            this.rotationY = 89f
            this.setImageResource(R.drawable.image_animals)
            this.animate()
                .setDuration(500)
                .rotationY(0f)
                .withEndAction(endAnim)
                .start()
        }
        .start()
}

fun ImageView.hideAnime() {
    this.animate()
        .setDuration(500)
        .scaleX(0f)
        .scaleY(0f)
        .start()
}

fun ImageView.hideAnime(endAnim: () -> Unit) {
    this.animate()
        .setDuration(500)
        .scaleX(0f)
        .scaleY(0f)
        .withEndAction(endAnim)
        .start()
}

