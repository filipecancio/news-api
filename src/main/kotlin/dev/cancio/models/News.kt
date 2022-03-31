package dev.cancio.models

import kotlinx.serialization.Serializable

@Serializable
data class News(
    val id: String,
    val date: String,
    val title: String,
    val urlName: String,
)