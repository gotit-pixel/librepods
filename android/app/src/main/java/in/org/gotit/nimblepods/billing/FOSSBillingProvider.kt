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

package `in`.org.gotit.nimblepods.billing

import android.app.Activity
import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import `in`.org.gotit.nimblepods.R

/** The FOSS build makes all app features available without a payment gate. */
class FOSSBillingProvider(context: Context) : BillingProvider {
    override val isPremium: StateFlow<Boolean> = MutableStateFlow(true)
    override val price: StateFlow<String> = MutableStateFlow(context.getString(R.string.foss_price_free))

    override fun purchase(activity: Activity) = Unit

    override fun queryPurchases() = Unit

    override fun restorePurchases() = Unit
}
