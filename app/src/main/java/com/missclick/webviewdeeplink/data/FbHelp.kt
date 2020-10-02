package com.missclick.webviewdeeplink.data

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.browser.customtabs.CustomTabsIntent
import com.facebook.applinks.AppLinkData

class FbHelp(val context: Context) {

     fun tree() {
        AppLinkData.fetchDeferredAppLinkData(context
        ) { appLinkData: AppLinkData? ->
            if (appLinkData != null && appLinkData.targetUri != null) {
                if (appLinkData.argumentBundle["target_url"] != null) {
                    //Msg().messageSchedule(context)
                    Log.e("DEEP", "SRABOTAL")
                    val tree = appLinkData.argumentBundle["target_url"].toString()
                }
            }
        }
    }
}