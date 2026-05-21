package blog

object TupleOperations {

  def main(args:Array[String]):Unit = {
    // Tuple as a fixed-size container that can hold a mix of completely different data types.
    // creating a tuple
    val dummyTuple = (1,"Abi",95.6,true)
    println("Original tuple : "+ dummyTuple )

    // Accessing elements using ._1, ._2, etc.
    // Note: Tuple indexing is 1-BASED, not 0-based
    println("User ID (1st Element): "+dummyTuple._1)
    println("Username (2nd Element): "+dummyTuple._2)
    println("User average score (3rd Element): "+dummyTuple._3)
    println("Is 18+ years old (4th Element): "+dummyTuple._4)

    // Pattern Matching (The idiomatic way to unpack a Tuple)
    // Instead of using ._1 and ._2, we can break it apart instantly:
    val(id , name , average , isAdult) = dummyTuple
    println(s"Unpacked values -> ID: $id, NAME: $name, AVERAGE: $average, IS 18+ : $isAdult")

    // Tuples inside collections
    /* A Map is actually a collection of Tuple2 items under the hood
    * The arrow operator (->) is just a shortcut for  creating Tuple2 */
    val alternativePair: (Int, String) = 1 -> "A" // same as (1,"A")

    val transactions:List[(Int,String)] = List(
      (101, "Success"),
      (102, "Failed"),
      (103, "Success")
    )
    println("List of tuples : "+ transactions)

    // Iterating over a list of tuples using pattern matching
    transactions.foreach{
      case (userId, status) => println(s"User $userId 's transaction was $status .")
    }

    // Returning multiple values from a function
    /* This is where tuples shine. A function can only return ONE thing,
     but that one thing can be a tuple containing multiple values */
     def minAndMax(nums:List[Int]):(Int,Int) ={
       (nums.min,nums.max)
     }
    val scores:List[Int] = List(45,99,64,21,82)
    val(lowest:Int , highest:Int) = minAndMax(scores)
    println(s"Lowest Score : $lowest, Highest Score: $highest")

  }
}
