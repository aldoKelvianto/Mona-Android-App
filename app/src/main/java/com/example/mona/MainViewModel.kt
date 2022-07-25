package com.example.mona

import android.content.res.Resources
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

class MainViewModel(
    navHostController: NavHostController,
    resources: Resources
): ViewModel() {

    var appState by mutableStateOf(MainState(navHostController, resources))
        private set
}
