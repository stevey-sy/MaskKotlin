package com.example.maskkotlin.model

// data class 를 사용하게 되면
// java 에서 처럼 getter, setter 를 만들어주지 않고
// 변수명을 직접 사용해도 된다.
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