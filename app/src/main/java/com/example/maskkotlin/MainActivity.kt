package com.example.maskkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maskkotlin.model.Store
import com.example.maskkotlin.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    // ktx 사용
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val storeAdapter = StoreAdapter()

        var recyclerView : RecyclerView = findViewById(R.id.recycler_view);

        recyclerView.apply {
           layoutManager = LinearLayoutManager(this@MainActivity,
                RecyclerView.VERTICAL,
                false
           )
            adapter = storeAdapter
        }


    }
}
