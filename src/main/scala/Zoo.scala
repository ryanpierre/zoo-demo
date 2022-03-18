package main

import scala.collection.mutable.ArrayBuffer

import java.time.Instant
import java.time.format.DateTimeFormatter
import java.time.ZoneId
import java.time.Clock

// Print without variable inbar's experiment

class Zoo(val animals: ArrayBuffer[AnimalBase] = new ArrayBuffer[AnimalBase]()) {
    private val formatter = DateTimeFormatter
    .ofPattern("dd/MM/yyyy HH:mm")
    .withZone(ZoneId.of("UTC"));

    def printHeader(): String = {
        return f"${"Date"}%-20s|${"Name"}%-12s|${"Type"}%-12s"
    }

    def animalToLine(animal: AnimalBase): String = {
        return f"${formatter.format(animal.dateCreated)}%-20s|${animal.name}%-12s|${animal.animalType}%-12s"
    }

    def sortByDate(elem1: AnimalBase, elem2: AnimalBase) = {
        elem1.dateCreated.isBefore(elem2.dateCreated)
    }

    def printAnimalReport():String = { 
        println(f"""${printHeader()}
                   |${animals.sortWith(sortByDate).map(animalToLine).mkString("\n")}
        """.stripMargin)

        return f"""${printHeader()}
        |${animals.sortWith(sortByDate).map(animalToLine).mkString("\n")}
        """.stripMargin
    }
}