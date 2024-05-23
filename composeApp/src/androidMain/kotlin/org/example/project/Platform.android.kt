package org.example.project

import android.os.Build

class AndroidPlatform : Platform {
    override val name = "Android ${Build.VERSION.SDK_INT}"
    override val type = Platform.Type.ANDROID
}

actual fun getPlatform(): Platform = AndroidPlatform()
