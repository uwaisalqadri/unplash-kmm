package com.uwaisalqadri.shared.android.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uwaisalqadri.shared.android.theme.Dimesion
import com.uwaisalqadri.shared.android.theme.setWhiteStatusBar
import com.uwaisalqadri.shared.domain.model.Photo
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalFoundationApi::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun PhotosScreen(
    viewModel: PhotoViewModel = getViewModel()
) {
    val photos by viewModel.photos.collectAsState()

    setWhiteStatusBar()

    LazyColumn {
        stickyHeader {
            Row(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(80.dp)
            ) {
                Text(
                    text = "Photo",
                    style = MaterialTheme.typography.h4,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = Dimesion.SIZE_16, top = Dimesion.SIZE_16)
                )
            }
        }

        items(items = photos.data.orEmpty()) { photo ->
            PhotoRow(
                photo = photo,
                modifier = Modifier
                    .padding(horizontal = Dimesion.SIZE_16)
                    .padding(vertical = Dimesion.SIZE_6)
            )
        }
    }
}