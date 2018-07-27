package br.com.gabrielmarcos.digitalnexteltest.services.interfaces

import br.com.gabrielmarcos.digitalnexteltest.BuildConfig
import br.com.gabrielmarcos.digitalnexteltest.models.WeatherModel
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Gabriel Marcos on 26/07/2018
 */
interface WeatherInterface {
    @GET(BuildConfig.URL_WEATHER)
    fun getWeather(): Observable<ArrayList<WeatherModel>>
}