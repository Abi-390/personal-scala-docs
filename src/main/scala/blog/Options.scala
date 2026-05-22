package blog

object Options {

  def main(args:Array[String]):Unit = {

    // Creating Options
    /* Wrap a real value in Some, and use None for missing data */
    val capitalsOfIndia:Option[String] = Some("Delhi")
    val capitalOfMars:Option[String] = None

    println("Existing Option: "+capitalsOfIndia)
    println("Missing Option: "+capitalOfMars)

    // The safe way to handle nulls
    /* If we pass a raw value that might be null into Option(..),Scala automatically turns null
       into None, and the real data into Some  */
    val rawNull:String = null
    val safeNullResult:Option[String] = Option(rawNull)  // automatically becomes None
    println("Safely wrapped null variable: " +safeNullResult)

    // Unpacking Options with pattern matching
    /* Safe way to extract values */
    def printCapital(country:String,capitalOption:Option[String]):Unit ={
        capitalOption match {
          case Some(city) => println(s"Capital of the country $country is city $city")
          case None => println(s"We don't know the capital of $country yet.")
        }
    }
    printCapital("India",capitalsOfIndia)
    printCapital("Mars",capitalOfMars)

    // Unpacking Options with Fallbacks (.getOrElse)
    /* Instead of full pattern matching, we can instantly extract the value or fall back to a default
       value if it's None.    */
    val finalCapital:String = capitalOfMars.getOrElse("Unknown Capital")
    println("Fallback result using getOrElse :"+finalCapital)

    // Options behave like collections ( the real benefit )
    /* Because Option act like a tiny list(size 0 or size 1) we can use map or filter. If the option is
       None , .map safely does absolutely nothing.  */
    val upperIndia:Option[String] = capitalsOfIndia.map(city => city.toUpperCase)
    val upperMars:Option[String] = capitalOfMars.map(city => city.toUpperCase())

    println("Mapped existing value: "+upperIndia)   // Some( DELHI )
    println("Mapped missing value: "+upperMars)     // None  ----> No crash

    /* Important notes :- We should never use .get. There's a method called option.get. If we call .get on a None
       the program will crash instantly defeating the entire purpose of using Option. We should always use pattern
       matching or getOrElse or combinations(map/filter).
    */
  }
}
