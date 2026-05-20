package blog

//Sets are a collection of pairwise elements of the same type. Two ways to define sets in scala − immutable and mutable.
object SetOperations {

  def main(args: Array[String]): Unit = {

    // This is by default immutable set and also by default removes duplicates
    val countries: Set[String] = Set("India", "China", "Japan", "South Korea", "Switzerland", "India")

    println("Set collection automatically removed duplicate entries:" + countries)

    //  Adding elements creates a new set in immutable set
    val newSet = countries + "Singapore"
    println("This is updated set in a new set:" + newSet)

    //creating a mutable set
    def mutable(arg : Any):Unit ={
      import scala.collection.mutable.Set
      val mutableSet: Set[String] = Set("Cricket", "FootBall", "Judo", "BasketBall")
      println("Original mutable set:" + mutableSet)

      mutableSet.add("Karate")
      println("Updated Mutable Set:" + mutableSet)
    }

    mutable(true)


    val setA: Set[Int] = Set(1, 2, 3)
    val setB: Set[Int] = Set(3, 4, 5)

    // Intersection of set : Returns the common elements among the sets
    val common: Set[Int] = setA & setB   // or  setA.intersection(setB)
    println("Intersetion:" + common)

    // Union of set : Returns the joined version of the sets without duplicating
    val union: Set[Int] = setA | setB   // or setA.union(setB)
    println("Merge :" + union)

    val difference:Set[Int] = setA &~ setB      // or setA.diff(setB)
    println("Difference of sets"+ difference)
  }
}
