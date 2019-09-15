package dev.alexferreira.injection.data

import dagger.Binds
import dagger.Module
import dev.alexferreira.data.repository.ClienteRepository
import dev.alexferreira.data.repository.IClienteRepository
import dev.alexferreira.data.repository.IPedidoClienteRepository
import dev.alexferreira.data.repository.PedidoClienteRepository
import dev.alexferreira.injection.scope.ApplicationScope

@Module
abstract class RepositoryModule {
    @ApplicationScope
    @Binds
    abstract fun provideIClienteRepository(repo: ClienteRepository): IClienteRepository

    @ApplicationScope
    @Binds
    abstract fun provideIPedidoClienteRepository(repo: PedidoClienteRepository): IPedidoClienteRepository
}
