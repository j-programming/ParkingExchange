package eu.morningbird.parkingexchange

import android.app.Application
import android.content.Context

class ParkingExchange : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    companion object {
        var appContext: Context? = null
            private set
    }

}