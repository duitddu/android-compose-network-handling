package com.duitddu.android.compose.network.handling.util.di

import android.content.Context
import com.duitddu.android.compose.network.handling.util.network.NetworkChecker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNetworkChecker(
        @ApplicationContext context: Context
    ) : NetworkChecker = NetworkChecker(context)
}