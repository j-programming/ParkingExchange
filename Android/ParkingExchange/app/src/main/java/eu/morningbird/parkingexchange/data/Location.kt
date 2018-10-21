package eu.morningbird.parkingexchange.data

import java.util.*

data class Location(
    var name : String,
    var price : Double,
    var lon: Double,
    var lat: Double,
    var availabilityStart: Date,
    var availabilityEnd: Date
    )