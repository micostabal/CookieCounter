package micc.android.cookiecounter.data

import androidx.room.*

@Dao
interface CounterDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCounter(counter: Counter)

    @Query("SELECT * FROM counters WHERE id = :id")
    fun findCounterById(id: String): Counter

    @Query("SELECT * FROM counters WHERE name = :name")
    fun findCounterByName(name: String): Counter

    @Query("SELECT * FROM counters")
    fun getAllCounters(): List<Counter>

    @Query("UPDATE counters SET count = :newCount WHERE id=:counterId")
    fun setCount(counterId: String, newCount: Int)

    @Update
    suspend fun updateCounterDetails(employee: Counter)

    @Delete
    suspend fun deleteCounter(employee: Counter)
}