package com.uwaisalqadri.shared.domain.model

data class Photo(
    val blurHash: String,
    val color: String,
    val createdAt: String,
    val currentUserCollections: List<CurrentUserCollection>,
    val description: String,
    val height: Int,
    val id: String,
    val likedByUser: Boolean,
    val likes: Int,
    val links: DownloadLink,
    val updatedAt: String,
    val urls: Urls,
    val user: User,
    val width: Int
)