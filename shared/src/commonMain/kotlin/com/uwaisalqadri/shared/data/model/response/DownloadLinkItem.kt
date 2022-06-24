package com.uwaisalqadri.shared.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DownloadLinkItem(
    @SerialName("download")
    val download: String?,
    @SerialName("download_location")
    val downloadLocation: String?,
    @SerialName("html")
    val html: String?,
    @SerialName("self")
    val self: String?
)