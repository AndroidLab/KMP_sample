package org.example.project.di

import org.example.project.preferences.AppPreferences
import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.endpoint
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.project.main_screen.api.IBirdApi
import org.example.project.main_screen.presentation.MainScreenViewModel
import org.example.project.second_screen.SecondScreenViewModel
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
    single {
        ktorfit {
            baseUrl("https://sebastianaigner.github.io/")
            httpClient(HttpClient(CIO) {
                install(DefaultRequest) {
                    //header(HttpHeaders.ContentType, ContentType.Application.Json)
                    //header(HttpHeaders.Authorization, "Bearer ${authService.identityModel.accessToken}")
                }
                // install(HttpCache)
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
                //FlowConverterFactory(),
                //CallConverterFactory(),
            )
        }
    }

    single {
        get<Ktorfit>().create<IBirdApi>()
    }

    single {
        AppPreferences(dataStore = get())
    }

    single {
        MainScreenViewModel(
            ktorfit = get(),
            database = get(),
            preferences = get()
        )
    }

    single {
        SecondScreenViewModel()
    }
}


private fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(getPlatformDIModule(), appModule)
    }

/**
 * Представляет Koin.
 */
object Koin {
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