package com.uwaisalqadri.shared.android.presentation

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.semantics.Role.Companion.Image
import com.google.accompanist.coil.rememberCoilPainter
import com.uwaisalqadri.shared.android.theme.Dimesion
import com.uwaisalqadri.shared.domain.model.Photo
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale

@Composable
fun PhotoRow(
    photo: Photo
) {
    Card(shape = RoundedCornerShape(Dimesion.SIZE_8)) {
        Image(
            painter = rememberCoilPainter(request = photo.urls.small),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimesion.SIZE_200)
        )
    }
}