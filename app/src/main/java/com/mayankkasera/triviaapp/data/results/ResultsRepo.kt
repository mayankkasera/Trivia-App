package com.mayankkasera.triviaapp.data.results

import com.mayankkasera.triviaapp.pojo.Result
import com.mayankkasera.triviaapp.roomdb.LocalDataBase
import java.util.*

class ResultsRepo(var localDataBase: LocalDataBase) {

    fun insertResult(result: Result): Long {
        val time = Calendar.getInstance()
        result.calendar = time;
        return localDataBase.getResultDao().insertResult(result)
    }

    fun getAllResult() : List<Result>{
        return localDataBase.getResultDao().getAllResult()
    }


}