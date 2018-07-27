package br.com.gabrielmarcos.digitalnexteltest.services.interfaces

import br.com.gabrielmarcos.digitalnexteltest.BuildConfig
import br.com.gabrielmarcos.digitalnexteltest.models.CitiesModel
import retrofit2.http.GET
import io.reactivex.Observable

/**
 * Created by Gabriel Marcos on 26/07/2018
 */
interface CitiesInterface {
    @GET(BuildConfig.URL_CITIES)
    fun getCities(): Observable<ArrayList<CitiesModel>>
}