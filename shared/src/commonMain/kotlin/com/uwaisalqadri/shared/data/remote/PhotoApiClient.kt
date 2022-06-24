package com.uwaisalqadri.shared.data.remote

import com.uwaisalqadri.shared.data.model.response.PhotoItem

interface PhotoApiClient {
    suspend fun getPhotos(page: Int, perPage: Int, orderBy: String): List<PhotoItem>
}