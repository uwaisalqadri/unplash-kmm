package com.uwaisalqadri.shared.data.remote

import com.uwaisalqadri.shared.data.model.response.PhotoItem

interface UnplashApiClient {
    suspend fun getPhotos(page: Int, perPage: Int, orderBy: String): List<PhotoItem>
}