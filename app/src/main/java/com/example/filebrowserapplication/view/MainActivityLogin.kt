package com.example.filebrowserapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.filebrowserapplication.R
import com.example.filebrowserapplication.model.network.UserInfoService
import com.example.filebrowserapplication.viewmodel.UserInfoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivityLogin : AppCompatActivity() {

    lateinit var viewModel: UserInfoViewModel
    var listOfEmails = ArrayList<String>()
    var listOfZipCodes = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(UserInfoViewModel::class.java)

        viewModel.fetchUserInfo()


        observeViewModel()



        btn_login.setOnClickListener {

            var counter = 0

            if (et_Username != null && et_ZipCode != null) {


                for (i in 0 until listOfEmails.size){
                    if (et_Username.text.toString() == listOfEmails[i] &&
                            et_ZipCode.text.toString() == listOfZipCodes[i]){
                        counter++
                        break
                    }
                }

                if (counter>0){
                    Toast.makeText(this,"Found a match",Toast.LENGTH_LONG).show()
                } else{
                    Toast.makeText(this,"No match Found",Toast.LENGTH_LONG).show()
                }
            }
        }

        btn_cancel.setOnClickListener {
            et_Username.text.clear()
            et_ZipCode.text.clear()
        }

    }

    fun observeViewModel(){

        viewModel.userLiveData.observe(this, Observer {
            val test = it.get(0).email

            for(i in 0..it.lastIndex){

                listOfEmails.add(it.get(i).email)
                listOfZipCodes.add(it.get(i).address.zipcode)
            }

             Log.d("TagOne", listOfEmails.size.toString())
            // Log.d("TagTwo",listOfZipCodes.size.toString())
             Log.d("TagThree", it.lastIndex.toString())
        })
    }
}
