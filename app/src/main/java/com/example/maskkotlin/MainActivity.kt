package com.example.maskkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.lifecycle.Observer
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
        var progressBar : ProgressBar = findViewById(R.id.progressBar)

        recyclerView.apply {
           layoutManager = LinearLayoutManager(this@MainActivity,
                RecyclerView.VERTICAL,
                false
           )
            adapter = storeAdapter
        }


        viewModel.apply {
            itemLiveData.observe(this@MainActivity, Observer{
                storeAdapter.updateItems(it)
            })

            loadingLiveData.observe(this@MainActivity, Observer {
                isLoading ->
//                if (isLoading) {
//                    progressBar.visibility = View.VISIBLE
//                } else {
//                    progressBar.visibility = View.GONE
//                }
                progressBar.visibility = if(isLoading)View.VISIBLE else View.GONE
            })
        }



    }
}
