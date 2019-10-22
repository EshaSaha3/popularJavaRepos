package com.musa.popularrepo.model

import com.musa.popularrepo.repository.Items
import com.squareup.moshi.Json

data class NetworkRepo(
    @Json(name = "total_count")
    val count:Long,
    @Json(name = "incomplete_results")
    val incompleteResult :Boolean,
    @Json(name = "items")
    val items : List<Items>
)