package micc.android.cookiecounter.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import micc.android.cookiecounter.data.CounterDao
import micc.android.cookiecounter.data.CounterRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCounterRepository(employeeDao: CounterDao): CounterRepository {
        return CounterRepository(employeeDao)
    }

}