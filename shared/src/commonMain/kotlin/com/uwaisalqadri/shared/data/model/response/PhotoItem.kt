package com.uwaisalqadri.shared.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotoItem(
    @SerialName("blur_hash")
    val blurHash: String?,
    @SerialName("color")
    val color: String?,
    @SerialName("created_at")
    val createdAt: String?,
    @SerialName("current_user_collections")
    val currentUserCollections: List<CurrentUserCollectionItem>?,
    @SerialName("description")
    val description: String?,
    @SerialName("height")
    val height: Int?,
    @SerialName("id")
    val id: String?,
    @SerialName("liked_by_user")
    val likedByUser: Boolean?,
    @SerialName("likes")
    val likes: Int?,
    @SerialName("links")
    val links: DownloadLinkItem?,
    @SerialName("updated_at")
    val updatedAt: String?,
    @SerialName("urls")
    val urls: UrlsItem?,
    @SerialName("user")
    val user: UserItem?,
    @SerialName("width")
    val width: Int?
)