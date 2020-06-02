package com.os.sliderdemo.apiutils

import retrofit2.http.POST

interface RestApi {
    @POST("test_handle_click")
    fun mTestItem()

}