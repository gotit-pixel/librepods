# NimblePods baseline

## Source snapshot

- Upstream: `https://github.com/librepods-org/librepods`
- Inspected branch: `main`
- Commit: `89356c08cea3db0b6b54792d9329d09a87cc85fa` (2026-10-16)
- License: GNU GPL version 3 or later (`LICENSE`)
- Android source: `android/`
- Local work branch: `feature/podsphere-bootstrap`
- Current display name: `NimblePods`

The source contains the existing Android application, Bluetooth protocol managers (AACP, ATT, BLE, L2CAP), Compose UI, a C++ native component, widgets, background service, and optional Xposed/root integration. The upstream README marks individual capabilities as implemented, experimental, unknown, or unavailable; those labels remain the baseline until device testing provides new evidence.

## Build configuration

- Gradle wrapper: 9.4.1
- Android Gradle Plugin: 9.2.1
- Kotlin: 2.3.21
- Java: 21
- `compileSdk` / `targetSdk`: 37
- FOSS debug minimum SDK: 33
- Play minimum SDK: 36
- NDK: 30.0.14904198
- CMake: 3.22.1
- Initial build target: `./gradlew :app:assembleFossDebug`

Upstream Android CI uses Ubuntu 24.04, Java 21, Android SDK tools, and the pinned NDK. Its Android build command is `./gradlew assembleFossDebug`.

## Baseline build attempt

The build did not reach Gradle configuration. The wrapper tried downloading `https://services.gradle.org/distributions/gradle-9.4.1-bin.zip` and failed with `java.net.SocketException: Network is unreachable`. This environment also has no detected Android SDK (`ANDROID_HOME` / SDK platform tools absent). No APK was produced, and no compilation or device compatibility is claimed.

## Access and naming notes

- The connected GitHub integration has read permission but no push permission for upstream. No fork or remote changes were made.
- Upstream is GPL-3.0-or-later, and its README explicitly says GPL does not grant permission to use LibrePods' name or logo. Preserve source notices and attribution while removing LibrePods branding from the distributable NimblePods build.
- A preliminary web search found existing software/business use of “PodSphere,” including a podcast-host platform at `podsphere.io`. This is a potential naming conflict, not a trademark clearance determination. Search the relevant trademark registries and app stores before publication.
- A preliminary exact-name search for “NimblePods” did not surface a directly competing earbuds app. This is not trademark clearance; check trademark registries and app stores before publication.
- Google AI Studio is not required for the Bluetooth companion-app build. No AI feature is part of the current project scope.

## Initial NimblePods implementation

- App label and localized app references use NimblePods.
- The adaptive launcher icon is an original vector mark, with a matching monochrome icon.
- The app's classic palette uses a teal/graphite identity; Material 3 Expressive with Android dynamic colors remains the default.
- The UI uses Android's default sans-serif font instead of the upstream bundled SF Pro file.
- The battery screen uses original generic earbud and case illustrations; the upstream AirPods render images were removed from packaged resources.
- The application ID and Kotlin namespace remain upstream values for this initial pass, preserving existing storage and optional Xposed integration. Legal source notices remain intact.
- Build retry after these changes is still blocked before Gradle configuration because downloading Gradle 9.4.1 fails with `java.net.SocketException: Network is unreachable`. No APK or compilation result is available.

## Next environment requirements

1. A runner with outbound access to Gradle/plugin/dependency repositories and the Android SDK platform 37, build tools, NDK 30.0.14904198, and CMake 3.22.1.
2. A writable GitHub destination or permission to create a fork, if remote branch/PR work is wanted.
3. Device access for Samsung and other Android compatibility checks; compile success alone cannot validate Bluetooth behavior.
