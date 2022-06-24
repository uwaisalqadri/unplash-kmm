package com.uwaisalqadri.shared.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoLinkItem(
    @SerialName("html")
    val html: String?,
    @SerialName("likes")
    val likes: String?,
    @SerialName("photos")
    val photos: String?,
    @SerialName("portfolio")
    val portfolio: String?,
    @SerialName("self")
    val self: String?
)