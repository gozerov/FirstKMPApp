package ru.gozerov.firstkmp.di

import org.koin.core.module.Module
import org.koin.dsl.module
import ru.gozerov.firstkmp.data.remote.KtorService
import ru.gozerov.firstkmp.data.remote.UsersDataSource
import ru.gozerov.firstkmp.data.repositories.UsersRepositoryImpl
import ru.gozerov.firstkmp.domain.repositories.UsersRepository
import ru.gozerov.firstkmp.domain.use_cases.GetUsersUseCase

private fun dataModule() = module {
    factory<UsersRepository> {
        UsersRepositoryImpl(
            usersDataSource = get()
        )
    }
    factory<UsersDataSource> {
        UsersDataSource(
            ktorService = get()
        )
    }
    factory<KtorService> {
        KtorService()
    }
}

private fun domainModule() = module {
    factory<GetUsersUseCase> {
        GetUsersUseCase(
            usersRepository = get()
        )
    }
}

fun getCommonModules() = listOf<Module>(dataModule(), domainModule())