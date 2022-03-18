package main

import java.time.Instant
import java.time.format.DateTimeFormatter
import java.time.ZoneId
import java.time.Clock


trait AnimalBase {
    def name: String
    def animalType: String
    def dateCreated: Instant
}

class Animal(val name:String, val animalType: String) extends AnimalBase {
    val dateCreated: Instant = Instant.now(Clock.systemUTC())
}

