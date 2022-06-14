package com.example.mona.ui

import androidx.compose.ui.unit.Dp
import com.example.mona.data.Banner
import com.example.mona.data.Category
import com.example.mona.ui.location.LocationState

data class ScreenHomeState(
    val locationState: LocationState,
    val greeting: String,
    val hint: String,
    val bannerList: List<Banner>,
    val categoryList: List<Category>,
    val bottomPadding: Dp
)
