package blog

object VectorOperations {



  def main(args:Array[String]):Unit = {

    val dummyVector:Vector[String] = Vector("Red","Green","Blue")

    println("Original Vector"+dummyVector)

    println("Accessing the second user of index 1 :"+ dummyVector(1))

    val addToBack:Vector[String] = dummyVector :+ "Pink"

    println("New Vector after added element to back:"+addToBack)

    val addToFront:Vector[String] = "White" +: dummyVector

    println("New Vector after added element to front:"+addToFront)

    val updatedVector:Vector[String] = dummyVector.updated(2,"Black") // updated dummyVector index 2 element blue to black
    println("Updated  dummy vector:"+updatedVector)

    //Note : Vector inherits all methods used in List (map , filter, fold etc.)

  }


}
