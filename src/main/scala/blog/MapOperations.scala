package blog

object MapOperations {

  def main(args:Array[String]):Unit = {

    val dummyMap: Map[Int,String] = Map(
         1 -> "A",
         2 -> "B",
         3 -> "C"
    )

    println("Original dummyMap:"+ dummyMap)

    // Safe value look up using get which returns an option (some/none)
    val getItem:Option[String] = dummyMap.get(1)
    println("Item with key 1 :"+ getItem)

    val notGetItem:Option[String] = dummyMap.get(0)
    println("Item with key 0 :"+notGetItem)

    //Fallback lookup using getOrElse
    //Instantly unpacks the value  or provides a default if key doesn't exist
    val getItemOrFallback = dummyMap.getOrElse(5,"Unknown Value")
    println("Item with key 5 :"+getItemOrFallback)

    // Adding or updating elements
    // Since its immutable , this returns  a brand-new Map instance using set-style hash tree
    val updatedDummyMap:Map[Int, String] = dummyMap + (3 -> "D")
    println("Updated DummyMap:"+updatedDummyMap)

    val extendedDummyMap:Map[Int,String] = dummyMap + (4 -> "E")
    println("Extended DummyMap:"+extendedDummyMap)

    // Removing elements
    val removeElement:Map[Int,String] = dummyMap - 1
    println("Map after removing element with key 1 :"+removeElement)

    //Extracting keys and values separately
    println("All keys of original map :"+dummyMap.keys) //Note: .keys returns a Set because keys are unique.
    println("All values of original map:"+dummyMap.values) //.values returns an Iterable because values can contain duplicates!

    //creating a mutable map
    //Note: Printing mutable.Map explicitly shows 'HashMap'
    // because the mutable package bypasses small-class optimization
    // and immediately deploys a real concrete HashMap on the heap.
    import scala.collection.mutable
    val mutableMap = mutable.Map("session_1" -> "active")
    println("Mutable cache:"+mutableMap)

    //Iterating over a map
    println("Printing the dummy map with foreach :")
    dummyMap.foreach{
      case (key,value) => println(s"$key -> $value")
    }

    // Safely transforming Map values without touching keys
    // Note: Use .view.mapValues in modern Scala to avoid mutating eagerly
    val incrementedMap = dummyMap.view.mapValues(value => value + "!").toMap
    println(s"Transformed values: $incrementedMap")

    // Creating a map with a built-in fallback
    val mapWithFallback = Map(1 -> "Admin").withDefaultValue("Guest")
    println(s"Key 99 yields default: ${mapWithFallback(99)}") // Prints "Guest" instead of crashing

  }
}
