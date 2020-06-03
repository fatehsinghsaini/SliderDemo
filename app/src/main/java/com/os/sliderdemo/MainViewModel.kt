package com.os.sliderdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.os.sliderdemo.apiutils.requestModel.ApiResponse
import com.os.sliderdemo.apiutils.RestApiFactory
import com.os.sliderdemo.apiutils.UserDataSource
import com.os.sliderdemo.apiutils.requestModel.ClickRequestModel
import com.os.sliderdemo.apiutils.requestModel.ClickResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {


    val mResponseLiveData=MutableLiveData<ApiResponse<ClickResponse>>()
    private var restApiFactory: RestApiFactory? = null
    private var userDataSource: UserDataSource? = null
    var apiResponse: ApiResponse<ClickResponse>? = null


    private var subscription: Disposable? = null


    init {
        restApiFactory = RestApiFactory
        userDataSource = UserDataSource(restApiFactory!!.mCreate())
        apiResponse = ApiResponse(
            ApiResponse.Status.LOADING,
            null,
            null
        )
    }


    fun mApiCalling(btName:String) {
        val mRequest=ClickRequestModel(btName)

        subscription = userDataSource!!.mTestItem(mRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { d ->
                mResponseLiveData.postValue(apiResponse!!.loading())
            }
            .subscribe(
                { result ->
                    mResponseLiveData.postValue(apiResponse!!.success(result))
                },
                { throwable ->
                    mResponseLiveData.postValue(apiResponse!!.error(throwable))
                }
            )

    }

}