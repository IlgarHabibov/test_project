package com.example.atlandroidexamples.lessons.lesson28

import android.content.Context
import com.example.atlandroidexamples.RetrofitConstants
import com.example.atlandroidexamples.lessons.lesson27.AlbumRepository
import com.example.atlandroidexamples.lessons.lesson27.L27Repository
import com.example.atlandroidexamples.lessons.lesson27.NetworkHelper
import com.example.atlandroidexamples.lessons.practice14.AServiceClient
import com.example.atlandroidexamples.lessons.practice14.BServiceClient
import com.example.atlandroidexamples.network.ApiService
import com.example.atlandroidexamples.network.AuthApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(
        @ApplicationContext context: Context,
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit{
        return Retrofit.Builder()
            .baseUrl(RetrofitConstants.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory{
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideOkhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Singleton
    @Provides
    fun provideApiService( retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)
    }


    @Provides
    fun provideRepository(networkHelper: NetworkHelper): L27Repository{
        return L27Repository(networkHelper)
    }

    @Provides
    fun provideAlbumRepository(apiService: ApiService): AlbumRepository {
        return AlbumRepository(apiService)
    }


//    @Provides
//    fun provideAuthRepository(): AuthRepository{
//        return AuthRepositoryImpl()
//    }

}