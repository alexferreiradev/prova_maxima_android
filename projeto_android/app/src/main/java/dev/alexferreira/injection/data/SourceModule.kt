package dev.alexferreira.injection.data

import android.arch.persistence.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dev.alexferreira.data.source.database.ClienteDao
import dev.alexferreira.data.source.database.ContatoClienteDao
import dev.alexferreira.data.source.database.DaoCreator
import dev.alexferreira.data.source.database.PedidoClienteDao
import dev.alexferreira.data.source.network.MaximaApi
import dev.alexferreira.injection.scope.ApplicationScope
import retrofit2.Retrofit

@Module
class SourceModule {
    @ApplicationScope
    @Provides
    fun provideClienteDao(database: RoomDatabase): ClienteDao {
        if (database is DaoCreator) {
            val daoCreator = database as DaoCreator
            return daoCreator.createClienteDao()
        } else {
            throw IllegalArgumentException("Database não implementa DaoCreator")
        }
    }
    
    @ApplicationScope
    @Provides
    fun provideContatoClienteDao(database: RoomDatabase): ContatoClienteDao {
        if (database is DaoCreator) {
            val daoCreator = database as DaoCreator
            return daoCreator.createContatoClienteDao()
        } else {
            throw IllegalArgumentException("Database não implementa DaoCreator")
        }
    }

    @ApplicationScope
    @Provides
    fun providePedidoClienteDao(database: RoomDatabase): PedidoClienteDao {
        if (database is DaoCreator) {
            val daoCreator = database as DaoCreator
            return daoCreator.createPedidoClienteDao()
        } else {
            throw IllegalArgumentException("Database não implementa DaoCreator")
        }
    }

    @ApplicationScope
    @Provides
    fun provideClienteApi(retrofit: Retrofit): MaximaApi {
        return retrofit.create(MaximaApi::class.java)
    }
}
