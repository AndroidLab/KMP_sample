package org.example.project.di

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.endpoint
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.project.preferences.AppPreferences
import org.example.project.ui.bluetooth_screen.BluetoothScreenViewModel
import org.example.project.ui.main_screen.api.IBirdApi
import org.example.project.ui.medicines_screen.MedicinesViewModel
import org.example.project.ui.home_screen.HomeViewModel
import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module


/**
 * Ожидает реализацию DI для конкректной платформы.
 */
expect fun getPlatformDIModule(): Module

/**
 * Представляет DI модуль приложения.
 */
val appModule = module {
    /**
     * Возвращает экземпляр сетевого клиента.
     */
    single {
        ktorfit {
            baseUrl("https://sebastianaigner.github.io/")   //TODO Поменять на рабочий путь.
            httpClient(HttpClient(CIO) {
                install(DefaultRequest) {
                    //TODO Сэмпл для замены на рабочий вариант.
                    //header(HttpHeaders.ContentType, ContentType.Application.Json)
                    //header(HttpHeaders.Authorization, "Bearer ${authService.identityModel.accessToken}")
                }
                install(HttpCache)
                install(ContentNegotiation) {
                    json(
                        Json {
                            prettyPrint = true
                            isLenient = true
                            ignoreUnknownKeys = true
                        }
                    )
                }
                engine {
                    maxConnectionsCount = 1000
                    endpoint {
                        // this: EndpointConfig
                        maxConnectionsPerRoute = 100
                        pipelineMaxSize = 20
                        keepAliveTime = 5000
                        connectTimeout = 30000
                        connectAttempts = 1
                    }
                    /*https {
                    // this: TLSConfigBuilder
                    serverName = "api.ktor.io"
                    }*/
                }
            })
            converterFactories(
                //TODO Сэмпл на добавление конверторов.
                //FlowConverterFactory(),
                //CallConverterFactory(),
            )
        }
    }

    /**
     * TODO Сэмпл на создание реализации Api. В рабочем проекте заменить на реальный.
     */
    single {
        get<Ktorfit>().create<IBirdApi>()
    }

    /**
     * Возвращает экземпляр пользовательских предпочтений.
     */
    single {
        AppPreferences(dataStore = get())
    }

    /**
     * Возвращает модель представления для главного экрана.
     */
    single {
        HomeViewModel(
            ktorfit = get(),
            database = get(),
            preferences = get()
        )
    }

    /**
     * TODO Удалить или заменить на реальный.
     */
    single {
        MedicinesViewModel()
    }

    /**
     * TODO Удалить или заменить на реальный.
     */
    single {
        BluetoothScreenViewModel()
    }
}


private fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(getPlatformDIModule(), appModule)
    }

/**
 * Представляет объект [AppKoin].
 */
object AppKoin {
    private var _di: Koin? = null

    /**
     * Возвращае экземпляр DI.
     */
    val di: Koin
        get() = requireNotNull(_di) { "Koin не инициализирован" }

    /**
     * Устанавливает Koin.
     */
    fun setupKoin(appDeclaration: KoinAppDeclaration = {}) {
        if (_di == null) {
            _di = initKoin(appDeclaration).koin
        }
    }
}