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

@file:OptIn(ExperimentalEncodingApi::class)

package in.org.gotit.nimblepods.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import in.org.gotit.nimblepods.R
import in.org.gotit.nimblepods.data.Battery
import in.org.gotit.nimblepods.data.BatteryComponent
import in.org.gotit.nimblepods.data.BatteryStatus
import in.org.gotit.nimblepods.presentation.theme.NimblePodsTheme
import kotlin.io.encoding.ExperimentalEncodingApi

@Composable
fun BatteryView(
    batteryList: List<Battery>,
    budsRes: Int,
    caseRes: Int
) {
    val left = batteryList.find { it.component == BatteryComponent.LEFT }
    val right = batteryList.find { it.component == BatteryComponent.RIGHT }
    val case = batteryList.find { it.component == BatteryComponent.CASE }

    val leftLevel = left?.level?.coerceIn(0, 100) ?: 0
    val rightLevel = right?.level?.coerceIn(0, 100) ?: 0
    val caseLevel = case?.level?.coerceIn(0, 100) ?: 0

    val leftAvailable = left != null && left.status != BatteryStatus.DISCONNECTED
    val rightAvailable = right != null && right.status != BatteryStatus.DISCONNECTED
    val caseAvailable = case != null && case.status != BatteryStatus.DISCONNECTED
    val isSingleDisplay = leftAvailable && rightAvailable &&
        left?.status == right?.status && (leftLevel - rightLevel) in -3..3

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .widthIn(max = 350.dp)
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(budsRes),
                        contentDescription = stringResource(R.string.buds),
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    if (isSingleDisplay) {
                        BatteryIndicator(
                            leftLevel.coerceAtMost(rightLevel),
                            left?.status ?: BatteryStatus.NOT_CHARGING
                        )
                    } else {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            if (leftAvailable) {
                                BatteryIndicator(
                                    leftLevel,
                                    left?.status ?: BatteryStatus.NOT_CHARGING,
                                    "\uDBC6\uDCE5"
                                )
                            }

                            if (leftAvailable && rightAvailable) {
                                Spacer(modifier = Modifier.width(16.dp))
                            }

                            if (rightAvailable) {
                                BatteryIndicator(
                                    rightLevel,
                                    right?.status ?: BatteryStatus.NOT_CHARGING,
                                    "\uDBC6\uDCE8"
                                )
                            }
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(caseRes),
                        contentDescription = stringResource(R.string.case_alt),
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    if (caseAvailable) {
                        BatteryIndicator(
                            caseLevel,
                            case?.status ?: BatteryStatus.NOT_CHARGING,
                            prefix = if (!isSingleDisplay) "\uDBC3\uDE6C" else ""
                        )
                    }
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BatteryViewPreview() {
    val fakeBattery = listOf(
        Battery(BatteryComponent.LEFT, 85, BatteryStatus.CHARGING),
        Battery(BatteryComponent.RIGHT, 40, BatteryStatus.OPTIMIZED_CHARGING),
        Battery(BatteryComponent.CASE, 60, BatteryStatus.NOT_CHARGING)
    )

    val bg = if (isSystemInDarkTheme()) Color.Black else Color(0xFFF2F2F7)
    NimblePodsTheme(m3eEnabled = false) {
        Box(
            modifier = Modifier
                .background(bg)
                .padding(16.dp)
        ) {
            BatteryView(
                batteryList = fakeBattery,
                budsRes = R.drawable.nimblepods_buds,
                caseRes = R.drawable.nimblepods_case
            )
        }
    }
}
