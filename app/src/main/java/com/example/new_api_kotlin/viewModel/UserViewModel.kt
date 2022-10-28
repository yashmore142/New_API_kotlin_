package com.example.new_api_kotlin.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.example.Data
import com.example.example.ExampleJson2KtKotlin
import com.example.new_api_kotlin.network.RetrofitInstance
import com.example.new_api_kotlin.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel:ViewModel() {
    var userDataList=MutableLiveData<List<Data>>()

    fun getApiData(){
        val retrofitService=RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)

        retrofitService.getData().enqueue(object :Callback<ExampleJson2KtKotlin>{
          /*  override fun onResponse(call: Call<List<Data>>, response: Response<List<ExampleJson2KtKotlin>>) {
                userDataList.value=response.body()
                Log.e("tag","success..")
            }*/

            override fun onResponse(call: Call<ExampleJson2KtKotlin>, response: Response<ExampleJson2KtKotlin>) {
                userDataList.value= response.body()!!.data
                Log.e("tag","success..")
            }
            override fun onFailure(call: Call<ExampleJson2KtKotlin>, t: Throwable) {
                Log.e("tag","fail..")
            }

        })
    }
}