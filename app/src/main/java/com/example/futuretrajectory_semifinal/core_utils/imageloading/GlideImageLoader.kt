package com.example.futuretrajectory_semifinal.core_utils.imageloading

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.futuretrajectory_semifinal.R

class GlideImageLoader : ImageLoader {
    override fun load(context: Context, fromImageUrl: String, toImageView: ImageView) {
        Glide
            .with(context)
            .load(fromImageUrl)
            .placeholder(R.drawable.poster_placeholder)
            .into(toImageView)
    }
}