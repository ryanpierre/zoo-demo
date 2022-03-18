## Receipt Printer

For this challenge you'll have to:
[x] Create a new Scala project, adding a testing library as a dependency
[x] Create a ReceiptPrinter class (see skeleton code below)
[ ] Use TDD to write the code of the receipt method
[ ] Create private methods to extract some logic from the receipt method

**stretch**
Use TDD to create a new class called Till which takes a CafeDetail instance at initialisation.
It should have methods that
[ ] Show the menu
[ ] Allow the user to add an item to their order or throw an error if what they enter is not on the menu
[ ] Finalise the order and print the statement (by calling on the receipt printer)

Use the resources provided and your own research to get to a working solution.

Here are some skeleton files:
```scala
// src/main/scala/ReceiptPrinter.scala
class CafeDetails (
  val shopName: String,
  val address: String,
  val phone: String,
  val prices: Map[String, Double]
)
class ReceiptPrinter(val cafe: CafeDetails, var order: Map[String, Int] = Map()) {
  /**
   * This method should return a multiline string
   * representing a ReceiptPrinter receipt that should show
   * - shop name, address, phone number
   * - the date and time the receipt was created
   * - each item in the order, with the price. eg:
   *     2 x Blueberry Muffin       8.10
   *     1 x Cappuccino             3.85
   * - the total price
   * - the VAT (20% of total price)
   */
  def receipt: String = {
    cafe.shopName
  }
}
```

```scala
// src/test/scala/ReceiptPrinterTest.scala
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
class ReceiptPrinterSpec extends AnyWordSpec with Matchers {
  val coffeeConnectionCafe = new CafeDetails(
    "The Coffee Connection",
    "123 Lakeside Way",
    "16503600708",
    Map(
      "Cafe Latte" -> 4.75,
      "Flat White" -> 4.75,
      "Cappuccino" -> 3.85,
      "Single Espresso" -> 2.05,
      "Double Espresso" -> 3.75,
      "Americano" -> 3.75,
      "Cortado" -> 4.55,
      "Tea" -> 3.65,
      "Choc Mudcake" -> 6.40,
      "Choc Mousse" -> 8.20,
      "Affogato" -> 14.80,
      "Tiramisu" -> 11.40,
      "Blueberry Muffin" -> 4.05,
      "Chocolate Chip Muffin" -> 4.05,
      "Muffin Of The Day" -> 4.55
    )
  )
  "A ReceiptPrinter" should {
    "format a receipt" which {
      "contains the name of the cafe" in {
        val printer = new ReceiptPrinter(
          coffeeConnectionCafe,
          Map("Cafe Latte" -> 1)
        )
        printer.receipt should include ("The Coffee Connection")
      }
      // add more tests here.
    }
  }
}
```

**Note:** You'll notice the style of testing is slightly different in these files. In the last step we have used the `funsuite` style, but as a developer, you'll have to adapt to the style that you team is using. Here we chose the`AnyWordSpec` style, which might be closer to what you'll use on the job.

## Resources:

* [A build.sbt reference file](https://github.com/scala/hello-world.g8/blob/main/src/main/g8/build.sbt)
* [Scala classes](https://docs.scala-lang.org/tour/classes.html)
* [Overview of testing styles in scalatest](https://www.scalatest.org/user_guide/selecting_a_style).
* [Using should matchers](https://www.scalatest.org/user_guide/using_matchers)
* [Using the Map data structure](https://docs.scala-lang.org/overviews/collections/maps.html#operations-in-class-map) (this is a structure similar to ruby hashes)
* [Using mocks in ScalaTest](https://www.scalatest.org/user_guide/testing_with_mock_objects)