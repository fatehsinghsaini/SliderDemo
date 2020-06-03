package com.os.sliderdemo.apiutils

import com.os.sliderdemo.apiutils.requestModel.ClickRequestModel
import com.os.sliderdemo.apiutils.requestModel.ClickResponse
import io.reactivex.Observable

class UserDataSource(private var apiCallInterface: RestApi) {

    fun mTestItem(btName: ClickRequestModel): Observable<ClickResponse> {
        return apiCallInterface.mTestItem(btName)
    }


}