package `in`.org.gotit.nimblepods.data.updates

import androidx.compose.runtime.Composable
import `in`.org.gotit.nimblepods.R
import `in`.org.gotit.nimblepods.presentation.screens.AirPodsSettingsScreenPreviewMaterial
import `in`.org.gotit.nimblepods.presentation.screens.EqualizerScreenPreviewApple
import `in`.org.gotit.nimblepods.presentation.screens.EqualizerScreenPreviewMaterial
import `in`.org.gotit.nimblepods.presentation.theme.DesignSystem
import `in`.org.gotit.nimblepods.presentation.theme.LocalDesignSystem

val update1_0_0 = listOf(
        UpdateItem(
            titleRes = R.string.material3e,
            descriptionRes = R.string.update_m3e_description,
            demoComposeable = @Composable {
                AirPodsSettingsScreenPreviewMaterial()
            }
        ),
        UpdateItem(
            titleRes = R.string.equalizer,
            descriptionRes = R.string.update_equalizer_description,
            demoComposeable = @Composable {
                when (LocalDesignSystem.current) {
                    DesignSystem.Classic -> {
                        EqualizerScreenPreviewApple()
                    }
                    DesignSystem.Material -> {
                        EqualizerScreenPreviewMaterial()
                    }
                }
            }
        ),
    )

val updates = update1_0_0
