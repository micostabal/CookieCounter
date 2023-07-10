package micc.android.cookiecounter.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import micc.android.cookiecounter.data.CounterDao
import micc.android.cookiecounter.data.RoomCounterDB
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private object DatabaseModule {

    @Provides
    fun provideEmployeeDao(appDatabase: RoomCounterDB): CounterDao {
        return appDatabase.counterDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): RoomCounterDB {
        return Room.databaseBuilder(
            context.applicationContext,
            RoomCounterDB::class.java,
            "appDB"
        ).fallbackToDestructiveMigration().build()
    }

}