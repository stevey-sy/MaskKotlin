package com.example.maskkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maskkotlin.model.Store

class MainActivity : AppCompatActivity() {
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

        val items = listOf(
            Store("abc", "111", "111", 33.33, 33.33, "약국", "plenty", "33", "33"),
            Store("abc", "111", "111", 33.33, 33.33, "약국", "plenty", "33", "33"),
            Store("abc", "111", "111", 33.33, 33.33, "약국", "plenty", "33", "33"),
            Store("abc", "111", "111", 33.33, 33.33, "약국", "plenty", "33", "33")
        )

        storeAdapter.updateItems(items)

    }
}
