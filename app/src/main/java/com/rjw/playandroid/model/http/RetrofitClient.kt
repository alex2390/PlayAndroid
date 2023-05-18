package com.rjw.playandroid.model.http

import android.util.Log
import com.rjw.playandroid.model.http.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Des  retrofitClient
 *
 *
 * Created by renjiawen on 2023/4/11 22:58.
 */
object RetrofitClient {
    private const val TAG = "RetrofitClient"


    val service by lazy {
        getService(ApiService::class.java)
    }
    private val myOkHttpClient = OkHttpClient.Builder()
        .callTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .followRedirects(false)//不处理重定向
        .addInterceptor(HttpLoggingInterceptor {
                message -> Log.d(TAG, "log:$message")
        }.setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()


    private var mRetrofit: Retrofit? =null

    private fun <T>getService(serviceClass: Class<T>):T?{
        if (mRetrofit==null){
            mRetrofit =Retrofit.Builder()
                .baseUrl(UrlConstants.BASE_URL)
                .client(myOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return mRetrofit?.create(serviceClass)

    }





}