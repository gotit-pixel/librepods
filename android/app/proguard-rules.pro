# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Retain the Xposed entry point named by META-INF/xposed/java_init.list.
-keep class in.org.gotit.nimblepods.utils.KotlinModule { *; }

# Native JNI symbol uses this exact class and method name.
-keep class in.org.gotit.nimblepods.utils.NativeBridge { *; }

# Battery is the app's Parcelable model; keep its CREATOR and parceling members.
-keep class in.org.gotit.nimblepods.data.Battery implements android.os.Parcelable { *; }

# Preserve annotations and signatures consumed by Kotlin/Xposed reflection.
-keepattributes RuntimeVisibleAnnotations,RuntimeInvisibleAnnotations,AnnotationDefault,Signature,InnerClasses,EnclosingMethod
