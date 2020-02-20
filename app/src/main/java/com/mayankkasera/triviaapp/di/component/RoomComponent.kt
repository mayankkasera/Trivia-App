package com.mayankkasera.triviaapp.di.component

import android.content.Context
import androidx.room.Room
import com.mayankkasera.triviaapp.R
import com.mayankkasera.triviaapp.data.RoomDatabaseHelper
import com.mayankkasera.triviaapp.di.modules.RoomModule
import com.mayankkasera.triviaapp.roomdb.LocalDataBase
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Singleton
@Component(modules = [RoomModule::class])
interface RoomComponent {

    fun inject(roomDatabaseHelper: RoomDatabaseHelper)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): RoomComponent
    }

}