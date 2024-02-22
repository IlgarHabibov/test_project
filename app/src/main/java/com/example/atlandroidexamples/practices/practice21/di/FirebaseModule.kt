package com.example.atlandroidexamples.practices.practice21.di

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Singleton
    @Provides
    fun provideFireStore(): FirebaseFirestore{
        return Firebase.firestore
    }

    @Singleton
    @Provides
    fun provideStorage(): FirebaseStorage{
        return Firebase.storage
    }

    @Singleton
    @Provides
    fun provideRemoteConfig(): FirebaseRemoteConfig{
        return Firebase.remoteConfig
    }

}