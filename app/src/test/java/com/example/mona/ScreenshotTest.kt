package com.example.mona

import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.android.ide.common.rendering.api.SessionParams
import com.example.mona.ui.category.SectionCategory
import org.junit.Rule
import org.junit.Test

class ScreenshotTest {

  @get:Rule
  val paparazzi = Paparazzi(
    deviceConfig = DeviceConfig.PIXEL_5,
    renderingMode = SessionParams.RenderingMode.NORMAL,
    showSystemUi = false,
    maxPercentDifference = 1.0,
  )

  @Test
  fun launchSectionCategory() {
    paparazzi.snapshot {
      SectionCategory()
    }
  }
}
