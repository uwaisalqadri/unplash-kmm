package com.uwaisalqadri.shared.domain

import com.uwaisalqadri.shared.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface PhotoUseCase {
    suspend fun getPhotos(page: Int, perPage: Int, orderBy: String): Flow<List<Photo>>
}