package com.example.new_api_kotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.example.Data
import com.example.new_api_kotlin.R
import com.example.new_api_kotlin.adapter.UserAdapter
import com.example.new_api_kotlin.viewModel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var userRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userRecyclerView=findViewById(R.id.userRecycler)
        loadData()

    }

    fun loadData() {
        userViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.getApiData()
        userViewModel.userDataList.observe(this, Observer {
            initAdapter(it as ArrayList<Data>)
        })
    }

    private fun initAdapter(data:ArrayList<Data>){
        userRecyclerView.layoutManager=LinearLayoutManager(this)
        val userAdapter=UserAdapter(data,this)
        userRecyclerView.adapter=userAdapter
    }
}