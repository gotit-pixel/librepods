package in.org.gotit.nimblepods.presentation.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import in.org.gotit.nimblepods.BuildConfig
import in.org.gotit.nimblepods.R

@Composable
fun PrivacyPolicyPage(
    onForward: () -> Unit
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier.background(
            color = MaterialTheme.colorScheme.surfaceContainer,
            shape = RoundedCornerShape(42.dp)
        )
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Last updated: 23 November 2026",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = "Public privacy policy: https://gotit.org.in/privacy-policy/",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Overview",
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = "NimblePods does not collect, store, sell, or share personal information for advertising, analytics, tracking, or profiling purposes. The app does not include analytics, crash reporting, telemetry, advertising SDKs, or tracking services.",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "NimblePods does not send diagnostics or usage data to a server. Information leaves your device only when you choose to send a support email or use Google Play billing in the Play build.",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Third Party Services",
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = "NimblePods links to the GOT IT website and support email. These links open other apps; NimblePods does not send information automatically.",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Email",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = "If you contact support, GOT IT receives your email address and the message you choose to send. The in-app support form can include app version, device model, and Android build details in a draft email. You can edit or remove those details before sending.",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "You can edit or remove any of this information before sending the email.",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "GOT IT Support",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = "The app provides links to the GOT IT website and support email. Opening either link transfers control to your browser or email app.",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "NimblePods does not automatically send device information or usage data to GOT IT.",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Email support",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = "The in-app support form may pre-fill these details in a draft email:",
                style = MaterialTheme.typography.bodyMedium
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    "• NimblePods version name and version code",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "• Device manufacturer and model",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "• Android build information",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "• Installation source (Google Play or GitHub)",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Text(
                text = "The email app lets you review and edit this information. Nothing is sent until you choose to send the email.",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Payments", style = MaterialTheme.typography.titleLarge
            )

            if (BuildConfig.PLAY_BUILD) {
                Text(
                    text = "Google Play", style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "When using the version available on Google Play, purchases are processed by Google Play.",
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "Google Play processes purchases. NimblePods does not operate a payment server or receive payment credentials.",
                    style = MaterialTheme.typography.bodyMedium
                )
            } else {
                Text(
                    text = "FOSS build", style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "The FOSS build includes the advanced features without in-app purchases or sponsorship prompts.",
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "No sponsorship transaction is initiated by NimblePods.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Text(
                text = "Contact", style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = "If you have questions about this privacy policy, please email support@gotit.org.in.",
                style = MaterialTheme.typography.bodyMedium
            )

            Button(
                onClick = onForward,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.i_agree),
                    style = MaterialTheme.typography.labelMediumEmphasized
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
