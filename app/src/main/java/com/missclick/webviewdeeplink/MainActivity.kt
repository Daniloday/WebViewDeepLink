package com.missclick.webviewdeeplink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.missclick.webviewdeeplink.data.FbHelp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fb = FbHelp(this).tree()
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navController.navigate(R.id.mainScreenFragment)
    }
}