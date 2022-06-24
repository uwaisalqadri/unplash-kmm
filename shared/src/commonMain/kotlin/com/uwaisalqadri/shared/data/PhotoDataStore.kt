package com.uwaisalqadri.shared.data

import com.uwaisalqadri.shared.data.model.response.PhotoItem
import com.uwaisalqadri.shared.data.remote.PhotoApiClient

class PhotoDataStore(private val apiClient: PhotoApiClient): PhotoRepository {
    override suspend fun getPhotos(page: Int, perPage: Int, orderBy: String): List<PhotoItem> {
        return apiClient.getPhotos(page, perPage, orderBy)
    }
}