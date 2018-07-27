package br.com.gabrielmarcos.digitalnexteltest.services

import android.content.Context
import br.com.gabrielmarcos.digitalnexteltest.models.CitiesModel
import br.com.gabrielmarcos.digitalnexteltest.models.DetailWeatherModel
import br.com.gabrielmarcos.digitalnexteltest.services.helpers.RetrofitHelper
import br.com.gabrielmarcos.digitalnexteltest.services.interfaces.DetailWeatherInterface
import br.com.gabrielmarcos.digitalnexteltest.util.Constants
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by Gabriel Marcos on 26/07/2018
 */
class DetailWeatherService(context: Context?): BaseService(context) {

    private val detailWeatherService by lazy {
        RetrofitHelper.getRetrofit().create(DetailWeatherInterface::class.java)
    }

    fun subscrible(id: String,
                   year: String,
                   successCallback: (response: ArrayList<DetailWeatherModel>) -> Unit,
                   errorCallback: () -> Unit) {

        observable = Observable.interval(Constants.RX_TIME_INTERVAL_IN_SECONDS, TimeUnit.SECONDS)
                .startWith(0)
                .subscribe {
                    detailWeatherService.getDetailWeather(id, year)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    { response ->
                                        successCallback(response) },
                                    { _ ->
                                        errorCallback() }
                            )
                }
    }

}