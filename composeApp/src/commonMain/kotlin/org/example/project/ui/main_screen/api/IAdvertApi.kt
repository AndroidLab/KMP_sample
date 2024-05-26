package org.example.project.ui.main_screen.api

import de.jensklingenberg.ktorfit.http.GET
import org.example.project.ui.main_screen.data.models.BirdModel


/**
 * Описывает методы. TODO Для сэмпла, удалить, когда будут реальные апи.
 */
interface IBirdApi {

    /**
     * Получает список рекламы.
     */
    @GET("demo-image-api/pictures.json")
    suspend fun getBirds(): List<BirdModel>

}