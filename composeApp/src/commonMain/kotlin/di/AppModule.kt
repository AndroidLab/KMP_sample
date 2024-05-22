package di

import AppPreferences
import IAppPreferences
import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import main_screen.api.IBirdApi
import org.koin.dsl.module

/**
 *
 */
val appModule = module {
    single {
        ktorfit {
                baseUrl("https://sebastianaigner.github.io/")
                httpClient(HttpClient {
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
        IAppPreferences()
    }
}