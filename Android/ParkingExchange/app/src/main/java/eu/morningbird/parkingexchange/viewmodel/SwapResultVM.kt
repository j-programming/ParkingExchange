package eu.morningbird.parkingexchange.viewmodel

import android.content.Context
import android.content.Intent
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.View
import com.android.databinding.library.baseAdapters.BR
import eu.morningbird.parkingexchange.R
import eu.morningbird.parkingexchange.data.Location
import eu.morningbird.parkingexchange.view.MainActivity
import java.util.concurrent.locks.ReentrantLock

class SwapResultVM : BaseObservable() {
    @Suppress("PrivatePropertyName", "unused")
    private val TAG: String = "FrindResultVM"


    @Bindable
    var name: String = "Warsaw Spire"
        private set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    @Bindable
    var location: String = "0, 0"
        private set(value) {
            field = value
            notifyPropertyChanged(BR.location)
        }

    @Bindable
    var price: String = "$2.5/h"
        private set(value) {
            field = value
            notifyPropertyChanged(BR.price)
        }

    @Bindable
    var time: String = "From 9 AM to 2 PM"
        private set(value) {
            field = value
            notifyPropertyChanged(BR.time)
        }


    private var context: Context? = null

    private val lock = ReentrantLock()

    @Volatile
    var isDataLoaded: Boolean = false
        private set

    fun loadData(plant: Location) {
        val runnable = Runnable {
            lock.lock()
            try {
                isDataLoaded = true
                notifyChange()
            } finally {
                lock.unlock()
            }
        }
        Thread(runnable).start()
    }

    fun attach(context: Context) {
        if (context is MainActivity) {
            this.context = context
        } else {
            throw TypeCastException("Invalid context type for this view model")
        }
    }


}