package com.example.weather61

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
//    https://api.openweathermap.org/data/2.5/weather?q=Bishkek&appid=bdb2917eb8179d50d760b162dcdc2e24&units=metric

    var retrofit = Retrofit.Builder().baseUrl("https://api.openweathermap.org/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    var api = retrofit.create(WeatherAPI::class.java)
}