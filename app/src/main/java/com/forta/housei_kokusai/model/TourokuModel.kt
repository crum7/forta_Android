package com.forta.housei_kokusai.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TourokuModel : ViewModel() {



    private val _getuyou1 = MutableLiveData<String>("")
    val getuyou1: LiveData<String> = _getuyou1



}