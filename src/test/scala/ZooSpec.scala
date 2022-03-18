
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalamock.scalatest.MockFactory
import main.{Zoo, AnimalBase}
import scala.collection.mutable.ArrayBuffer
import java.time.Instant

class ZooSpec extends AnyWordSpec with Matchers with MockFactory {
    "A Zoo" should {
        "Print the list of animals" which {
            "Prints them in order of date created" in {
                val mockAnimal1 = mock[AnimalBase]
                val mockAnimal2 = mock[AnimalBase]
                val mockAnimal3 = mock[AnimalBase]
                val mockAnimals = ArrayBuffer(mockAnimal1, mockAnimal2, mockAnimal3)

                (() => mockAnimal1.name)
                .stubs()
                .returning("Fido")

                (() => mockAnimal2.name)
                .stubs()
                .returning("Steve")

                (() => mockAnimal3.name)
                .stubs()
                .returning("Milo")

                (() => mockAnimal1.animalType)
                .stubs()
                .returning("Dog")

                (() => mockAnimal2.animalType)
                .stubs()
                .returning("Cow")

                (() => mockAnimal3.animalType)
                .stubs()
                .returning("Capybara")

                (() => mockAnimal1.dateCreated)
                .stubs()
                .returning(Instant.parse("2022-03-18T01:00:00.00Z"))

                (() => mockAnimal2.dateCreated)
                .stubs()
                .returning(Instant.parse("2022-04-22T01:00:00.00Z"))

                (() => mockAnimal3.dateCreated)
                .stubs()
                .returning(Instant.parse("2022-03-19T01:00:00.00Z"))

                val z = new Zoo(mockAnimals)
                val report = z.printAnimalReport()

                report shouldEqual f"""Date                |Name        |Type
                                      |18/03/2022 01:00    |Fido        |Dog
                                      |19/03/2022 01:00    |Milo        |Capybara
                                      |22/04/2022 01:00    |Steve       |Cow
                                    """.stripMargin
            }
        }
    }
}