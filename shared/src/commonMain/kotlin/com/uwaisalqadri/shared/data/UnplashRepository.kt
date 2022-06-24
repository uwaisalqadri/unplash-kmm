package com.uwaisalqadri.shared.data

import com.uwaisalqadri.shared.data.model.response.PhotoItem

interface UnplashRepository {
    suspend fun getPhotos(page: Int, perPage: Int, orderBy: String): List<PhotoItem>
}