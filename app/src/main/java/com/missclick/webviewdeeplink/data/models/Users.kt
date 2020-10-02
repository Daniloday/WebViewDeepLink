package com.missclick.webviewdeeplink.data.models

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("count")
    var count: Int?,
    @SerializedName("items")
    var items: List<Item?>?
) {
    data class Item(
        @SerializedName("first_name")
        var firstName: String?,
        @SerializedName("last_name")
        var lastName: String?
    )
}