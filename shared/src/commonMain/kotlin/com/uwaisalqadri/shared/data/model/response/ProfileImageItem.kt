package com.uwaisalqadri.shared.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileImageItem(
    @SerialName("large")
    val large: String?,
    @SerialName("medium")
    val medium: String?,
    @SerialName("small")
    val small: String?
)