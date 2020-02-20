package com.mayankkasera.triviaapp.ui.main.result

import androidx.lifecycle.ViewModel
import com.mayankkasera.triviaapp.data.results.ResultsRepo
import com.mayankkasera.triviaapp.pojo.Result

class ResultViewModel(var resultsRepo : ResultsRepo):ViewModel() {

    fun insetResult(result: Result){
        resultsRepo.insertResult(result)
    }

}