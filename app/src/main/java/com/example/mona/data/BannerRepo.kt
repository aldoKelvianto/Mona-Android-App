package com.example.mona.data

import com.example.mona.R

data class Banner(val resId: Int)

object BannerRepo {

    val sampleBanner = Banner(resId = R.drawable.ic_banner_1)

    val items = listOf(
        sampleBanner,
        Banner(resId = R.drawable.ic_banner_2),
        Banner(resId = R.drawable.ic_banner_3),
        Banner(resId = R.drawable.ic_banner_4),
    )
}
