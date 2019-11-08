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
    val id: Int,
    val name: String,
    val description: String,
    val htmlUrl: String,
    val forks: Int,
    val watchers: Int
)

@Dao
interface DataAccess {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepo(vararg databaseModel: DatabaseModel)

    @Query("SELECT * FROM databaseModel")
    fun getRepo(): LiveData<List<DatabaseModel>>

    @Query("DELETE FROM databasemodel")
    fun dropTable()
}

@Database(entities = [DatabaseModel::class], version = 1, exportSchema = false)
abstract class RepoDatabase : RoomDatabase() {
    abstract val database: DataAccess

}

