package com.rjw.playandroid.model.http

import android.app.PendingIntent.getService
import android.util.Log
import com.rjw.playandroid.model.http.api.PlayApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.AbstractExecutorService
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
        getService(PlayApi::class.java)
    }
    private val myOkHttpClient = OkHttpClient.Builder()
        .callTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .followRedirects(false)//不处理重定向
        .addInterceptor(HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.d(TAG, "log:$message")
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()


    private var mRetrofit: Retrofit? =null

    fun <T>getService(serviceClass: Class<T>):T?{
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