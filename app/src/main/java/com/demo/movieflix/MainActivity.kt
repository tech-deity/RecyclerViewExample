package com.demo.movieflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MovieItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.layoutManager = LinearLayoutManager(this)
        val items =fetchData()
        val adapter=MovieAdapter(items,this)
        recycler_view.adapter=adapter
        }

    private fun fetchData():ArrayList<String> {
        val list=ArrayList<String>()
        for(i in 0 until 100){
            list.add("items $i")
        }
        return list

    }

    override fun onItemClicked(item: String) {
        Toast.makeText(this,"item clicked $item",Toast.LENGTH_LONG).show()
    }


}
