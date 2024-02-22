package com.example.atlandroidexamples.practices.practice14

import android.content.Context
import androidx.room.Room
import com.example.atlandroidexamples.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase{
        return Room.databaseBuilder(
            context =  context,
            klass =  AppDatabase::class.java,
            name = "app-database"
        ).allowMainThreadQueries()
            .build()
    }
}