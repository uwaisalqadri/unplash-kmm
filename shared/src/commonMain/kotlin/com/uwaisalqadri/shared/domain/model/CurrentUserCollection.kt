package com.uwaisalqadri.shared.domain.model

data class CurrentUserCollection(
    val coverPhoto: String,
    val id: Int,
    val lastCollectedAt: String,
    val publishedAt: String,
    val title: String,
    val updatedAt: String,
    val user: String
)