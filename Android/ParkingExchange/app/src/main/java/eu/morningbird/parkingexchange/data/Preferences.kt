package eu.morningbird.parkingexchange.data

import android.content.SharedPreferences
import android.preference.PreferenceManager
import eu.morningbird.parkingexchange.ParkingExchange

object Preferences {
    private val PREFS_FILENAME = "eu.morningbird.parkingexchange.preferences"
    private val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(ParkingExchange.appContext)
    private val editor = prefs.edit()

    public var userToken: String?
        get() {
            return prefs.getString("user-token", null)
        }
        set(value) {

            editor.putString("user-token", value)
            editor.apply()
        }

}