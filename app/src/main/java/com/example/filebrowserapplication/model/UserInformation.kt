package com.example.filebrowserapplication.model
import com.google.gson.annotations.SerializedName


data class UserInformation(
    @SerializedName("address")
    val address: AddressOne,
    @SerializedName("company")
    val company: CompanyOne,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("website")
    val website: String
)

data class AddressOne(
    @SerializedName("city")
    val city: String,
    @SerializedName("geo")
    val geo: GeoOne,
    @SerializedName("street")
    val street: String,
    @SerializedName("suite")
    val suite: String,
    @SerializedName("zipcode")
    val zipcode: String
)

data class GeoOne(
    @SerializedName("lat")
    val lat: String,
    @SerializedName("lng")
    val lng: String
)

data class CompanyOne(
    @SerializedName("bs")
    val bs: String,
    @SerializedName("catchPhrase")
    val catchPhrase: String,
    @SerializedName("name")
    val name: String
)