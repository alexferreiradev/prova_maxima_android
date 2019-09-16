package dev.alexferreira.injection.data

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dev.alexferreira.injection.scope.ApplicationScope
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @ApplicationScope
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        val gsonConverterFactory = GsonConverterFactory.create(gson)
        return Retrofit.Builder().baseUrl("https://api.myjson.com").addConverterFactory(gsonConverterFactory).build()
    }
}
