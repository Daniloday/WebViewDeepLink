package com.missclick.webviewdeeplink.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.missclick.webviewdeeplink.data.models.Event
import com.missclick.webviewdeeplink.data.models.Users
import com.missclick.webviewdeeplink.ui.BaseViewModel
import okhttp3.*
import java.io.IOException

class MainScreenViewModel : BaseViewModel() {
    val simpleLiveData = MutableLiveData<Event<Users>>()

    val BASE_URL = "https://testym.online/"

    fun getUsers(page: Int) {
        requestWithLiveData(simpleLiveData) {
            api.getUsers(
                page = page
            )
        }
        Log.e("users",simpleLiveData.toString())
    }


    fun okHttp(){
        val client = OkHttpClient()
        val reqBody = FormBody.Builder()
            //.add("deeplink_fb", "deep")
            //.add("deeplink_aps", "deep")
            //.add("accelerometer", "243.430")
            .build()
        val req = Request.Builder()
            .url(BASE_URL)
            //.addHeader("GID", "3480834")
            //.addHeader("PackageName", "com.missclick.webviewdeeplink")
            .build()
        val call = client.newCall(req)
        val response = call.enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.e("response", "error")
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                Log.e("response", response.headers.toString())
                Log.e("response", response.code.toString())
                response.body?.string()?.let { Log.e("response", it) }
                //response.body?.string()?.let { Log.e("response", it) }
            }

        })
    }
}