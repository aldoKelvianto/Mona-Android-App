package com.example.mona

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mona.compose.PreviewScreenHome
import com.example.mona.compose.ScreenHome
import com.example.mona.compose.ThemeMona

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ThemeMona {
                ScreenHome()
            }
        }
    }
}

