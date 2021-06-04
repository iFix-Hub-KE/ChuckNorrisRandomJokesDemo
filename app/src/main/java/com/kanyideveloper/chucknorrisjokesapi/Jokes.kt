package com.kanyideveloper.chucknorrisjokesapi


import com.google.gson.annotations.SerializedName

data class Jokes(
    @SerializedName("type")
    val type: String?,
    @SerializedName("value")
    val value: List<Value?>?
) {
    data class Value(
        @SerializedName("categories")
        val categories: List<String?>?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("joke")
        val joke: String?
    )
}