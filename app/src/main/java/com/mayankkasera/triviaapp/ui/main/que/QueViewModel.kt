package com.mayankkasera.triviaapp.ui.main.que

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mayankkasera.triviaapp.data.que.QueRepo
import com.mayankkasera.triviaapp.pojo.Que

class QueViewModel(var queRepo : QueRepo) : ViewModel() {

    var mutableLiveData: MutableLiveData<List<Que>> = MutableLiveData()

    fun loadQue(){
        mutableLiveData.postValue(queRepo.getQue())
    }

}