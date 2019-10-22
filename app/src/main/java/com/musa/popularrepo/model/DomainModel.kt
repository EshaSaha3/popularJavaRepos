package com.musa.popularrepo.model

data class DomainModel(
    val id: Int,
    val name: String,
    val description: String,
    val htmlUrl: String,
    val forks: Int,
    val watchers: Int
)