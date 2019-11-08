package com.musa.popularrepo.model

import com.google.gson.annotations.SerializedName
import com.musa.popularrepo.repository.Items


data class NetworkRepo(
    @SerializedName("total_count")
    val count: Long,
    @SerializedName("incomplete_results")
    val incompleteResult: Boolean,
    @SerializedName("items")
    val items: List<Items>
)