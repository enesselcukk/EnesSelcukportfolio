package com.example.enesportfolio.feature.portfolio.presentation.platform

import android.content.ClipData
import androidx.compose.ui.platform.ClipEntry
import androidx.compose.ui.platform.toClipEntry

internal actual fun clipEntryOf(text: String): ClipEntry =
    ClipData.newPlainText("selection", text).toClipEntry()
