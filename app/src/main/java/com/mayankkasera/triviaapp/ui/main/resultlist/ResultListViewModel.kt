package com.mayankkasera.triviaapp.ui.main.resultlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mayankkasera.triviaapp.data.results.ResultsRepo
import com.mayankkasera.triviaapp.pojo.Que
import com.mayankkasera.triviaapp.pojo.Result

class ResultListViewModel(val resultsRepo: ResultsRepo):ViewModel() {

    //Live data
    var mutableLiveData: MutableLiveData<List<Result>> = MutableLiveData()

    /*
       For geting que
    */
    fun loadQue(){
        mutableLiveData.postValue(resultsRepo.getAllResult())
    }


}