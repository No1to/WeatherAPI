package com.example.weather61

import com.google.gson.annotations.SerializedName

data class WeatherModel(
    var main: MainModel,
    var wind: WindModel,
    @SerializedName("name")
    var city: String,
)

data class WindModel(
    var speed: Double
)

data class MainModel(
    var temp: Double,
    @SerializedName("feels_like")
    var feelsLike: Double,
    var humidity: Int,
)
/*
{
    "coord": {
    "lon": 74.59,
    "lat": 42.87
},
    "weather": [
    {
        "id": 804,
        "main": "Clouds",
        "description": "overcast clouds",
        "icon": "04d"
    }
    ],
    "base": "stations",
    "main": {
    "temp": 7.11,
    "feels_like": 5.3,
    "temp_min": 7.11,
    "temp_max": 7.11,
    "pressure": 1014,
    "humidity": 51,
    "sea_level": 1014,
    "grnd_level": 926
},
    "visibility": 10000,
    "wind": {
    "speed": 2.63,
    "deg": 296,
    "gust": 3.8
},
    "clouds": {
    "all": 100
},
    "dt": 1705224402,
    "sys": {
    "type": 1,
    "id": 8871,
    "country": "KG",
    "sunrise": 1705199427,
    "sunset": 1705232991
},
    "timezone": 21600,
    "id": 1528675,
    "name": "Bishkek",
    "cod": 200
}*/
