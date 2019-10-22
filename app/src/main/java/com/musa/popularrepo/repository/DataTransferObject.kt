package com.musa.popularrepo.repository

import com.musa.popularrepo.database.DatabaseModel
import com.musa.popularrepo.model.DomainModel
import com.squareup.moshi.Json


@Json(name = "items")
data class Items(
    val id: Int,
    val name: String,
    val description: String,
    @Json(name = "html_url")
    val htmlUrl: String,
    val forks: Int,
    val watchers: Int
)

fun List<Items>.asDatabaseModel(): Array<DatabaseModel> {
    return map {
        DatabaseModel(
            id = it.id,
            name = it.name,
            description = it.description,
            htmlUrl = it.htmlUrl,
            forks = it.forks,
            watchers = it.watchers
        )
    }.toTypedArray()
}


fun List<DatabaseModel>.asDomainModel():List<DomainModel>{
    return map {
        DomainModel(
            id = it.id,
            name = it.name,
            description = it.description,
            htmlUrl = it.htmlUrl,
            forks = it.forks,
            watchers = it.watchers
        )

    }

}