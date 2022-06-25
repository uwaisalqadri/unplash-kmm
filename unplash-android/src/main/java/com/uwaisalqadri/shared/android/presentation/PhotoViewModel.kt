package com.uwaisalqadri.shared.android.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uwaisalqadri.shared.domain.PhotoUseCase
import com.uwaisalqadri.shared.domain.model.Photo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import com.uwaisalqadri.shared.android.utils.Result as Result

class PhotoViewModel(private val photoUseCase: PhotoUseCase): ViewModel() {

    private val _photos = MutableStateFlow<Result<List<Photo>>>(Result())
    val photos: StateFlow<Result<List<Photo>>> = _photos.asStateFlow()

    init {
        getPhotos()
    }

    fun getPhotos() = viewModelScope.launch {
        _photos.value = Result.loading()
        photoUseCase.getPhotos(page = 1, perPage = 100, orderBy = "latest")
            .catch { cause: Throwable ->
                _photos.value = Result.failed(cause)
            }
            .collect { result ->
                Log.d("getPhotos", result.toString())
                if (result.isNotEmpty()) {
                    _photos.value = Result.success(result)
                } else {
                    _photos.value = Result.empty()
                }
            }
    }
}