package com.uwaisalqadri.shared.domain.model

data class User(
    val bio: String = "",
    val id: String = "",
    val instagramUsername: String = "",
    val links: PhotoLink = PhotoLink(),
    val location: String = "",
    val name: String = "",
    val portfolioUrl: String = "",
    val profileImage: ProfileImage = ProfileImage(),
    val totalCollections: Int = 0,
    val totalLikes: Int = 0,
    val totalPhotos: Int = 0,
    val twitterUsername: String = "",
    val username: String = ""
)