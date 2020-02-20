package com.mayankkasera.triviaapp.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mayankkasera.triviaapp.pojo.Result

@Dao
interface ResultDeo {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertResult(result: Result): Long

    @Query("SELECT * FROM Result")
    fun getAllResult(): List<Result>

}