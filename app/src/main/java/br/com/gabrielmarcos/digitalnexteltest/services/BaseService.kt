package br.com.gabrielmarcos.digitalnexteltest.services

import android.content.Context
import io.reactivex.disposables.Disposable

/**
 * Created by Gabriel Marcos on 26/07/2018
 */
open class BaseService(val context: Context?) {

    var observable: Disposable? = null

    fun unsubscribe() {
        observable?.dispose()
    }
}