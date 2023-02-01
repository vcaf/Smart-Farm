package com.avansb.smartfarm.networking

import com.avansb.smartfarm.gasmodule.GasService
import com.avansb.smartfarm.networking.services.*
import com.avansb.smartfarm.networking.services.AirService
import com.avansb.smartfarm.networking.services.Constants.Companion.BASE_URL_Heroku
import com.avansb.smartfarm.networking.services.CropService
import com.avansb.smartfarm.networking.services.SoilService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val moshi:Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
val okHttpClient:OkHttpClient = OkHttpClient.Builder().connectTimeout(20,TimeUnit.SECONDS)
    .writeTimeout(20,TimeUnit.SECONDS)
    .readTimeout(30,TimeUnit.SECONDS)
    .build()

object WebAccessKtor {
       private val retrofit by lazy{
        Retrofit.Builder()
                .baseUrl("Https://smartfarm-backend.herokuapp.com/api/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(okHttpClient)
                .build()
    }
    val cropApi: CropService = retrofit.create(CropService::class.java)
    val cropStateApi: CropStateService = retrofit.create(CropStateService::class.java)
    val soilApi: SoilService = retrofit.create(SoilService::class.java)
    val dataApi: FieldDataService = retrofit.create(FieldDataService::class.java)
    val fieldApi: FieldService = retrofit.create(FieldService::class.java)
    val gasApi: GasService = retrofit.create(GasService::class.java)
    val windApi: WindService = retrofit.create(WindService::class.java)
    val airApi: AirService = retrofit.create(AirService::class.java)
}

object WebAccessSpring{
    private val retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(BASE_URL_Heroku)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
    }
    val apiAir: AirService by lazy {
        retrofit.create(AirService::class.java)
    }
//        val kpnApi = retrofit.create(KpnRepo::class.java)
//        val airApi = retrofit.create(AirRepo::class.java)
//        val airsApi = retrofit.create(AirRepos::class.java)
}



