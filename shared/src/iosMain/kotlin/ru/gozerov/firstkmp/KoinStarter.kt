package ru.gozerov.firstkmp

import org.koin.core.context.startKoin
import ru.gozerov.firstkmp.di.getCommonModules

fun initKoin() {
    startKoin {
        modules(getCommonModules())
    }
}