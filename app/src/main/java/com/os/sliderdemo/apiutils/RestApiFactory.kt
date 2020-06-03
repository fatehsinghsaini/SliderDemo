package com.os.sliderdemo.apiutils

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RestApiFactory {

    val BASE_URL = " https://qa-doctor.medcords.com/mhc/"

 fun mCreate():RestApi{

     val httpClient=OkHttpClient.Builder()
     val logLevel= HttpLoggingInterceptor.Level.BODY
     val interceptor=HttpLoggingInterceptor()
     interceptor.level=logLevel

     httpClient.addInterceptor(interceptor)
     httpClient.connectTimeout(120, TimeUnit.SECONDS).readTimeout(120, TimeUnit.SECONDS)

     val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
         .client(httpClient.build())
         .build()
     return retrofit.create(RestApi::class.java)



 }

}