package com.mayankkasera.triviaapp.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mayankkasera.triviaapp.pojo.Result


@TypeConverters(Result.QAConverter::class,Result.DateTimeConverters::class)
@Database(entities = [Result::class], version = 1,exportSchema = false)
abstract class LocalDataBase : RoomDatabase() {
    abstract fun getResultDao(): ResultDeo
}