package me.kavishdevar.librepods.presentation.theme

import androidx.compose.runtime.compositionLocalOf

enum class DesignSystem {
    Classic,
    Material
}

val LocalDesignSystem = compositionLocalOf {
    DesignSystem.Classic
}
