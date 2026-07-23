package com.treinaqa.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/** Cores alinhadas ao site treinaQA (styles.css). */
object TreinaColors {
    val Ink = Color(0xFF141820)
    val InkSoft = Color(0xFF5A6472)
    val Paper = Color(0xFFFFFFFF)
    val Surface = Color(0xFFF7F8FA)
    val Line = Color(0xFFE2E6EC)
    val LineStrong = Color(0xFFC8CED8)
    val Accent = Color(0xFFFF5A3C)
    val AccentDeep = Color(0xFFE0442A)
    val AccentSoft = Color(0xFFFFF0EC)
    val Danger = Color(0xFFC62828)
    val DangerSoft = Color(0xFFFDECEA)
    val PageBg = Color(0xFFEEF1F5)
}

private val LightColors = lightColorScheme(
    primary = TreinaColors.Accent,
    onPrimary = Color.White,
    secondary = TreinaColors.Ink,
    onSecondary = Color.White,
    background = TreinaColors.PageBg,
    onBackground = TreinaColors.Ink,
    surface = TreinaColors.Paper,
    onSurface = TreinaColors.Ink,
    outline = TreinaColors.Line,
    error = TreinaColors.Danger,
    errorContainer = TreinaColors.DangerSoft,
    onError = Color.White,
)

@Composable
fun TreinaQaTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        content = content,
    )
}
