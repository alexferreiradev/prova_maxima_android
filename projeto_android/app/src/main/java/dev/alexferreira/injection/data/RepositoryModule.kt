package dev.alexferreira.injection.data

import dagger.Binds
import dagger.Module
import dev.alexferreira.data.repository.ClienteRepository
import dev.alexferreira.data.repository.IClienteRepository
import dev.alexferreira.injection.scope.ApplicationScope

@Module
abstract class RepositoryModule {
    @ApplicationScope
    @Binds
    abstract fun provideClienteRepo(repo: ClienteRepository): IClienteRepository
}
