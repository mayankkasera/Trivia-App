package com.mayankkasera.triviaapp.data

import com.mayankkasera.triviaapp.roomdb.LocalDataBase
import com.mayankkasera.triviaapp.utils.App
import javax.inject.Inject

class RoomDatabaseHelper {

    init {
        App.roomComponent()?.inject(this)
    }

    @Inject
    lateinit var localeDataBase: LocalDataBase
}