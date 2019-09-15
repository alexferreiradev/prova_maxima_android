package dev.alexferreira.injection.data

import com.nhaarman.mockitokotlin2.mock
import dagger.Module
import dagger.Provides
import dev.alexferreira.data.repository.IClienteRepository
import dev.alexferreira.injection.scope.ApplicationScope

@Module
class FakeRepositoryModule {
    @ApplicationScope
    @Provides
    fun provideClienteRepo(): IClienteRepository {
        return mock()
    }
}
