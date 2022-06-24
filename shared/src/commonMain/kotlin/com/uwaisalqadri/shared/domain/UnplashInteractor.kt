package com.uwaisalqadri.shared.domain

import com.uwaisalqadri.shared.data.UnplashRepository
import com.uwaisalqadri.shared.domain.base.execute
import com.uwaisalqadri.shared.domain.mapper.map
import com.uwaisalqadri.shared.domain.model.Photo
import kotlinx.coroutines.flow.Flow

class UnplashInteractor(private val repository: UnplashRepository): UnplashUseCase {
    override suspend fun getPhotos(page: Int, perPage: Int, orderBy: String): Flow<List<Photo>> {
        return execute {
            repository.getPhotos(page, perPage, orderBy).map()
        }
    }
}