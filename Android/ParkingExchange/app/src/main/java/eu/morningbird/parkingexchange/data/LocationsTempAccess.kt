package eu.morningbird.parkingexchange.data

import java.util.*

object LocationsTempAccess {
    fun getLocations(): List<Location> {
        val locations = ArrayList<Location>()
        locations.add(Location("Warsaw Spire, Central Warsaw", 2.5, 50.028716, 19.851650, Date(), Date()))
        locations.add(Location("Warsaw Spire, Central Warsaw", 2.5, 50.028716, 19.851650, Date(), Date()))
        locations.add(Location("Warsaw Spire, Central Warsaw", 2.5, 50.028716, 19.851650, Date(), Date()))
        locations.add(Location("Warsaw Spire, Central Warsaw", 2.5, 50.028716, 19.851650, Date(), Date()))
        locations.add(Location("Warsaw Spire, Central Warsaw", 2.5, 50.028716, 19.851650, Date(), Date()))
        locations.add(Location("Warsaw Spire, Central Warsaw", 2.5, 50.028716, 19.851650, Date(), Date()))

        return locations
    }

    fun getSwapLocations(): List<Location> {
        val locations = ArrayList<Location>()
        locations.add(Location("Warsaw Spire, Central Warsaw", 2.5, 50.028716, 19.851650, Date(), Date()))
        return locations
    }
}