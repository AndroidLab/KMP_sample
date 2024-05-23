package org.example.project.main_screen.api

import de.jensklingenberg.ktorfit.http.GET
import org.example.project.main_screen.data.models.BirdModel


/**
 * Описывает методы.
 */
interface IBirdApi {

    /**
     * Получает список рекламы.
     */
    @GET("demo-image-api/pictures.json")
    suspend fun getBirds(): List<BirdModel>

}