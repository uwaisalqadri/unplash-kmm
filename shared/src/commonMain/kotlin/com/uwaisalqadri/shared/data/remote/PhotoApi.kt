package com.uwaisalqadri.shared.data.remote

import com.uwaisalqadri.shared.data.model.response.PhotoItem
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class PhotoApi(private val httpClient: HttpClient): PhotoApiClient {

    override suspend fun getPhotos(page: Int, perPage: Int, orderBy: String): List<PhotoItem> {
        return httpClient.get("photos") {
            parameter("page", page)
            parameter("per_page", perPage)
            parameter("order_by", orderBy)
        }.body()
    }
}