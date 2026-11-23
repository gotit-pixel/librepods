# NimblePods Play Store release checklist

## Build identity

- Package ID and Android namespace: `in.org.gotit.nimblepods`.
- Minimum Android API: 33 (Android 13); `compileSdk` and `targetSdk` remain 37.
- The Play listing should use the name **NimblePods**. Do not use Apple product names or logos in the app title or icon.
- Suggested short description: “Control supported wireless earbuds from Android.”
- Include this notice in the listing: “NimblePods is an independent project and is not affiliated with Apple Inc.”

## Play Console setup still required

- Create a one-time in-app product with ID `nimblepods_advanced_features` (the code queries `INAPP` with this exact ID). Purchases remain unavailable until the product is active and configured in Play Console.
- Add the public privacy policy URL: https://gotit.org.in/privacy-policy/.
- The source repository is public at https://github.com/gotit-pixel/librepods. Keep the `LICENSE` and upstream copyright headers when distributing the GPL-3.0-or-later fork.
- Review permission declarations in Play Console. The Play manifest omits the system-only `BLUETOOTH_PRIVILEGED`, `MODIFY_PHONE_STATE`, `LOCAL_MAC_ADDRESS`, and `INTERACT_ACROSS_USERS` permissions. The app still declares connected-device foreground service, overlay, phone-state, and call-answering permissions for its corresponding features; provide the required feature/policy justifications or remove the feature and permission if it is not approved.
- Complete the Data safety form against the final Play build and the linked privacy policy. The app currently has no `INTERNET` permission; Google Play Billing is still used by the Play flavor.
- The app name “NimblePods” has not been trademark-cleared. Search the IP India trademark register before publishing.

## Backup behavior

Cloud backup and device transfer exclude `settings.xml` (which can contain paired-device identifiers), `packet_logs.xml`, and the app's `files/logs/` support logs. Other eligible app data remains subject to Android backup behavior.
