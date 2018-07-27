package br.com.gabrielmarcos.digitalnexteltest.services.interfaces

import br.com.gabrielmarcos.digitalnexteltest.BuildConfig
import br.com.gabrielmarcos.digitalnexteltest.models.DetailWeatherModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Gabriel Marcos on 26/07/2018
 */
interface DetailWeatherInterface {
    @GET(BuildConfig.URL_SPECIFICATION)
    fun getDetailWeather(@Path("id") id: String,
                         @Path("ano") ano: String): Observable<ArrayList<DetailWeatherModel>>
}