package com.uwaisalqadri.shared.data

import com.uwaisalqadri.shared.data.model.response.PhotoItem
import com.uwaisalqadri.shared.data.remote.UnplashApiClient

class UnplashDataStore(private val apiClient: UnplashApiClient): UnplashRepository {
    override suspend fun getPhotos(page: Int, perPage: Int, orderBy: String): List<PhotoItem> {
        return apiClient.getPhotos(page, perPage, orderBy)
    }
}