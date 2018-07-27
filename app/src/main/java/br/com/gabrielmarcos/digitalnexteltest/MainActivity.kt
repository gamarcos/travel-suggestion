package br.com.gabrielmarcos.digitalnexteltest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.gabrielmarcos.digitalnexteltest.services.CitiesService
import br.com.gabrielmarcos.digitalnexteltest.services.DetailWeatherService
import br.com.gabrielmarcos.digitalnexteltest.services.WeatherService

class MainActivity : AppCompatActivity() {

    private lateinit var citiesService: CitiesService
    private lateinit var detailWeatherService: DetailWeatherService
    private lateinit var weatherService: WeatherService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        setupRequestCities()
//        setupRequestDetailWeather()
//        setupRequestWeather()
    }

    private fun setupRequestWeather() {
        weatherService = WeatherService(this)

        weatherService.subscrible({weatherModel ->
            if (weatherModel != null) {
                print(weatherModel)
            }
        },{
            Toast.makeText(this, "ERROR: REQUEST", Toast.LENGTH_LONG).show()
        })
    }

    private fun setupRequestDetailWeather() {
        detailWeatherService = DetailWeatherService(this)

        detailWeatherService.subscrible("455827","2017", { detailWeatherServiceModel ->
            if (detailWeatherServiceModel != null) {
                print(detailWeatherServiceModel)
            }
        },{
            Toast.makeText(this, "ERROR: REQUEST", Toast.LENGTH_LONG).show()
        })
    }

    private fun setupRequestCities() {
        citiesService = CitiesService(this)

        citiesService.subscrible({citiesModel ->
            if (citiesModel != null) {
                print(citiesModel)
            }
        },{
            Toast.makeText(this, "ERROR: REQUEST", Toast.LENGTH_LONG).show()
        })
    }
}
