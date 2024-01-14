package com.example.weather61

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weather61.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener {
            RetrofitService().api.getWeather(binding.etCity.text.toString())
                .enqueue(object : Callback<WeatherModel> {
                    override fun onResponse(
                        call: Call<WeatherModel>,
                        response: Response<WeatherModel>
                    ) {
                        if (response.isSuccessful) {
                            response.body()?.let {
                                data(it)
//                                binding.tvTemp.text = "${it.main.temp}°"
//                                binding.tvCity.text = "City: ${it.city}"
//                                binding.tvHumidityPercentage.text = "${it.main.humidity}%"
//                                binding.tvSpeed.text = "${it.wind.speed} km/h"
                                /* binding.tvResult.text =
                                     "temp: ${it.main.temp} \nfeelsLike ${it.main.feels_like} \nCity: ${it.name}"*/
                            }
                        }
                    }
                    override fun onFailure(call: Call<WeatherModel>, t: Throwable) {

                    }
                })
        }
    }
    @SuppressLint("SetTextI18n")
    fun data(weatherModel: WeatherModel){
        binding.apply {
            tvTemp.text = "${weatherModel.main.temp}°"
            tvCity.text = "City: ${weatherModel.city}"
            tvHumidityPercentage.text = "${weatherModel.main.humidity}%"
            tvSpeed.text = "${weatherModel.wind.speed} km/h"

        }
    }
}