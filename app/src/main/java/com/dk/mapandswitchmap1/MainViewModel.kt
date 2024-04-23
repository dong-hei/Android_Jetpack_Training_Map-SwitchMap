package com.dk.mapandswitchmap1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    // Transformations -> map / switchMap

    private var _mutableCount = MutableLiveData(0)
    val liveCount : LiveData<Int>
        get() = _mutableCount

    val mapLiveData = Transformations.map(liveCount){
        it+it
    }

    val switchMapLiveData = Transformations.switchMap(liveCount){
        changeVal(it)
    }

    fun setLiveDataVal(count : Int){
        _mutableCount.value = count
    }

    fun changeVal(count : Int) : MutableLiveData<Int>{
        val testLiveData = MutableLiveData(count*count)
        return testLiveData
    }
}