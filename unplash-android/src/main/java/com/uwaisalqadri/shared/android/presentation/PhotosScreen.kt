package com.uwaisalqadri.shared.android.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uwaisalqadri.shared.android.theme.Dimesion
import com.uwaisalqadri.shared.domain.model.Photo
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalFoundationApi::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun PhotosScreen(
    viewModel: PhotoViewModel = getViewModel()
) {
    LazyColumn {
        stickyHeader {
            Text(
                text = "Photo",
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.secondary,
                modifier = Modifier
                    .padding(start = Dimesion.SIZE_16, top = Dimesion.SIZE_16)
            )
        }

        items(items = viewModel.photos.value.data.orEmpty()) { photo ->
            PhotoRow(photo = photo)
        }
    }
}