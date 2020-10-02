package com.missclick.webviewdeeplink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.missclick.webviewdeeplink.data.FbHelp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fb = FbHelp(this).tree()
    }
}