package br.com.gabrielmarcos.digitalnexteltest.services

import android.content.Context
import br.com.gabrielmarcos.digitalnexteltest.models.CitiesModel
import br.com.gabrielmarcos.digitalnexteltest.models.WeatherModel
import br.com.gabrielmarcos.digitalnexteltest.services.helpers.RetrofitHelper
import br.com.gabrielmarcos.digitalnexteltest.services.interfaces.CitiesInterface
import br.com.gabrielmarcos.digitalnexteltest.services.interfaces.WeatherInterface
import br.com.gabrielmarcos.digitalnexteltest.util.Constants
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by Gabriel Marcos on 26/07/2018
 */
class WeatherService(context: Context?): BaseService(context) {

    private val weatherService by lazy {
        RetrofitHelper.getRetrofit().create(WeatherInterface::class.java)
    }

    fun subscrible(successCallback: (response: ArrayList<WeatherModel>) -> Unit,
                   errorCallback: () -> Unit) {
        observable = Observable.interval(Constants.RX_TIME_INTERVAL_IN_SECONDS, TimeUnit.SECONDS)
                .startWith(0)
                .subscribe {
                    weatherService.getWeather()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    { response ->
                                        successCallback(response)
                                    },
                                    { _ ->
                                        errorCallback()
                                    }
                            )
                }
    }
}