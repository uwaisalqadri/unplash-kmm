package com.uwaisalqadri.shared.domain

import com.uwaisalqadri.shared.data.PhotoRepository
import com.uwaisalqadri.shared.domain.base.execute
import com.uwaisalqadri.shared.domain.mapper.map
import com.uwaisalqadri.shared.domain.model.Photo
import io.realm.internal.platform.freeze
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class PhotoInteractor(private val repository: PhotoRepository): PhotoUseCase {
    override suspend fun getPhotos(page: Int, perPage: Int, orderBy: String): Flow<List<Photo>> {
        return execute {
            repository.getPhotos(page, perPage, orderBy).map { it.map() }
        }
    }
}