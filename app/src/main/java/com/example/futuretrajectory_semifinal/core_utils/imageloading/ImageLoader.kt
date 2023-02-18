package com.example.futuretrajectory_semifinal.core_utils.imageloading

import android.content.Context
import android.widget.ImageView

interface ImageLoader {
    fun load(
        context: Context,
        fromImageUrl: String,
        toImageView: ImageView,
    )
}