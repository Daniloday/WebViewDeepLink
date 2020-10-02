package com.missclick.webviewdeeplink.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.missclick.webviewdeeplink.data.models.Event
import com.missclick.webviewdeeplink.data.models.Users
import com.missclick.webviewdeeplink.ui.BaseViewModel

class MainScreenViewModel : BaseViewModel() {
    val simpleLiveData = MutableLiveData<Event<Users>>()

    fun getUsers(page: Int) {
        requestWithLiveData(simpleLiveData) {
            api.getUsers(
                page = page
            )
        }
        Log.e("users",simpleLiveData.toString())
    }
}