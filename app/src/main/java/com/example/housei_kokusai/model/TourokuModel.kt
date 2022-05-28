package com.example.housei_kokusai.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.housei_kokusai.R

class TourokuModel : ViewModel() {



    private val _getuyou1 = MutableLiveData<String>("")
    val getuyou1: LiveData<String> = _getuyou1



}