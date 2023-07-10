package micc.android.cookiecounter.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Counter::class)], version = 3, exportSchema = false)
abstract class RoomCounterDB : RoomDatabase() {

    abstract fun counterDao(): CounterDao

    companion object {
        @Volatile
        private var INSTANCE: RoomCounterDB? = null

        fun getInstance(context: Context): RoomCounterDB {
            // only one thread of execution at a time can enter this block of code
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RoomCounterDB::class.java,
                        "counter_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}