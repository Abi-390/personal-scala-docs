package blog

object OpaqueTypes {

  object SocialNetwork {
    opaque type Name = String
    //Name == String --> Name is a type of type string that's initial is a capital letter

    // 1- companion object
    object Name {
      def fromString(s:String):Option[Name]=
        if(s.isEmpty || s.charAt(0).isLower) None else Some(s)
    }

    // 2- extension method
    extension (n:Name){
      def length:Int = n.length // on the  String class
    }

  }

  import SocialNetwork._

  // outside of the scope, Name != String
  // val name: Name = "Abi" --> will not compile





  def main(args:Array[String]):Unit = {

    val nameOption = Name.fromString("Abi") // Some("Abi")
    nameOption.foreach(println)

    val abiNameLengthOption = nameOption.map(_.length)
    abiNameLengthOption.foreach(println)

  }

}
