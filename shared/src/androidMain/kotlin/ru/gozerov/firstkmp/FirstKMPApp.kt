package ru.gozerov.firstkmp

import android.app.Application
import org.koin.core.context.startKoin
import ru.gozerov.firstkmp.di.getCommonModules

class FirstKMPApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(getCommonModules())
        }
    }

}