package com.example.mona.data

import com.example.mona.R

data class Banner(val resId: Int)

object BannerData {

    val banner1 = Banner(resId = R.drawable.ic_banner_1)

    val items = listOf(
        banner1,
        Banner(resId = R.drawable.ic_banner_2),
        Banner(resId = R.drawable.ic_banner_3),
        Banner(resId = R.drawable.ic_banner_4),
    )
}
