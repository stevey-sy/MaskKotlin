package com.example.maskkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maskkotlin.model.Store
import com.example.maskkotlin.repository.MaskService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {
    val itemLiveData = MutableLiveData<List<Store>>()
    val loadingLiveData = MutableLiveData<Boolean>()

    // lateinit 이란
    // 나중에 초기화해도 되는 변수를 사용할 때 선언
    private val service: MaskService
    // ex) 자바에서
    // MaskService service;
    // 도 나중에 변수의 내용을 선언해서 사용하겠다.
    // 할 때 사용하는 것처럼..

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(MaskService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        service = retrofit.create(MaskService::class.java)

        fetchStoreInfo()
    }

    fun fetchStoreInfo() {
        // 로딩 시작
        loadingLiveData.value = true

        // coroutine 사용
        // view Model 의 lifecycle 안에 있을 때 작동하겠다.
        viewModelScope.launch {
            val storeInfo = service.fetchStoreInfo(37.188078, 127.043002)
            itemLiveData.value = storeInfo.stores

            // 로딩 끝
           loadingLiveData.value = false
        }

    }



}