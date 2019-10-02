package com.example.filebrowserapplication.model

import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("id") val id: Int?,
    @SerializedName("username") val username: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("address") val address: ArrayList<Address>?
)

data class Address(
    @SerializedName("street") val street: String?,
    @SerializedName("suite") val suite: String?,
    @SerializedName("city") val city: String?,
    @SerializedName("zipcode") val zipcode: String?,
    @SerializedName("geo") val geo: ArrayList<Geo>?,
    @SerializedName("company") val company: ArrayList<Company>?
)

data class Geo(
    @SerializedName("lat") val lat: Float?,
    @SerializedName("lng") val lng: Float?
)

data class Company(
    @SerializedName("bs") val bs: String?,
    @SerializedName("catchPhrase") val catchPhrase: String?,
    @SerializedName("name") val nameTwo: String
)