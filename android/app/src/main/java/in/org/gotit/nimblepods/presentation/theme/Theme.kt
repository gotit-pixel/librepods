/*
    LibrePods - AirPods liberated from Apple’s ecosystem
    Copyright (C) 2025 LibrePods contributors

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

package in.org.gotit.nimblepods.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

val ColorScheme.sectionHeader: Color
    get() = onBackground.copy(alpha = 0.6f)

private val ClassicDarkColorScheme = darkColorScheme(
    surfaceContainer = Color(0xFF10191F),
    onBackground = Color(0xFFF2F7F8),
    surface = Color(0xFF18242B),
    onSurface = Color(0xFFF2F7F8),
    surfaceDim = Color(0x663B535A),
    primary = Color(0xFF82E5D5),
    secondaryContainer = Color(0xFF23464B),
    onSecondaryContainer = Color(0xFFB5F2E9),
    onPrimary = Color(0xFF052722)
)

private val ClassicLightColorScheme = lightColorScheme(
    surfaceContainer = Color(0xFFF0F6F5),
    onBackground = Color(0xFF142321),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF142321),
    surfaceDim = Color(0x405A7772),
    secondaryContainer = Color(0xFFBFECE5),
    onSecondaryContainer = Color(0xFF07574E),
    primary = Color(0xFF006B60),
    onPrimary = Color(0xFFFFFFFF)
)

@Composable
fun NimblePodsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    m3eEnabled: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        m3eEnabled -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> ClassicDarkColorScheme
        else -> ClassicLightColorScheme
    }

    CompositionLocalProvider(
        LocalDesignSystem provides
            if (m3eEnabled) DesignSystem.Material
            else DesignSystem.Classic
    ) {
        MaterialExpressiveTheme(
            colorScheme = colorScheme,
            motionScheme = MotionScheme.expressive(),
            typography = if (m3eEnabled) MaterialTypography else ClassicTypography,
            content = content
        )
    }
}
