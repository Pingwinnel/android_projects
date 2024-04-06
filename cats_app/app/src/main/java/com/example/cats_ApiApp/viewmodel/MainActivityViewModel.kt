package com.example.cats_ApiApp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cats_ApiApp.models.CatsModel


class MainActivityViewModel:ViewModel() {
    lateinit var liveDataList:MutableLiveData<List<CatsModel>>



}