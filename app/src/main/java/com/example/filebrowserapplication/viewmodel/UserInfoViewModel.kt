package com.example.filebrowserapplication.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filebrowserapplication.model.UserInfo
import com.example.filebrowserapplication.model.UserInformation
import com.example.filebrowserapplication.model.network.UserApiClient
import com.example.filebrowserapplication.model.network.UserInfoService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class UserInfoViewModel : ViewModel() {

     var apiService= UserInfoService.create()
    val userLiveData = MutableLiveData<ArrayList<UserInformation>>()
    var disposable: Disposable? = null

    fun fetchUserInfo() {
        disposable = apiService.getUserInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                userLiveData.value = it
            }, {error -> print(error.message)})
    }
}