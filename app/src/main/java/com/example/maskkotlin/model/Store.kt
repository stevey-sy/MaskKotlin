package com.example.maskkotlin.model

// data class 를 사용하게 되면
// java 에서 처럼 getter, setter 를 만들어주지 않아도
// 자동으로 사용할 수 있다.
data class Store(
    var addr: String,
    var code: String,
    var created_at: String,
    var lat: Double,
    var lng: Double,
    var name: String,
    var remain_stat: String,
    var stock_at: String,
    var type: String
)