package com.uwaisalqadri.shared.domain.mapper

import com.uwaisalqadri.shared.data.model.response.*
import com.uwaisalqadri.shared.domain.model.*

fun PhotoItem.map(): Photo {
    return Photo(
        blurHash = blurHash.orEmpty(),
        color = color.orEmpty(),
        createdAt = createdAt.orEmpty(),
        description = description.orEmpty(),
        height = height.orZero(),
        id = id.orEmpty(),
        likedByUser = likedByUser.orFalse(),
        likes = likes.orZero(),
        links = links?.map() ?: DownloadLink(),
        updatedAt = updatedAt.orEmpty(),
        urls = urls?.map() ?: Urls(),
        user = user?.map() ?: User(),
        width = width.orZero()
    )
}

fun UserItem.map(): User {
    return User(
        bio = bio.orEmpty(),
        id = id.orEmpty(),
        instagramUsername = instagramUsername.orEmpty(),
        links = links?.map() ?: PhotoLink(),
        location = location.orEmpty(),
        name = name.orEmpty(),
        portfolioUrl = portfolioUrl.orEmpty(),
        profileImage = profileImage?.map() ?: ProfileImage(),
        totalCollections = totalCollections.orZero(),
        totalLikes = totalLikes.orZero(),
        totalPhotos = totalPhotos.orZero(),
        twitterUsername = twitterUsername.orEmpty(),
        username = username.orEmpty()
    )
}

fun ProfileImageItem.map(): ProfileImage {
    return ProfileImage(
        large = large.orEmpty(),
        medium = medium.orEmpty(),
        small = small.orEmpty()
    )
}

fun UrlsItem.map(): Urls {
    return Urls(
        full = full.orEmpty(),
        raw = raw.orEmpty(),
        regular = regular.orEmpty(),
        small = small.orEmpty(),
        thumb = thumb.orEmpty()
    )
}

fun PhotoLinkItem.map(): PhotoLink {
    return PhotoLink(
        html = html.orEmpty(),
        likes = likes.orEmpty(),
        photos = photos.orEmpty(),
        portfolio = portfolio.orEmpty(),
        self = self.orEmpty()
    )
}

fun DownloadLinkItem.map(): DownloadLink {
    return DownloadLink(
        download = download.orEmpty(),
        downloadLocation = downloadLocation.orEmpty(),
        html = html.orEmpty(),
        self = self.orEmpty()
    )
}

fun Boolean?.orFalse(): Boolean = this ?: false

fun Int?.orZero(): Int = this ?: 0