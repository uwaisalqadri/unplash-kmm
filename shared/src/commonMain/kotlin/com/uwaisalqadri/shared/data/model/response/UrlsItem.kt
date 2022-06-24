package com.uwaisalqadri.shared.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UrlsItem(
    @SerialName("full")
    val full: String?,
    @SerialName("raw")
    val raw: String?,
    @SerialName("regular")
    val regular: String?,
    @SerialName("small")
    val small: String?,
    @SerialName("thumb")
    val thumb: String?
)