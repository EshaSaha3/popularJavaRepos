package com.musa.popularrepo.database


import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Database
import com.musa.popularrepo.model.DomainModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
data class DatabaseModel(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String,
    @Json(name = "html_url")
    val htmlUrl: String,
    val forks: String,
    val watchers: String
)

@Dao
interface DataAccess {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepo(vararg databaseModel: DatabaseModel)

    @Query("SELECT * FROM databaseModel")
    fun getRepo(): LiveData<List<DatabaseModel>>
}

@Database(entities = [DatabaseModel::class], version = 1)
abstract class RepoDatabase : RoomDatabase() {
    abstract val database: DataAccess

}

