package blog

object IteratorOperations {

  def main(args:Array[String]):Unit = {
    // Creating an iterator
    /* Iterators are useful when processing massive datasets (like a 10GB log file)
     because they don't load all  elements  into memory at  once  */
    val dummyIterator :Iterator[String] = Iterator("Logs","Metrics","Traces","Alerts")
    println("Original dummyIterator: "+dummyIterator) // It will print this -> Original dummyIterator: <iterator>

    // Checking and advancing
    /* .hasNext checks if there's another item ahead (return boolean)
       .next() grabs the current item and advances the cursor forward */
    println("Checking if  iterator has elements: "+dummyIterator.hasNext)
    println("Grabbing the first element: "+dummyIterator.next())

    // The exhaustion trap
    /* Once we consume an iterator, it is spent. We can't reset it. */
    println("Iterating through the rest using while loop:  ")
    while (dummyIterator.hasNext){
      println("Consumed: "+dummyIterator.next())
    }
    // Now the iterator is empty , it will crash the program if we try to call .next() again
    println("Is iterator empty now ? "+ !dummyIterator.hasNext)

    // Transform combinators on iterators
    /* Just like Lists , Iterators support map, filter, etc.
       But they evaluate LAZILY. Nothing happens until we explicitly consume them   */
    val freshIterator:Iterator[Int] = Iterator(1,2,3,4,5)

    // This doesn't actually double the number yet; it jsu creates a plan to do so.
    val doubleIterator:Iterator[Int] = freshIterator.map(x=>x*2)

    // Converting a concrete collection forces evaluation and consumes  the iterator
    val concreteList:List[Int] = doubleIterator.toList
    println("Forced evaluation to list of doubledIterator: "+concreteList)

    // Creating an iterator from a collection
    /* We can easily turn any collection  into an iterator when we want lazy traversal */
    val numberList:List[Int] = List(10,20,30,40,50)
    val listIterator:Iterator[Int] = numberList.iterator
    println("List converted to iterator first item: "+listIterator.next()) // consumes 10

    /* Note: We can't print Iterator directly like List or vector etc. because it works like lazy val
    * When we print a List, Vector, or Map, we are printing a container that already completely exists in our computer's RAM.
      An Iterator doesn't actually hold any data. It is just a pointer pointing to a data source with a set of
       instructions on how to fetch the next item.*/

  }
}
