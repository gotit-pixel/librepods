package in.org.gotit.nimblepods.presentation.theme

import androidx.compose.runtime.compositionLocalOf

enum class DesignSystem {
    Classic,
    Material
}

val LocalDesignSystem = compositionLocalOf {
    DesignSystem.Classic
}
