package dev.cancio.models.request

import dev.cancio.models.CategotyType
import dev.cancio.models.News
import kotlinx.serialization.Serializable

@Serializable
data class PostCategoryRequest (
    val category: CategotyType,
    val news: News
        )