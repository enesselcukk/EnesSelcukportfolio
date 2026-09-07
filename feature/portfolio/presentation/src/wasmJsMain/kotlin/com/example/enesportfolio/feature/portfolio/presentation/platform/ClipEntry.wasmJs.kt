package com.example.enesportfolio.feature.portfolio.presentation.platform

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.ClipEntry

@OptIn(ExperimentalComposeUiApi::class)
internal actual fun clipEntryOf(text: String): ClipEntry = ClipEntry.withPlainText(text)
