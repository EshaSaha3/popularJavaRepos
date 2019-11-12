package com.musa.popularrepo.model


import com.musa.popularrepo.repository.Items
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class NetworkRepo(
    @Json(name = "total_count")
    val count: Long,
    @Json(name = "incomplete_results")
    val incompleteResult: Boolean,
    val items: List<Items>
)