package in.org.gotit.nimblepods.data

import androidx.core.content.edit
import in.org.gotit.nimblepods.utils.XposedServiceHolder

class XposedRemotePrefImpl: XposedRemotePref {
    override fun isAvailable(): Boolean {
        return XposedServiceHolder.service != null
    }

    override fun getBoolean(key: String, def: Boolean): Boolean {
        val s = XposedServiceHolder.service ?: return def
        return s.getRemotePreferences("in.org.gotit.nimblepods").getBoolean(key, def)
    }

    override fun putBoolean(key: String, value: Boolean) {
        val s = XposedServiceHolder.service ?: return
        s.getRemotePreferences("in.org.gotit.nimblepods")
            .edit { putBoolean(key, value) }
    }
}
