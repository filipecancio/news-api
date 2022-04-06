package dev.cancio.models

import kotlinx.serialization.Serializable

@Serializable
data class News(
    var id: String,
    var date: String,
    var title: String,
    var urlName: String,
)