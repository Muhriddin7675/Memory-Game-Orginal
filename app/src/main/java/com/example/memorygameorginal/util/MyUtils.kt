package com.example.memorygameorginal.util

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import com.example.memorygameorginal.R
import com.example.memorygameorginal.app.data.CardData

fun ImageView.openFirstAnim() {
    this.isEnabled = false
    this.animate()
        .setDuration(300)
        .rotationY(89f)
        .scaleY(0.5f)
        .withEndAction {
            this.isEnabled = true
            this.rotationY = -89f
            val cardData = this.tag as CardData
            this.setImageResource(cardData.resID)
            this.animate()
                .setDuration(300)
                .scaleY(1f)
                .rotationY(0f)
                .start()
        }
        .start()
}

fun ImageView.openSecondAnim(endAnim: () -> Unit) {
    this.isEnabled = false
    this.animate()
        .setDuration(300)
        .rotationY(89f)
        .scaleY(0.5f)
        .withEndAction {
            this.isEnabled = true
            this.rotationY = -89f
            val cardData = this.tag as CardData
            this.setImageResource(cardData.resID)
            this.animate()
                .setDuration(300)
                .rotationY(0f)
                .scaleY(1f)
                .withEndAction(endAnim)
                .start()
        }
        .start()

}

fun ImageView.closeAnim() {
    this.animate()
        .setDuration(300)
        .rotationY(-89f)
        .withEndAction {
            this.rotationY = 89f
            this.setImageResource(R.drawable.image_empty)
            this.animate()
                .setDuration(300)
                .rotationY(0f)
                .start()

        }
        .start()
}

fun ImageView.closeAnim(endAnim: () -> Unit) {
    this.isEnabled = false
    this.animate()
        .setDuration(300)
        .rotationY(-89f)
        .withEndAction {
            this.isEnabled = true
            this.rotationY = 89f
            this.setImageResource(R.drawable.image_empty)
            this.animate()
                .setDuration(300)
                .rotationY(0f)
                .withEndAction (endAnim)

                .start()
        }
        .start()
}

fun ImageView.hideAnime() {
    this.animate()
        .setDuration(300)
        .scaleX(0f)
        .scaleY(0f)
        .withEndAction {
            this.isVisible = false
        }
        .start()
}

fun ImageView.hideAnime(endAnim: () -> Unit) {
    this.animate()
        .setDuration(300)
        .scaleX(0f)
        .scaleY(0f)
        .withEndAction {
            this.visibility = View.GONE
            endAnim.invoke()
        }
        .start()
}

