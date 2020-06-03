package com.os.sliderdemo.apiutils

import com.os.sliderdemo.apiutils.requestModel.ClickRequestModel
import com.os.sliderdemo.apiutils.requestModel.ClickResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RestApi {
    @POST("test_handle_click")
    fun mTestItem(@Body btName: ClickRequestModel):io.reactivex.Observable<ClickResponse>



}