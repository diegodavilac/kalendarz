package dev.diegodc.kalendarz

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KalendarzApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}