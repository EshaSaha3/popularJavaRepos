package com.musa.popularrepo.database


import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Database
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class Repo(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val description: String,
    @Json(name = "html_url")
    val htmlUrl: String,
    val forks: String,
    val watchers: String
)

@Dao
interface DataAccess {
    @Insert
    fun insertRepo(vararg repo: Repo)

    @Query("SELECT * FROM repo")
    fun getRepo(): LiveData<List<Repo>>
}

@Database(entities = [Repo::class], version = 1)
abstract class RepoDatabase : RoomDatabase() {
    abstract val database: DataAccess

}

